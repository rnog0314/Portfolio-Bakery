package com.example.tutorial.model.dao;

import com.example.tutorial.model.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>  {

	User findByUserNameAndPassword(String userName, String password);

	@Query(value = "SELECT count(user_name) FROM mst_user WHERE user_name = :newUserName", nativeQuery = true)
	int findByUserName(@Param("newUserName") String newUserName);

}
