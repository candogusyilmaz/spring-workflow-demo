package dev.canverse.workflow.repositories;

import dev.canverse.workflow.entities.WorkflowConfiguration;
import dev.canverse.workflow.entities.WorkflowConfigurationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkflowConfigurationRepository extends JpaRepository<WorkflowConfiguration, WorkflowConfigurationId>, JpaSpecificationExecutor<WorkflowConfiguration> {

    @Query("SELECT wc FROM WorkflowConfiguration wc WHERE wc.id.entityId = ?2 AND wc.id.entityType = ?1")
    Optional<WorkflowConfiguration> find(String entityName, Long entityId);
}