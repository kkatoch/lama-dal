package com.lama.dal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lama.dal.model.Address;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
@Document("Buyer")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Buyer {
    @Id
    private String id;

    @NotBlank(message = "First Name is mandatory")
    private String firstName;

    @NotBlank(message = "Last Name is mandatory")
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Email
    @Indexed(unique = true)
    private String email;

    private boolean isEmailVerified = false;

    @NotNull(message = "Buyer must have a contact")
    private Address address;

    private Address billing;

    private boolean isVerified = false;

    @NotNull(message = "Phone Number is mandatory")
    private String phoneNumber;

    @JsonIgnore
    @CreatedDate
    private Instant createdAt;

    @JsonIgnore
    @LastModifiedDate
    private Instant updatedAt;
}
