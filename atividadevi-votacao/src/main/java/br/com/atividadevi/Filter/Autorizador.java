package br.com.atividadevi.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Autorizador implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession sess =  req.getSession(false);
		String loginURI = req.getContextPath() + "/login.xhtml";
		
		boolean logged = sess != null && sess.getAttribute("usuario") != null;
		boolean logginRequest = req.getRequestURI().equals(loginURI);
		String reqURI = req.getRequestURI();
		
		
		if(logged || logginRequest || reqURI.indexOf("/public/") >=0 ){
			chain.doFilter(req, resp);
		}else{
			resp.sendRedirect(loginURI);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
