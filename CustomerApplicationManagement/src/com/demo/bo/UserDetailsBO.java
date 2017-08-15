package com.demo.bo;

import com.demo.dao.UserDetailsDAO;
import com.demo.to.UserDetails;

public class UserDetailsBO {

	public UserDetails authenticate(String userName, String password) {
		
		UserDetailsDAO dao = new UserDetailsDAO();
		
		// BL here...
		
		return dao.authenticate(userName, password);
	}
	
	public boolean addUser(UserDetails userDetails) {
		
		UserDetailsDAO dao = new UserDetailsDAO();
		
		// BL here...
		
		return dao.addUser(userDetails);
	}
	
}
