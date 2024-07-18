package dev.canverse.workflow.workflows;

public interface Workflow<T> {
    void execute(T data);
}
