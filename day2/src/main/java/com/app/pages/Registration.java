package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.UserDaoImpl;
import com.app.entities.User;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/voter_register")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private UserDaoImpl userDao;
    public void init() throws ServletException
    {
    	System.out.println("In init method"+getClass());
    	try {
    		userDao = new  UserDaoImpl();
    		
    	}
    	catch(Exception e)
    	{
    		throw new ServletException("err in init - "+getClass(),e);
    	}
    }

    public void  destroy()
    {
    	try {
    		userDao.cleanUp();
    	}
    	catch(Exception e)
    	{
    		System.out.println("err in destroy - "+getClass());
    	}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		try(PrintWriter pw =response.getWriter())
		{
			String firstname=request.getParameter("fn");
			String lastname=request.getParameter("ln");
			String email=request.getParameter("em");
			String Password=request.getParameter("pass");
			Date date=Date.valueOf(request.getParameter("dob"));
			LocalDate d=date.toLocalDate();
			Period age=Period.between(d, LocalDate.now());
			//User user=new User(firstname,lastname,email,Password,date);
			 //userDao.voterRegistration(user);
			 
			if(age.getYears()>18)
			{
				User user=new User(firstname,lastname,email,Password,date);
				 userDao.voterRegistration(user);
			 if(user==null)
			 {
				 pw.print("<h5>User details is not added , Please  <a href='Registration.html'>Retry</a><h5>");
			 }
			 else
			 {
				 pw.print("Registration is successful");
			 }
			}
			else
				pw.print("Your age is not supported for registration");
			
		}
		catch(Exception e)
		{
			System.out.println("Err in dopost method"+getClass());
		}
	}

}
