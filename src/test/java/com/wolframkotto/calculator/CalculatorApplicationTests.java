package com.wolframkotto.calculator;

import com.wolframkotto.calculator.service.CustomerService;
import com.wolframkotto.calculator.service.impl.CustomerServiceInMemoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class CalculatorApplicationTests {

	private CustomerService customerService = new CustomerServiceInMemoryImpl();

	@Test
	void whenAverageSalary5000vacationDays14NoHolidaysMust23890() {
		assertEquals(customerService.calculateVacationPay(50000, 14,
				LocalDate.of(LocalDate.now().getYear(), 8, 1)), 23890.78, 1);
	}

	@Test
	void whenAverageSalary5000vacationDays28NoHolidaysMust47781() {
		assertEquals(customerService.calculateVacationPay(50000, 28,
				LocalDate.of(LocalDate.now().getYear(), 8, 1)), 47781.56, 1);
	}

	@Test
	void whenAverageSalary5000vacationDays14Holiday1Must22184() {
		assertEquals(customerService.calculateVacationPay(50000, 14,
				LocalDate.of(LocalDate.now().getYear(), 2, 20)), 22184.3, 1);
	}

}
