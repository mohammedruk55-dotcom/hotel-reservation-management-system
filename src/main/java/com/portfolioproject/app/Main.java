package com.portfolioproject.app;
import com.portfolioproject.model.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("===========================");
		System.out.println("Portfolio Manjement Project");
		System.out.println("===========================");
		User user=new User("101","rishi","rishi@gmail.com");
		System.out.println("User ID: "+user.getUserid());
		System.out.println("Name: "+user.getName());
		System.out.println("Email: "+user.getEmail());
		
	}

}
