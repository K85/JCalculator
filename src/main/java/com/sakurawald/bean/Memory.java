package com.sakurawald.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Memory {
    private double value;

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
