package com.sakurawald.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class History {
    private ArrayList<Double> operands;
    private String operator;
    private double value;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < operands.size(); i++) {
            if (i == operands.size() - 1) {
                sb.append(" ").append(operator).append(" ");
            }
            sb.append(operands.get(i));
        }
        sb.append(" = ").append(value);
        return sb.toString();
    }
}
