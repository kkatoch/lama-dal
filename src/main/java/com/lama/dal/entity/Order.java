package com.lama.dal.entity;

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

@Document
@Data
public class Order {
    @Id
    private String id;

    private OrderStatus orderStatus;

    @NotNull(message = "Order must have a buyer ID")
    @DBRef
    private Buyer buyer;

    @NotNull(message = "Order must have items")
    private Set<OrderItem> orderItems;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;
}
