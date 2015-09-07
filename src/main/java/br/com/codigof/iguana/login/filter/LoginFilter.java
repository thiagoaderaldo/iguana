/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.codigof.iguana.login.filter;

import br.com.codigof.iguana.login.controller.LoginController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thiago
 */
public class LoginFilter implements Filter {

//    private static final Logger LOGGER = LoggerFactory
//            .getLogger(LoginFilter.class);

//    private static final Logger LOGGER = Logger.getLogger(LoginFilter.class.getName()).log(Level.SEVERE, null);
    
    public static final String LOGIN_PAGE = "/login.jsf";

    @Override
    public void doFilter(ServletRequest servletRequest,
            ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        // managed bean name is exactly the session attribute name
//        LoginController userManager = (LoginController) httpServletRequest
//                .getSession().getAttribute("userManager");
        // managed bean name is exactly the session attribute name
        LoginController lc = (LoginController) httpServletRequest
                .getSession().getAttribute("loginController");

        if (lc != null) {
            if (lc.isUserLoggedIn()) {
//                LOGGER.debug("user is logged in");
                // user is logged in, continue request
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
//                LOGGER.debug("user is not logged in");
                // user is not logged in, redirect to login page
                httpServletResponse.sendRedirect(httpServletRequest
                        .getContextPath() + LOGIN_PAGE);
            }
        } else {
//            LOGGER.debug("userManager not found");
            // user is not logged in, redirect to login page
            httpServletResponse.sendRedirect(httpServletRequest
                    .getContextPath() + LOGIN_PAGE);
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
//        LOGGER.debug("LoginFilter initialized");
    }

    @Override
    public void destroy() {
        // close resources
    }
}
