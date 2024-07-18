package dev.canverse.workflow.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public record WorkflowConfigurationId(Long entityId, String entityType) {
}
