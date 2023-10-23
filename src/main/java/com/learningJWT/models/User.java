package com.learningJWT.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter   //This is annotation is of lombok it will generate Getters method    
@Setter   //This is annotation is of lombok it will generate Setters method
@NoArgsConstructor //This is annotation is of lombok it will generate No-Argument Constructor (Default Constructor)
@AllArgsConstructor //This is annotation is of lombok it will generate Parameterize Constructor
@ToString //This is annotation is of lombok it will generate toString method
public class User {

	private String userId;
	
	private String name;
	
	private String email;
	
}
