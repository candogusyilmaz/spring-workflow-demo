package dev.canverse.workflow.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "workflow_configurations")
@Entity
@NoArgsConstructor
public class WorkflowConfiguration {
    @EmbeddedId
    private WorkflowConfigurationId id;

    @ManyToOne(optional = false)
    private WorkflowDefinition workflow;

    private String event;
}
