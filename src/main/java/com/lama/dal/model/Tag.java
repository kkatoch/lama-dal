package com.lama.dal.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class Tag {

    @NotBlank(message = "Award Name is mandatory")
    private String name;
}
