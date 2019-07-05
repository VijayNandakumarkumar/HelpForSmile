package com.ZfullLogin.google;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ZfullLogin.SignuoDAO.SignupDao;

/**
 * Servlet implementation class google
 */
@WebServlet("/google")
public class google extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public google() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("PPPPPPPPPPPPPPPP");
		String user = (String)request.getParameter("user");
		String email = (String)request.getParameter("email");
		SignupDao sd = new SignupDao();
		String ret_data = "Data adding error in db";
		if(sd.check(user, email, "googlelogin")) {
			ret_data = "Data added successfully in db";
		}
		response.setContentType("text/application");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(ret_data);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
