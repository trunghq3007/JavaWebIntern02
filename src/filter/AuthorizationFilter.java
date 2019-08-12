package filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Account;

@WebFilter(urlPatterns = "/*")
public class AuthorizationFilter implements Filter {

	@SuppressWarnings("unused")
	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("LogFilter init!");
		this.context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String url = request.getRequestURI();
		String servletPath = request.getServletPath();
		System.out.println("#INFO " + new Date() + " - ServletPath :" + servletPath + ", URL =" + url);
		// Lấy ra đối tượng HttpSession
        HttpSession session = request.getSession();
     // Lấy ra đối tượng ACCOUNT đã được lưu vào session
        Account account = (Account) session.getAttribute("ACCOUNT");
		if (servletPath.startsWith("/admin")) {
			if (account != null && account.getRole().equals("admin"))
				filterChain.doFilter(servletRequest, servletResponse);
			else
				response.sendRedirect(request.getContextPath() + "/login");

		} else if (servletPath.startsWith("/student")) {
			if (account != null && account.getRole().equals("student"))
				filterChain.doFilter(servletRequest, servletResponse);
			else
				response.sendRedirect(request.getContextPath() + "/login");
		} else
			filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
		System.out.println("LogFilter destroy!");
	}

}
