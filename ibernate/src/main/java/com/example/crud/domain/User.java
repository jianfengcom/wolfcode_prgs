package com.example.crud.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Setter@Getter
@ToString
public class User {
    private Long id;
    private String name;
    private BigDecimal salary;
    private Date hiredate;
}
