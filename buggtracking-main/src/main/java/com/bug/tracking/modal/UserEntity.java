package com.bug.tracking.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class UserEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotBlank(message="UserEntity Name is required")
	@Column(updatable = false,unique=true)
	private String userName;
	
	@NotBlank(message="password is required")
	@Column(updatable = false,unique=true)
	private String password;
	
	@NotBlank(message="UserEntity email is required")
	@Column(updatable = false,unique=true)
	private String email;
	
	@OneToOne
	private Bug bug;
	
	public UserEntity() {
		super();
	}

	public UserEntity(@NotBlank(message = "UserEntity Name is required") String userName,
			@NotBlank(message = "password is required") String password,
			@NotBlank(message = "UserEntity email is required") String email, Bug bug) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.bug = bug;
	}

	public UserEntity(long id, @NotBlank(message = "UserEntity Name is required") String userName,
			@NotBlank(message = "password is required") String password,
			@NotBlank(message = "UserEntity email is required") String email, Bug bug) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.bug = bug;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Bug getBug() {
		return bug;
	}

	public void setBug(Bug bug) {
		this.bug = bug;
	}
		
}
