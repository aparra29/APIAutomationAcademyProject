package com.testing.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Resources {
    private String name;
    private String trademark;
    private int stock;
    private int price;
    private String description;
    private String tags;
    private Boolean active;
    private String id;
}
