package com.example.demo.multicontainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.multicontainer.entity.User;

public interface UserRepository extends JpaRepository<User, Long>
{

}
