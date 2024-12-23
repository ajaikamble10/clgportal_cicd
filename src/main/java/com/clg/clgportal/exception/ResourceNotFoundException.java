package com.clg.clgportal.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private long id;

    public ResourceNotFoundException(String resourceName,String fieldName,long id){
        super(String.format("%s not found with %s: %d",resourceName,fieldName,id));
        this.resourceName=resourceName;
        this.fieldName=fieldName;
        this.id=id;
    }
}
