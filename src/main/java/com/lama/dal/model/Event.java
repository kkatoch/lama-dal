package com.lama.dal.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class Event {

    @NotBlank(message = "Event Name is mandatory")
    private String name;

    @NotNull(message = "Event Date is mandatory")
    private Date eventDate;

    @NotNull(message = "Event Date is mandatory")
    private Date eventDescription;
}
