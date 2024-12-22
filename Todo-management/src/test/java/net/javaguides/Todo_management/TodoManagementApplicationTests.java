package net.javaguides.Todo_management;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

@SpringBootTest
class TodoManagementApplicationTests {
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	@Test
	void contextLoads() {
	}

}
