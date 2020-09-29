package com.example.backend.entity.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/*
    @author Karol Gromacki 
*/
public abstract class BaseDto implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
