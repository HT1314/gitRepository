package test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharacterFilter implements Filter {
	private FilterConfig filterConfig;

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httprequest = (HttpServletRequest) request;
		httprequest.setCharacterEncoding("utf-8");
		HttpServletResponse httpresponse=(HttpServletResponse)response;
		filterChain.doFilter(httprequest,httpresponse);
		httpresponse.setCharacterEncoding("utf-8");
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig = filterConfig;
		init();
	}

	public void init() throws ServletException {
	}

}
