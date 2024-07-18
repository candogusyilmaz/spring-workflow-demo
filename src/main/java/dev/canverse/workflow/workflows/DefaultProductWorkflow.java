package dev.canverse.workflow.workflows;

import dev.canverse.workflow.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("defaultProductWorkflow")
@RequiredArgsConstructor
public class DefaultProductWorkflow implements Workflow<Product> {
    @Override
    public void execute(Product product) {
        System.out.println("Executing Default Product Workflow for product: " + product.getName());
    }
}
