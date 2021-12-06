package com.sakurawald.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class History {
    private double operand1;
    private String operator;
    private double operand2;
    private String value;
}
