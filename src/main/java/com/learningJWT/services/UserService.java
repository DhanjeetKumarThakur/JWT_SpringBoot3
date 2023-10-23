package com.learningJWT.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.learningJWT.models.User;

@Service
public class UserService {

	private List<User> store = new ArrayList<User>();

	public UserService() {
		store.add(new User(UUID.randomUUID().toString(),"Durgesh Tiwari","durgesh@dev.in"));
		store.add(new User(UUID.randomUUID().toString(),"Dhanjeet Thakur","dhanjeet@dev.in"));
		store.add(new User(UUID.randomUUID().toString(),"Sonu Thakur","sonu@dev.in"));
		store.add(new User(UUID.randomUUID().toString(),"Vishwas Thakur","vishwas@dev.in"));
	}

	public List<User> getStore() {
		return store;
	}

	public void setStore(List<User> store) {
		this.store = store;
	}
	
	
	
}
