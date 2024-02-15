package com.wishlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wishlist.entity.User;

public interface UserRepo  extends JpaRepository<User, Integer> {

	
}
