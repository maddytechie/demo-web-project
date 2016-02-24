package edu.cpp.cs580.data.provider;


import java.util.List;

import com.firebase.client.Firebase;

import edu.cpp.cs580.data.User;

public class FirebaseUserManager implements UserManager {

	private Firebase firebase;
	
	public FirebaseUserManager() {
		this.firebase = new Firebase("https://brilliant-heat-9710.firebaseio.com");
	}
	
	@Override
	public User getUser(String userId) {
//		firebase.child("Users/" + userId)
		return null;
	}

	@Override
	public void updateUser(User user) {
		firebase.child("Users/" + user.getId()).setValue(user);
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> listAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
