package dev.canverse.workflow.workflows;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("specialProductWorkflow")
@RequiredArgsConstructor
public class SpecialProductWorkflow implements Workflow {
    @Override
    public void execute() {
        System.out.println("Executing Special Product Workflow");
    }
}
