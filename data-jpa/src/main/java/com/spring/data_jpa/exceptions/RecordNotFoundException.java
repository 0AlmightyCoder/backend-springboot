package com.spring.data_jpa.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecordNotFoundException extends RuntimeException {
    String resourceName;
    String fieldName;
    String value;
    long fieldValue;

    // constructor
    public RecordNotFoundException(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s:%d",resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    //constructor
    public RecordNotFoundException(String resourceName, String fieldName, String value) {
        super(String.format("%s not found with %s:%s", resourceName, fieldName, value));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.value = value;
    }
}
