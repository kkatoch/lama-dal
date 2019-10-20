package com.lama.dal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lama.dal.model.Address;
import com.lama.dal.model.Award;
import com.lama.dal.model.Event;
import com.lama.dal.model.Image;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Set;

@Data
@Document("Seller")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Seller {
    @Id
    private String id;

    @NotBlank(message = "First Name is mandatory")
    private String firstName;

    @NotBlank(message = "Last Name is mandatory")
    private String lastName;

    @Indexed(unique = true)
    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;

    private boolean isEmailVerified = false;

    @NotNull(message = "Seller must have a contact")
    private Address address;

    private Address billing;

    private boolean isVerified = false;

    private String description;

    private Set<Award> awards;

    private Set<Image> images;

    private Set<Event> events;

    @NotNull(message = "Phone Number is mandatory")
    private String phoneNumber;

    private boolean isListed = true;

    @Transient
    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }
    @JsonIgnore
    @CreatedDate
    private Instant createdAt;

    @JsonIgnore
    @LastModifiedDate
    private Instant updatedAt;
}
