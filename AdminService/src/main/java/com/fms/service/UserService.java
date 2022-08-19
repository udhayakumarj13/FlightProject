package com.fms.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.dto.Userdata;
import com.fms.repository.UserRepository;
@Service
public class UserService implements UserServiceI
{
     @Autowired
     UserRepository udao;
 

	public void setUdao(UserRepository udao) { this.udao=udao; }
     

     @Transactional
     public Userdata addUser(Userdata user)
     {
    	 user.setUsertype("customer");
    	 return udao.save(user);
     }
     

    
     @Transactional
     public String loginUser(Userdata u)
     {
    	String flag=null;
     	String usertype=udao.findByusertype(u.getUsername(),u.getUserpassword());
     	 if(usertype==null)
     		 return "invalid";
     	if(usertype.equalsIgnoreCase("admin"))
     			{
     				 flag="admin";
     				 System.out.println("You are logged in as an ADMIN");
     			}
     	else if(usertype.equalsIgnoreCase("customer"))
     			{
     			 flag="customer";
     			System.out.println("You are logged in as an User");
     			}
     	return flag;
     }
     
  
 
}
