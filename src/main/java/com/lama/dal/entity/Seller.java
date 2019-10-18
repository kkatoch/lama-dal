package com.lama.dal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lama.dal.model.Award;
import com.lama.dal.model.Contact;
import com.lama.dal.model.Event;
import com.lama.dal.model.Image;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Set;

@Data
@Document
public class Seller {
    @Id
    private String id;

    @NotBlank(message = "First Name is mandatory")
    private String firstName;

    @NotBlank(message = "Last Name is mandatory")
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    private String email;

    private boolean isEmailVerified = false;

    @NotNull(message = "Seller must have a contact")
    private Contact contact;

    private Contact billing;

    private boolean isVerified = false;

    private String description;

    private Set<Award> awards;

    private Set<Image> images;

    private Set<Event> events;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;
}
