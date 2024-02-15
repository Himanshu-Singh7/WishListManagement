package com.wishlist.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="user")
@NoArgsConstructor
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	@Column(name = "user_name")
	private String name;
	@Column(name= "email")
	private String email;
	@Column(name = "password")
	private String password;
	
	@OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private List<Wishlist> wishlist = new ArrayList<Wishlist>();

}