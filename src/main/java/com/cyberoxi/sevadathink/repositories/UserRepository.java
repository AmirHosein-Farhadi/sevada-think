package com.cyberoxi.sevadathink.repositories;

import com.cyberoxi.sevadathink.model.User;
import org.springframework.data.repository.CrudRepository;

import javax.validation.constraints.Size;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(@Size(min = 4, max = 20) String username);
}
