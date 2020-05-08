package com.master4.filter;
import javax.servlet.*;
import java.io.IOException;

public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.err.println("============== test filter ========");
            try {
                chain.doFilter(request, response);
            } catch (Exception ex) {
                request.setAttribute("errorMessage", ex);
                request.getRequestDispatcher("/WEB-INF/views/errors/authorization.jsp")
                        .forward(request, response);
            }

    }
}
