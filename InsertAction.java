package com.proj;

import java.sql.*;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;


public class InsertAction extends ActionSupport 
{
   
	private String t1;
  
	private String t2;
   
   
	 @Override
    public String execute() throws Exception
    {
        	
		String resultHint=null;
      
		  try 
        {  
			 Class.forName("com.mysql.jdbc.Driver");
           		
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DITDB","root","password");
            					 PreparedStatement pst = con.prepareStatement("insert into Student values(?,?)");
           
			 pst.setString(1, t1);
           
			 pst.setString(2, t2);
            
			System.out.println("Connection established..."+t1 +"\t"+ t2);
          
			  int status = pst.executeUpdate();
           
			 System.out.println("Query Executed....");
            
			if(status == 1)
            	
				ServletActionContext.getRequest().setAttribute("msg",
"Record Inserted Successfully.<br>"+
t1 +  " : " + t2    );
            			resultHint="success";
        
			} 
       
		 catch (Exception e) 
        {   
			ServletActionContext.getRequest().setAttribute("err", "Insert Operation Failed.<br> "+ e);
       
			     resultHint="fail";
            
			System.out.println("EXCEPTION "+ e);
     
		   }
        return resultHint;   
   
	 }//end of execute() method

   
	public String getT1() {
        return t1;
    }

   
	 public void setT1(String t1) {
        this.t1 = t1;
    }

   
	public String getT2() {
        return t2;
    }

    
	public void setT2(String t2) {
        this.t2 = t2;
    }
    

}//end of class
