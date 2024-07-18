package dev.canverse.workflow.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "workflow_definitions")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class WorkflowDefinition {
    @Id
    private String id;
}
