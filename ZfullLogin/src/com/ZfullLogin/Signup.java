package com.ZfullLogin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.ZfullLogin.SignuoDAO.SignupDao;

@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = (String)request.getParameter("namee");
		String pwd = (String)request.getParameter("idd");
		String pwdd = (String)request.getParameter("pwdd");
		String eid = (String)request.getParameter("pwddd");
		
		SignupDao sd = new SignupDao();
		if(sd.check(name, eid, pwdd)) {
			JSONObject jobj = new JSONObject();
			String urlToRedirect = "login.jsp";
			try {
				jobj.put("url",urlToRedirect);
				jobj.put("message","SignedUp Successfully, Login Using Your Account!");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			HttpSession session = request.getSession();
			session.setAttribute("username", name);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jobj.toString());
		}
	}

}
