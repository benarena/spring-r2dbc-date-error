package com.example.springr2dbcdateerror;

import com.example.springr2dbcdateerror.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class Tests {

	@Autowired
	private UserCrudRepository repository;

	@Test
	void saveUser() {
		final User user = new User();
		user.setCreated(Instant.now());

		repository.save(user)
			.as(StepVerifier::create)
			.consumeNextWith(result -> {
				assertNotNull(result.getId());
				assertEquals(user.getCreated(), result.getCreated());
			})
			.verifyComplete();
	}
}
