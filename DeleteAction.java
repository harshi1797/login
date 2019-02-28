package com.proj;

import java.sql.*;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
public class DeleteAction extends ActionSupport 
{   
	private String t1;
  
  
	public String execute() throws Exception 
    {
     
		String resultHint=null;
     
		try 
        {  
			 Class.forName("com.mysql.jdbc.Driver");
           
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DITDB","root","password");
            			 PreparedStatement pst = con.prepareStatement("delete from hptrainees where name=?");
           
			 pst.setString(1, t1);                       
           
			 int status = pst.executeUpdate();  
         
			 System.out.println("status of deletion = "+status);
          		
			  if(status == 1)
            	
				ServletActionContext.getRequest().setAttribute("msg", "Record Deleted Successfully for :" + t1);
            					resultHint="success";
       
		 } 
        
		catch (Exception e) 
        {   
			ServletActionContext.getRequest().setAttribute("err", "Insert Operation Failed.<br> "+ e);
            
			resultHint="fail";            
        
		}               
     
		   return resultHint;   
  
	  }//end of execute() method
   
	 public String getT1() 
    {  return t1;
    }
    
	public void setT1(String t1) 
    {  this.t1 = t1;
    }       

}//end of class
