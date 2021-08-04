package com.longnguyenquy.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.longnguyenquy.validator.FieldMatch;
import com.longnguyenquy.validator.ValidEmail;

@FieldMatch.List({
    @FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
})
public class UserDto {
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String username;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String password;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String matchingPassword;


	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String firstName;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String lastName;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	@ValidEmail(message = "must match user_name@domain_name")
	private String email;

	public UserDto() {};
	
	public UserDto(String userName, String password, String firstName, String lastName,String email) {
		this.username = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	
	public String getUsername() {
		return username;
	}

	
	public void setUsername(String userName) {
		this.username = userName;
	}

	
	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}
	
	public String getFirstName() {
		return firstName;
	}

	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
}
