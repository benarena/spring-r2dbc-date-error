package com.example.springr2dbcdateerror;

import com.example.springr2dbcdateerror.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserCrudRepository extends ReactiveCrudRepository<User, Long> {

}
