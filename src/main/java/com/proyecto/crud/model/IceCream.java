package com.proyecto.crud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IceCream {
    private Long id;
    private String name;
    private String flavor;
    private String type;
}
