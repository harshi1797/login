package com.proj;


import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;


public class SignoutAction extends ActionSupport 
{

   
	 public String execute() throws Exception 
    {
    
		    HttpSession ses = ServletActionContext.getRequest().getSession(false);

     
		   if (ses != null) 
        {  
			 ses.invalidate();
       
		 }
        
       
		 ServletActionContext.getRequest().setAttribute("msg", "Logout Successfully.");
        
      
	  return "success";
    
	}

}
