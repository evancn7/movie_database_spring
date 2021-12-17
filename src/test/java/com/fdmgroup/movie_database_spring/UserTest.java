package com.fdmgroup.movie_database_spring;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import com.fdmgroup.movie_database_spring.model.User;
import com.fdmgroup.movie_database_spring.service.UserService;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
class UserTest {
	
	@Autowired
	private UserService userService;

	@Test
	void test_ThatAUserCanBeRetrievedByUsernameAndPassword() {
		User userFromDB = userService.getByUsernameAndPassword("test", "password");
		assertTrue(userFromDB.getUserId() != 0);
	}

}
