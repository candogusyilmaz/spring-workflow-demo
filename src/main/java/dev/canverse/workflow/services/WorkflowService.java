package dev.canverse.workflow.services;

import dev.canverse.workflow.entities.WorkflowDefinition;
import dev.canverse.workflow.repositories.WorkflowConfigurationRepository;
import dev.canverse.workflow.repositories.WorkflowDefinitionRepository;
import dev.canverse.workflow.workflows.Workflow;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class WorkflowService {
    private final WorkflowConfigurationRepository workflowConfigurationRepository;
    private final WorkflowDefinitionRepository workflowDefinitionRepository;
    private final ApplicationContext context;

    public <T> Workflow getWorkflow(T entity, String event) {
        try {
            var id = (Long) entity.getClass().getMethod("getId").invoke(entity);

            var workflowConfiguration = workflowConfigurationRepository.find(entity.getClass().getSimpleName(), id, event)
                    .orElseThrow(() -> new RuntimeException("Workflow not found"));

            return context.getBean(workflowConfiguration.getWorkflow().getId(), Workflow.class);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public <T, R> Workflow<R> getWorkflow(T entity, String event, Class<R> dataType) {
        return getWorkflow(entity, event);
    }

    public <T, R> void executeWorkflow(T entity, String event, R data) {
        getWorkflow(entity, event).execute(data);
    }

    public void synchronize(Set<String> workflowNames) {
        //get the workflow definitons in database
        var workflowDefinitions = workflowDefinitionRepository.findAll().stream().map(WorkflowDefinition::getId).toList();

        // find the difference between the workflow definitions in the database and the workflow names
        var toBeDeleted = workflowDefinitions.stream().filter(w -> !workflowNames.contains(w)).toList();
        var toBeAdded = workflowNames.stream().filter(w -> !workflowDefinitions.contains(w)).toList();

        workflowDefinitionRepository.deleteAllByIdInBatch(toBeDeleted);
        workflowDefinitionRepository.saveAllAndFlush(toBeAdded.stream().map(WorkflowDefinition::new).toList());
    }
}
