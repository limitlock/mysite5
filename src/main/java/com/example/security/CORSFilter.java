package com.example.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CORSFilter implements Filter {

	@Override
	public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain )
			throws IOException, ServletException {

		System.out.println( "cors filter" );
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			
		httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		httpServletResponse.setHeader("Access-Control-Max-Age", "4800");
		httpServletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		
		httpServletResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");

        chain.doFilter( request, response );
	}


	@Override
	public void init( FilterConfig filterConfig ) throws ServletException {
	}

	@Override
	public void destroy() {
	}	

}
