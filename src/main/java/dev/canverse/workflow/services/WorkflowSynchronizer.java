package dev.canverse.workflow.services;

import dev.canverse.workflow.workflows.Workflow;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class WorkflowSynchronizer implements ApplicationListener<ApplicationReadyEvent> {
    private final ApplicationContext context;
    private final WorkflowService workflowService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Map<String, Workflow> beansOfType = context.getBeansOfType(Workflow.class);
        workflowService.synchronize(beansOfType.keySet());
    }
}
