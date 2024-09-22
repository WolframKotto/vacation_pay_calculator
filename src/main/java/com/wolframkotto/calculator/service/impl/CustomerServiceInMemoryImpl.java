package com.wolframkotto.calculator.service.impl;

import com.wolframkotto.calculator.service.CustomerService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerServiceInMemoryImpl implements CustomerService {

    private final static int CURRENT_YEAR = LocalDate.now().getYear();
    private final List<LocalDate> holidays = List.of(
            LocalDate.of(CURRENT_YEAR, 1, 1),
            LocalDate.of(CURRENT_YEAR, 1, 2),
            LocalDate.of(CURRENT_YEAR, 1, 3),
            LocalDate.of(CURRENT_YEAR, 1, 4),
            LocalDate.of(CURRENT_YEAR, 1, 5),
            LocalDate.of(CURRENT_YEAR, 1, 6),
            LocalDate.of(CURRENT_YEAR, 1, 7),
            LocalDate.of(CURRENT_YEAR, 1, 8),
            LocalDate.of(CURRENT_YEAR, 2, 23),
            LocalDate.of(CURRENT_YEAR, 3, 8),
            LocalDate.of(CURRENT_YEAR, 5, 1),
            LocalDate.of(CURRENT_YEAR, 5, 9),
            LocalDate.of(CURRENT_YEAR, 6, 12),
            LocalDate.of(CURRENT_YEAR, 10, 4)
            );

    @Override
    public double calculateVacationPay(double averageSalary, int vacationDays, LocalDate vacationStart) {
        int holidaysCount = 0;
        for (int i = 0; i < vacationDays; i++) {
            for (LocalDate dataListItem : holidays) {
                if (dataListItem.getMonth().equals(vacationStart.getMonth()) &&
                        dataListItem.getDayOfMonth() == vacationStart.getDayOfMonth()) {
                    holidaysCount++;
                }
            }
            vacationStart = vacationStart.plusDays(1);
        }
        return Math.round(averageSalary/29.3 * (vacationDays - holidaysCount));
    }
}
