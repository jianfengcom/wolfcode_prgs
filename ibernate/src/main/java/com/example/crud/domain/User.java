package com.example.crud.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Setter@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private BigDecimal salary;
    private Date hiredate;
}
