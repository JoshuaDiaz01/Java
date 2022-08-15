package com.example.demo.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.demo.models.LoginUser;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
	    
	@Service
	public class UserService {
	    
	    @Autowired
	    private UserRepository userRepo;
	    
	    // TO-DO: Write register and login methods!
	    public User register(User newUser, BindingResult result) {
	    	
	        // TO-DO: Additional validations!
	    	Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
	    	
	    	//reject email if taken
	    	if(potentialUser.isPresent()) {
	    		result.rejectValue("confirm", "Matches", "This email has been taken");
	    	}
	    	
	    	 // Reject if password doesn't match confirmation
	    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
	    		result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
	    	}
	    	
	    	// Return null if result has errors
	    	if(result.hasErrors()) {
	    		return null;
	    	}
	    	
	    	// Hash and set a password, save user to the database
	    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
	    	newUser.setPassword(hashed);
	    	return userRepo.save(newUser);
	    	
	        
	    }
	    public User login(LoginUser newLogin, BindingResult result) {
	        // TO-DO: Additional validations!
	    	
	    	Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
	    	// Find user in the DB by email
	        // Reject if NOT present
	    	if(!potentialUser.isPresent()) {
	    		result.rejectValue("email", "Matches", "User not found!");
	    		return null;
	    	}
	    	
	    	// User exists, retrieve user from DB
	    	User user = potentialUser.get();
	        
	        // Reject if BCrypt password match fails
	    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
	    	    result.rejectValue("password", "Matches", "Invalid Password!");
	    	}
	    	
	    	// Return null if result has errors
	    	if(result.hasErrors()) {
	    		return null;
	    	}
	    	
	        // Otherwise, return the user object
	        return user;
	    }
	    
	    
	    public User findById(Long id) {
	    	Optional<User> potentialUser = userRepo.findById(id);
	    	if(potentialUser.isPresent()) {
	    		return potentialUser.get();
	    	}
	    	return null;
	    }
	    
	    
	    
	    
	

}
