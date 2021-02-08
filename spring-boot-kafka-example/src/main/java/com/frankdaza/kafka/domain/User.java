package com.frankdaza.kafka.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class User {
    private String name;
    private String debt;
    private Double salary;
}
