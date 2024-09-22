package com.wolframkotto.calculator.service;

import java.time.LocalDate;

public interface CustomerService {
    double calculateVacationPay(double averageSalary, int vacationDays, LocalDate vacationStart);
}
