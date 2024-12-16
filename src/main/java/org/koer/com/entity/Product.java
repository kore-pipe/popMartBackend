package org.koer.com.entity;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Data
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "商品对象",description = "商品对象")
public class Product {

    private Integer Id;
    private String name;
    private String Description;
    private Double price;

}
