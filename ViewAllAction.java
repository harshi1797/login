package com.proj;

import java.sql.*;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;

public class ViewAllAction extends ActionSupport 
{
   
   
	 public String execute() throws Exception 
    {
       	
		 String resultHint=null;
     
		   try 
        {  
			  Class.forName("com.mysql.jdbc.Driver");
         
		   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HPDatabase","root","password");
       
		   Statement st = con.createStatement();
          
		  System.out.println("Connection established...");
         
		   ResultSet rs = st.executeQuery("SELECT * FROM Students");
          
		  System.out.println("Query Executed....");
          
		  ServletActionContext.getRequest().setAttribute("RS", rs);
     
		       resultHint="success";
       
		 } 
      
		  catch (Exception e) 
        {   
        
			  ServletActionContext.getRequest().setAttribute("err", "Exception : "+ e);
           
			 resultHint="fail";
      
		  }
    
	    return resultHint;
  
  }

}