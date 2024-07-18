package dev.canverse.workflow.workflows;

import dev.canverse.workflow.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("specialProductWorkflow")
@RequiredArgsConstructor
public class SpecialProductWorkflow implements Workflow<Product> {
    @Override
    public void execute(Product product) {
        System.out.println("Executing Special Product Workflow for product: " + product.getName());
    }
}
