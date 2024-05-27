package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.CandidateDao;
import com.app.dao.CandidateDaoImpl;
import com.app.dao.UserDaoImpl;
import com.app.entities.User;

import static com.app.utils.DBUtils.*;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet(value = "/login", loadOnStartup = 1) // eager init
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;
	private CandidateDaoImpl  candidateDao;
	
	public LoginServlet() {
		System.out.println("in default constructor");
		System.out.println("config "+getServletConfig());
	}

	/*
	 * Overriding form of the  method can't throw any NEW or BORADER checked  excs
	 */
	@Override
	public void init() throws ServletException {
		ServletConfig config=getServletConfig();
		System.out.println("in init of " + getClass()+"config "+getServletConfig());
		try {
			// create user dao instance
			//dependent : servlet,depenency - user dao(for data access layer)
			//dependent object is creating its own depcy 
			openConnection(config.getInitParameter("db_url"),config.getInitParameter("user_name"),config.getInitParameter("password"));
			userDao = new UserDaoImpl();
			candidateDao = new CandidateDaoImpl();
			
		} catch (Exception e) {
			// centralized exc handling in Servlet
			/*
			 * In case of err in init --To inform the WC throw ServletException --WC will
			 * abort the life cycle Ctor of javax.servlet.ServletException(String mesg,
			 * Throwable rootCause)
			 */
			throw new ServletException("err in init - " + getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			// WC invokes it once @ end of the life cycle
			// clean up Dao
			userDao.cleanUp();
			candidateDao.cleanUp();
			closeConnection();
			
		} catch (Exception e) {
			System.out.println("err in destroy - " + getClass());
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. set resp cont type
		response.setContentType("text/html");
		// 2. Get PW to send text resp
		try (PrintWriter pw = response.getWriter()) {
			// 3. Get req params(email n pwd) from the req
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			// 4. Invoke user dao's --sign in method for user authentication
			User user = userDao.signIn(email, password);
			// 5 . check if valid (via null)
			if (user == null) {
				// invalid login --send retry link --login.html
				pw.print("<h5>Invalid Login , Please  <a href='login.html'>Retry</a><h5>");
			} else {
				// valid login --continue to role based authorization
//				pw.print("<h5>Successful Login </h5>");
//				pw.print("<h5> User Details "+user+"</h5>");
				
				//Valid login --1. Create a Cookie to store validated user details
				//javax.servlet.http.Cookie(String cookiename,String cookievalue)
				//Cookie c1=new Cookie("User_details",user.toString());
				//2.send the cookie to clnt,using  resp header
				//HtttpservletResponse's method
				//public void addCookie(Cookie c)
				//response.addCookie(c1);
				HttpSession session=request.getSession();
				System.out.println("Loginn servlet , sessn is new  "+ session.isNew());
				System.out.println("Sessionn Id "+  session.getId());
				session.setAttribute("user_info",user);
				session.setAttribute("candidate_Dao", candidateDao);
				
				if (user.getRole().equals("voter")) {
					//=> voter login --> check the voting status
					if(user.isStatus()) //=> already voted --> redirect to logout page
						response.sendRedirect("logout");
					else //voter : not yet voted --> redirect to candidate list page
						response.sendRedirect("candidate_list");						

					/*
					 * WC - 1.Clears/Empty the prnt writer buffer
					 * 2. send redirect resp - SC 302, Header location ="candidate_list", 
					 * Set-Cookie-cookie name -value
					 * resp body -empty
					 * 3.Clnt browser -chks privacy settings
					 * cookies blocked --coookies won't be stored --can't remember the clnt
					 * accepted --cookie age --def value -1=> saves it in cache(cookie storage)
					 * 4. client  browser - sends NEXT  req (redirect)
					 * URL -http://host:port/day2.1/candidate_list
					 * method - GET -->candidatelist Servlet
					 * + add the cookie in req header
					 */
				} else {
					// admin login -- redirect the clnt to admin page in NEXT request coming from
					// the clnt
					response.sendRedirect("admin");
				}

			}

		} // JVM : pw.close --> flush --> render/commits the resp
		catch (Exception e) {
			// inform the WC about the exc
			throw new ServletException("err in servicing " + getClass(), e);
		}

	}

}
