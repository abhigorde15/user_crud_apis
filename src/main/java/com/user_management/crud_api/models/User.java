package com.user_management.crud_api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "user_data")
public class User {
	    public User( String name,
			@Email(message = "Invalid email format") @NotBlank(message = "Email cannot be empty") String email,
			@Min(value = 1, message = "Age must be greater than 0") Integer age) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
	}

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(nullable = false)
	    private String name;
	    
	    @Column(nullable = false, unique = true)
	    @Email(message = "Invalid email format")
	    @NotBlank(message = "Email cannot be empty")
	    private String email;
	    
	    @Column(nullable = false)
	    @Min(value = 1, message = "Age must be greater than 0")
	    private Integer age;
        
	    
	    public User() {}
	    
		
	    public Long getId() {
			return id;
		}

		
		public void setId(Long id) {
			this.id = id;
		}

		
		public String getName() {
			return name;
		}

		
		public void setName(String name) {
			this.name = name;
		}

		
		public String getEmail() {
			return email;
		}

		
		public void setEmail(String email) {
			this.email = email;
		}

		
		public Integer getAge() {
			return age;
		}

		
		public void setAge(Integer age) {
			this.age = age;
		}
	    
	    

}
