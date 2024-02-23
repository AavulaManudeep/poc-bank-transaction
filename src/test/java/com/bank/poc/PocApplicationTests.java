package com.bank.poc;

import com.bank.poc.openapi.model.Address;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.shaded.org.checkerframework.checker.units.qual.A;

@SpringBootTest
class PocApplicationTests {

	@Test
	void testAddress() {
		Address address = new Address();
		address.setAddress1("Test");
		address.setAddress2("Test2");
	}

}
