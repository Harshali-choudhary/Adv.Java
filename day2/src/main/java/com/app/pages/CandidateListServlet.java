package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.CandidateDaoImpl;
import com.app.entities.Candidate;
import com.app.entities.User;

/**
 * Servlet implementation class CandidateListServlet
 */
@WebServlet("/candidate_list")
public class CandidateListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1. set cont type
		response.setContentType("text/html");
		//2 get PW
		try(PrintWriter pw=response.getWriter()) {
			pw.print("<h5>in candidate list page....: successful login!</h5>");
			// get clnt detals from the cookie
			// HttpServletRequest method
			//Cookie[] getCookies()
//			Cookie[] cookies=request.getCookies();
//			if(cookies!=null)
//			{
//				//Cookie  class metods --getName,getValue
//			for(Cookie c :cookies)
//			{
//				if(c.getName().equals("user_details"))
//					pw.print("<h4> User Details - "+c.getValue()+"</h4>");
//				else
//				{
//					pw.print("no cookie");
//				}
//					
//				
//			}
//			
//			//send voter details to the clnt
//			pw.print("<h4> UserDetails  - "+request.getParameter("em")+"</h4>");
//		}
			HttpSession hs=request.getSession();
			System.out.println("Candidate list servlet,Session is new "+hs.isNew());
			System.out.println("Session id : "+hs.getId());
			User user=(User)hs.getAttribute("user_info");
			if(user != null)
			{
			pw.print("<h4>Hello "+user.getFirstName()+" "+user.getLastName()+"</h4>");
			pw.print("<h3 align='center'> Candidate list </h3>");
			
			CandidateDaoImpl dao=(CandidateDaoImpl) hs.getAttribute("candidate_dao");
			List<Candidate> candidatelist=dao.getAllCandidates();
			pw.print("<form> action = 'Logout' method='post' >");
			for(Candidate c:candidatelist)
			{
				pw.print("<h5> <input type='radio' name='candidate_id' value=' "+c.getCandidateId()+"'/>"
						+c.getCandidateName()+" "+c.getParty()+"</h5>");
			}
			pw.print("<h5> input type='submit' value='vote' </h5>");
			pw.print("</form>");
			}
			else
				pw.print("<h4> no cookies , Session tracking failed !!! </h4>");
		}
		catch(Exception e)
		{
			throw new ServletException("err in do-get of "+getClass(),e);
		}
	}

}
