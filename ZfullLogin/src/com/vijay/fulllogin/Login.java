package com.vijay.fulllogin;

import java.io.IOException;
//import java.io.PrintWriter;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.vijay.fulllogin.DAO.LoginDao;

@WebServlet("/Login")
public class Login extends HttpServlet{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String username = (String)request.getParameter("userName");
		String password = (String)request.getParameter("userPass");
		LoginDao ld = new LoginDao();
		if(ld.check(username, password)) {
			JSONObject jobj = new JSONObject();
			String urlToRedirect = "dashboard.jsp";
			try {
				jobj.put("url",urlToRedirect);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jobj.toString());
		}
		else {
			System.out.println("False case");
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("User name or password is incorrect.");
		}
	}

}
