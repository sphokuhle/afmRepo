package za.ac.afm.rest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author S'phokuhle
 *
 */
@WebFilter(urlPatterns = "/rest/*")
public class RestFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//do nothing
	}

	@Override
	public void doFilter(ServletRequest request2, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			HttpServletRequest request = (HttpServletRequest) request2;
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.addHeader("Access-Control-Allow-Origin","*");
			resp.addHeader("Access-Control-Allow-Methods","GET,POST");
			resp.addHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
			if ( request.getMethod().equals("OPTIONS") ) {
				resp.setStatus(HttpServletResponse.SC_OK);
				return;
			}

			chain.doFilter(request, response);
		} finally {
			//do nothing
		}
	}

	@Override
	public void destroy() {
		//do nothing
	}
}
