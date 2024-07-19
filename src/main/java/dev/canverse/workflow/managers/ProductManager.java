package dev.canverse.workflow.managers;

import dev.canverse.workflow.entities.Product;
import dev.canverse.workflow.entities.ProductEvent;
import dev.canverse.workflow.repositories.ProductRepository;
import dev.canverse.workflow.services.WorkflowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductManager {
    private final ProductRepository productRepository;
    private final WorkflowService workflowService;

    public void runWorkflow(Long id) {
        var product = productRepository.findById(id).orElseThrow();
        var workflow = workflowService.getWorkflow(product.getType(), ProductEvent.PRODUCT_CREATED, Product.class);
        workflow.execute(product);
    }
}
