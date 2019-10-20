package com.lama.dal.model;

import com.lama.dal.entity.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class OrderItem {
    @NotNull(message = "Order item must have a Product ID")
    @DBRef
    private Product product;

    private boolean isRent;

    private int rentDuration;
}
