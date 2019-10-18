package com.lama.dal.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Document
public class Currency {
    @Id
    private String id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Symbol is mandatory")
    private String symbol;

    @NotBlank(message = "Base Name is mandatory")
    private String baseName;

    @NotBlank(message = "Base Symbol is mandatory")
    private String baseSymbol;

    @NotNull(message = "SOD Rate is mandatory")
    private BigDecimal sodRate;

    @NotNull(message = "MOD Rate is mandatory")
    private BigDecimal modRate;

    @NotNull(message = "EOD Rate is mandatory")
    private BigDecimal eodRate;
}
