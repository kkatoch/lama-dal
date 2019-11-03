package com.lama.dal.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class Email {
    private String from = "info@lamaart.co.uk";
    private String to = "info@lamaart.co.uk";

    @NotBlank(message = "Subject in Email is Mandatory")
    private String subject;
    @NotBlank(message = "Message in Email is Mandatory")
    private String message;
}
