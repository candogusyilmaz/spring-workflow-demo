package dev.canverse.workflow.controllers;

import dev.canverse.workflow.managers.ProductManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductManager productManager;

    @PostMapping("/{id}/run-workflow")
    public void runWorkflowByProductId(@PathVariable Long id) {
        productManager.runWorkflow(id);
    }
}
