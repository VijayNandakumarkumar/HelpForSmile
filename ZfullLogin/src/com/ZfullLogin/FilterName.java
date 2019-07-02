package com.ZfullLogin;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet Filter implementation class FilterName
 */
@WebFilter("/Signup")
public class FilterName implements Filter {

    /**
     * Default constructor. 
     */
    public FilterName() {
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
		HttpServletRequest req = (HttpServletRequest)request;
		String name_k = (String)req.getParameter("namee");
		HttpServletResponse res = (HttpServletResponse)response;
		
		System.out.println("Came here");
		Pattern p = Pattern.compile("([A-Z]+||[a-z]+)([a-zA-Z]+)*");
		Matcher m = p.matcher(name_k);
		boolean b = m.matches();
		if(b && name_k.length() > 0) {
			System.out.println("Came here");
			chain.doFilter(req, res);
		}
		else
		{
			JSONObject jobj = new JSONObject();
			try {
				jobj.put("message", "Username doesn't match the requirements");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jobj.toString());
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
