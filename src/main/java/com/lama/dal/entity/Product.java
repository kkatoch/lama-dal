package com.lama.dal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lama.dal.model.Image;
import com.lama.dal.model.Tag;
import com.lama.dal.types.ArtCategory;
import com.lama.dal.types.ArtMedium;
import com.lama.dal.types.ArtStyle;
import com.lama.dal.types.Color;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@Document("Product")
@CompoundIndex(name = "product_seller", def = "{'name' : 1, 'seller': 1}", unique = true)
public class Product {
    @Id
    private String id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Product must have Colors")
    private Set<Color> colors;

    @NotNull(message = "Product must have a Medium")
    private ArtMedium artMedium;

    @NotNull(message = "Product must have an Art Category")
    private ArtCategory artCategory;

    @NotNull(message = "Product must have an Art Style")
    private ArtStyle artStyle;

    @NotNull(message = "Height is mandatory")
    private double height;

    @NotNull(message = "Width is mandatory")
    private double width;

    @NotNull(message = "Depth is mandatory")
    private double depth;

    @NotNull(message = "Weight is mandatory")
    private double weight;

    @NotNull(message = "Year of Creation is mandatory")
    private int createdYear;

    @NotBlank(message = "Inspiration is mandatory")
    private String inspiration;

    @NotBlank(message = "Description is mandatory")
    private String description;

    private Set<Tag> tags;

    @NotNull(message = "Price is mandatory")
    private BigDecimal price;

    private BigDecimal rentPrice;

    @NotNull(message = "Is Rent is mandatory")
    private boolean isRent;
    @NotNull(message = "Is Sell is mandatory")
    private boolean isSell;

    @NotNull(message = "Product must have a Currency")
    private String currency;

    @DBRef
    private Seller seller;

    private Set<Image> images;

    @JsonIgnore
    @CreatedDate
    private Instant createdAt;

    @JsonIgnore
    @LastModifiedDate
    private Instant updatedAt;
}
