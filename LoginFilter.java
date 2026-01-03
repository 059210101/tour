package com.example.filter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/jsp/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        if (request.getRequestURI().contains("l_signup.jsp")){
            request.getRequestDispatcher("l_signup.jsp").forward(request, servletResponse);
        }
        if (request.getRequestURI().contains("l_login.jsp")){
            request.getRequestDispatcher("l_login.jsp").forward(request, servletResponse);
        }
        if (session.getAttribute("user")!= null){
            filterChain.doFilter(servletRequest, servletResponse);
        }else if(session.getAttribute("admin") != null){
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            session.setAttribute("ERROR","请先登录");
            response.sendRedirect("l_login.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
