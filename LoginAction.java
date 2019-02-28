
import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import org.apache.struts2.interceptor.ServletRequestAware;


public class LoginAction extends ActionSupport implements ServletRequestAware
{

   
	 private String t1;
    
	 private String t2;
  
	 // HttpServletRequest request;

    
	public String execute() throws Exception 
    {
         
		   String resultHint = null;

           
		  HttpServletRequest request = ServletActionContext.getRequest();

         
		   if (t1.equals(t2)) 
            {  
			 resultHint = "success";
                
			HttpSession sess = request.getSession(true);
            		
			sess.setAttribute("user", t1);
         
		   } 
         
		   else 
            {   
			request.setAttribute("err", "Login Authentication Failed.");
               
			resultHint = "fail";
           
		 }
         
		   return resultHint;
   
	 }//end of execute() method


    
	public String getT1() 
    {   return t1;
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


}
