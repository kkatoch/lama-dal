package com.lama.dal.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter@Setter
public class Tag {

    @NotBlank(message = "Award Name is mandatory")
    private String name;
}
