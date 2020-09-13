package com.druggers.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter("/searchResults.html")
public class MenuSearchCorrectionFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String searchTerm = request.getParameter("searchTerm");

		if (searchTerm.toLowerCase().equals("panadol")) {
			MenuSearchCorrectionRequestWrapper wrapper = new MenuSearchCorrectionRequestWrapper((HttpServletRequest)request);
			wrapper.setNewSearchTerm("paracetamol");
			chain.doFilter(wrapper, response);

		} else if (searchTerm.toLowerCase().equals("thorazine")) {
			MenuSearchCorrectionRequestWrapper wrapper = new MenuSearchCorrectionRequestWrapper((HttpServletRequest)request);
			wrapper.setNewSearchTerm("chlorpromazine");
			chain.doFilter(wrapper, response);

		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
