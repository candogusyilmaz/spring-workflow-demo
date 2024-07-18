package dev.canverse.workflow.workflows;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("defaultProductWorkflow")
@RequiredArgsConstructor
public class DefaultProductWorkflow implements Workflow {
    @Override
    public void execute() {
        System.out.println("Executing Default Product Workflow");
    }
}
