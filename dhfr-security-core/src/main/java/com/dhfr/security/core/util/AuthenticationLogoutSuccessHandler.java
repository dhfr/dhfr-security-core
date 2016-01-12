/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhfr.security.core.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

/**
 *
 * @author Deni Husni FR
 */
public class AuthenticationLogoutSuccessHandler implements LogoutHandler {
    
    protected transient Logger LOGGER = Logger.getLogger(getClass());
    
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        LOGGER.info("Logout Success");
    }
    
}
