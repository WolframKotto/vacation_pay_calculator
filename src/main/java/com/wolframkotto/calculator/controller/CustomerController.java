package com.wolframkotto.calculator.controller;

import com.wolframkotto.calculator.model.CalculationDTO;
import com.wolframkotto.calculator.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("/calculate")
    public CalculationDTO getCustomer(@RequestParam double averageSalary, @RequestParam int vacationDays, @RequestParam LocalDate vacationStart){
        return new CalculationDTO(customerService.calculateVacationPay(averageSalary, vacationDays, vacationStart));
    }
}
