package com.example.demo.exception;

import javax.validation.constraints.NotBlank;

public class ResourceExistsException extends RuntimeException {
    public ResourceExistsException(
            @NotBlank(message = "Department ID cannot be blank") String message) {
        super(message);
    }
}
