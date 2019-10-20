package com.lama.dal.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class Award {

    @NotBlank(message = "Award Name is mandatory")
    private String name;

    @NotNull(message = "Award Date is mandatory")
    private Date awardDate;
}
