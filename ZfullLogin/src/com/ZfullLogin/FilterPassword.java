package com.ZfullLogin;

import java.io.IOException;

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
 * Servlet Filter implementation class FilterPassword
 */
@WebFilter("/Signup")
public class FilterPassword implements Filter {

    /**
     * Default constructor. 
     */
    public FilterPassword() {
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
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		String password1 = (String)request.getParameter("pwdd");
		String password2 = (String)request.getParameter("pwddd");
		JSONObject jobj = new JSONObject();
		int flag = 0;
		if(password1.equals(password2) == false) {
			try {
				jobj.put("message", "passwords dont match");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				
				int pass_len = password1.length();
				if (pass_len >= 8) {
					int digit_count = 0;
					int lower_count = 0;
					int upper_count = 0;
					int spl_char_count = 0;
					for (int i = 0;i < pass_len; i++) {
						char c = password1.charAt(i);
						if(Character.isUpperCase(c))
							upper_count++;
						else if(Character.isLowerCase(c))
							lower_count++;
						else if(Character.isDigit(c))
							digit_count++;
						else if(c > 33 && c < 46 || c == 64)
							spl_char_count++;
						else
							jobj.put("message", "Password contains unknown character.");
					}
					if (digit_count == 0)
						jobj.put("message", "Password must Contain at least one digit.");
					else if(lower_count == 0)
						jobj.put("message", "Password must Contain at least one lower case character.");
					else if(upper_count == 0)
						jobj.put("message", "Password must Contain at least one upper case character.");
					else if(spl_char_count == 0)
						jobj.put("message", "Password must Contain at least one special character from [ @ # $ % ! . ].");
					else {
						flag = 1;
						chain.doFilter(req, res);
					}
			}
			else
				jobj.put("message", "Password must Be between 8 and 40 characters long.");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
		if(flag!=1) {
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			res.getWriter().write(jobj.toString());
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
