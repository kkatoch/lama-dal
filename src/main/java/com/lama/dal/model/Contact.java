package com.lama.dal.model;

import com.lama.dal.entity.Country;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Contact {

    @NotNull(message = "Phone Number is mandatory")
    private int phoneNumber;

    @DBRef
    @NotNull(message = "Address must have country")
    private Country country;

    @NotBlank(message = "First Line of Address is mandatory")
    private String addressFirst;

    @NotBlank(message = "Second Line of Address is mandatory")
    private String addressSecond;

    @NotBlank(message = "City is mandatory")
    private String city;

    @NotBlank(message = "State is mandatory")
    private String state;

    @NotBlank(message = "Pin Code is mandatory")
    private String pinCode;
}
