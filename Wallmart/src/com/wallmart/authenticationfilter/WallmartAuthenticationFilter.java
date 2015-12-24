package com.wallmart.authenticationfilter;

import com.wallmart.dto.WallmartDTO;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class WallmartAuthenticationFilter
 */

public class WallmartAuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public WallmartAuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("Inside Authentication Filter Class....");
		
		Autthentication auth = new Autthentication();
		
		 HttpServletRequest req = (HttpServletRequest) request;
		 HttpServletResponse res = (HttpServletResponse) response;
		
		 String user_id = request.getParameter("user_name");
		 String password = ((HttpServletRequest) request).getParameter("password");
		 System.out.println("user_id ::"+user_id);
		 System.out.println("password ::"+password);
		 
		 WallmartDTO.setUserID(user_id);
		 WallmartDTO.setPassword(password);
		 
		 boolean falg = auth.userAuthentication(user_id, password);
		 
		 if(falg){
			 //here Login Success page redirect
			 System.out.println("----------In If User is Valid ----------::"+falg);
			
		 	HttpSession session = req.getSession();
	            session.setAttribute("userID_Attr", user_id);
	            session.setAttribute("passwort_Attr", password);
	            
	            //setting session to expiry in 30 mins
	            session.setMaxInactiveInterval(30*60);
	            Cookie userName = new Cookie("userID_Attr", user_id);
	            userName.setMaxAge(30*60);
	            res.addCookie(userName);
	            
			 res.sendRedirect("invoiceDetails.html");
		 }
		 else{
			 // Redirect on Error page
			 System.out.println("----------In else User is not Valid ----------::"+falg);
		 }
		 
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
