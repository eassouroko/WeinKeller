package com.service;

import com.model.User;

public interface IUserService {
    
	public User findByEmail(String email);
	
	public User findByConfirmationToken(String confirmationToken);
	
	public void saveUser(User user);

}
