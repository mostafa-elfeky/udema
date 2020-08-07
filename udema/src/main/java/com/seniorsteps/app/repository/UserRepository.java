package com.seniorsteps.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.seniorsteps.app.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, 
		JpaSpecificationExecutor<User> {

	User findUserByUsername(String username);
}
