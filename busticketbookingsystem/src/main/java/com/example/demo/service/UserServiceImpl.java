//package com.example.demo.service;
//
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.entity.User;
//import com.example.demo.repository.UserRepo;
//
//@Service
//public class UserServiceImpl implements UserService
//{
//	
//	@Autowired
//	private UserRepo userRepo;
//	
//	public static String hashPassword(String password) {
//		hexString.append('0');
//				}
//				
//				htry {
//			MessageDigest digest = MessageDigest.getInstance("SHA-256");
//			
//			byte[] hashedBytes = digest.digest(password.getBytes());
//			
//			
//			StringBuilder hexString = new StringBuilder();
//			
//			for(byte b : hashedBytes) {
//				String hex = Integer.toHexString(0xff & b);
//				
//				if(hex.length() == 1) {
//					exString.append(hex);
//			}
//			return hexString.toString();
//		}
//		catch(NoSuchAlgorithmException e) {
//			throw new RuntimeException("Error hashing password", e);
//		}
//	}
//
//	@Override
//	public String userRegister(User user) {
//		
//		
////		User existingUser = userRepo.findByEmail(user.getEmail());
//		
//		List<User> userList = userRepo.findAll();		
//		if(userList.isEmpty()) {
////			System.out.println(user.getEmail());
////			userRepo.save(user);
//			return "User is already registered";
//		}
//		
//		String hashedPassword = hashPassword(user.getPassword());
//		user.setPassword(hashedPassword);
//		
//		userRepo.save(user);
////		if(usersList.isEmpty()) {
////			System.out.println(user.getEmail());
////			userRepo.save(user);
////		}
//		
//		
//		
////		for(User users : usersList) {
//////			System.out.println(users.getEmail());
////			if(users.getEmail().equals(user.getEmail())) {
////				return "User is already registered";
////			}
////			else {
////				userRepo.save(user);
////			}
////		}
////		
//		return "You have Register Successfully";
//		
//		
//	}
//
//	@Override
//	public String userLogin(String email, String password) {
//	
//		List<User> userList = userRepo.findAll();
//		
//		String hashedPassword = hashPassword(password);
//		
//		for(User users : userList) {
//			if(users.getEmail().equals(email) && users.getPassword().equals(hashedPassword)) {
//				return "Login Successfully";
//			}
//			
//			
//	}
//		
//		return "Please Enter valid details";
//	
//	}
//	
//
//}



package com.example.demo.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService
{
	
	@Autowired
	private UserRepo userRepo;
	
	public static String hashPassword(String password) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			
			byte[] hashedBytes = digest.digest(password.getBytes());
			
			
			StringBuilder hexString = new StringBuilder();
			
			for(byte b : hashedBytes) {
				String hex = Integer.toHexString(0xff & b);
				
				if(hex.length() == 1) {
					hexString.append('0');
				}
				
				hexString.append(hex);
			}
			return hexString.toString();
		}
		catch(NoSuchAlgorithmException e) {
			throw new RuntimeException("Error hashing password", e);
		}
	}

	@Override
	public String userRegister(User user) {
	    // Check if a user with the same email already exists
	    User existingUser = userRepo.findByEmail(user.getEmail());
	    
	    if (existingUser != null) {
	        return "User is already registered";
	    }
	    
	    // Hash the password before saving the user
	    String hashedPassword = hashPassword(user.getPassword());
	    user.setPassword(hashedPassword);
	    
	    // Save the new user
	    userRepo.save(user);
	    
	    return "You have registered successfully";
	}

	@Override
	public String userLogin(String email, String password) {
	
		List<User> userList = userRepo.findAll();
		
		String hashedPassword = hashPassword(password);
		
		for(User users : userList) {
			if(users.getEmail().equals(email) && users.getPassword().equals(hashedPassword)) {
				return "Login Successfully";
			}
			
			
	}
		
		return "Please Enter valid details";
	
	}
	

}