package com.lama.dal.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter@Setter
public class Image {
    @NotBlank(message = "Small URL is mandatory")
    private String smallUrl;

    @NotBlank(message = "Medium URL is mandatory")
    private String mediumUrl;

    @NotBlank(message = "Large URL is mandatory")
    private String largeUrl;
}
