package com.wolframkotto.calculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CalculationDTO {
    public CalculationDTO(double vacationPay) {
        this.vacationPay = vacationPay;
    }

    private String vacationPayMessage = "Сумма отпускных составит:";
    private double vacationPay;
}
