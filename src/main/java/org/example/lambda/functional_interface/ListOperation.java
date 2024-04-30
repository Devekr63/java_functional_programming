package org.example.lambda.functional_interface;

@FunctionalInterface
public interface ListOperation<T> {
    T operate(T listElement);
}
