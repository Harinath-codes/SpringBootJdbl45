package com.jdbl45.wallet.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {

	private String name;

	private String contact;

	private String email;

	public User to() {
		return User.builder().email(this.email).contact(this.contact).name(this.name).build();
	}
}