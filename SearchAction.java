package com.proj;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;

import java.sql.*;


public class SearchAction extends ActionSupport 
{
   
	private String t1;
   	
	 public String execute() throws Exception 
    {  
		 String resultHint=null;
     
		   try 
        {  
			 Class.forName("com.mysql.jdbc.Driver");
         
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DITDB","root","password");
            					PreparedStatement pst = con.prepareStatement("SELECT * FROM HPTRAINEES WHERE NAME LIKE ?");
            				pst.setString(1, "%"+t1+"%");
           
    
			ResultSet rs = pst.executeQuery();
           
			System.out.println("Query Executed....");
            
			ServletActionContext.getRequest().setAttribute("RS", rs);
           
			System.out.println("RS : "+ rs);
           
			resultHint="success";
       
		 } 
       
		 catch (Exception e) 
        {  
			 ServletActionContext.getRequest().setAttribute("err", "Exception : "+ e);
           
			 resultHint="fail";
       
		 }

      
		  return resultHint;    
    
	}//end of execute() method
    

	    public String getT1() 
    { 	 return t1;
  	  }
   
	   public void setT1(String t1) 
    {  this.t1 = t1;
    }  
  
}//end of class
