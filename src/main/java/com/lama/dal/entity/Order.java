package com.lama.dal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lama.dal.model.OrderItem;
import com.lama.dal.types.OrderStatus;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Set;

@Data
@Document("Order")
public class Order {
    @Id
    private String id;

    private OrderStatus orderStatus;

    @NotNull(message = "Order must have a buyer ID")
    @DBRef
    private Buyer buyer;

    @NotNull(message = "Order must have items")
    private Set<OrderItem> orderItems;

    @JsonIgnore
    @CreatedDate
    private Instant createdAt;

    @JsonIgnore
    @LastModifiedDate
    private Instant updatedAt;
}
