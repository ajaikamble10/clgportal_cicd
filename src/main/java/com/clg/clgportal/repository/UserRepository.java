package com.clg.clgportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clg.clgportal.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
