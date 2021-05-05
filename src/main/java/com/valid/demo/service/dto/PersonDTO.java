package com.valid.demo.service.dto;

import com.sun.istack.internal.NotNull;

public class PersonDTO {

    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String lastName;
    private Boolean processed = Boolean.FALSE;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }
}
