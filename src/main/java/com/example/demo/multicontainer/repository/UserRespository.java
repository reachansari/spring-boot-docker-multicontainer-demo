package com.example.demo.multicontainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.multicontainer.model.UserModel;

@Repository
public interface UserRespository extends JpaRepository<UserModel, Long> {
}
