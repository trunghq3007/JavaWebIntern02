package filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.impl.AccountDAOImpl;
import entity.Account;

@WebFilter(urlPatterns = {"/*"})

public class AuthenFilter implements Filter{
	AccountDAOImpl dao = new AccountDAOImpl();
	
	@SuppressWarnings("unused")
	private ServletContext context;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("LogFilter init!");
		this.context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String url = req.getRequestURI();
		String servletPath = req.getServletPath();
		System.out.println("#INFO " + new Date() + " - ServletPath :" + servletPath + ", URL =" + url);
		// Lấy ra đối tượng HttpSession
        HttpSession ss = req.getSession();
     // Lấy ra đối tượng ACCOUNT đã được lưu vào session
        Account acc = (Account) ss.getAttribute("account");
		if (servletPath.startsWith("/admin")) {
			if (acc != null && acc.getRole().equals("admin")) {
				chain.doFilter(request, response);
				System.out.println(acc.getUsername());
			}
			else {
				resp.sendRedirect(req.getContextPath() + "/Login");
				//System.out.println(acc.getUsername());
				}

		} else if (servletPath.startsWith("/student")) {
			if (acc != null && acc.getRole().equals("student"))
				chain.doFilter(request, response);
			else
				resp.sendRedirect(req.getContextPath() + "/Login");
		} else {
			chain.doFilter(request, response);	
			//System.out.println(acc.getUsername());
		}
		
	}

	@Override
	public void destroy() {
		System.out.println("LogFilter destroy!");
	}
}
