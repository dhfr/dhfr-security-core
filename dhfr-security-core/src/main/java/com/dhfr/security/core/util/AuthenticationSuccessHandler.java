/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhfr.security.core.util;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 *
 * @author Deni Husni FR
 */
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    protected transient Logger LOGGER = Logger.getLogger(getClass());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        LOGGER.info("Success Login");
        response.sendRedirect(request.getContextPath() + "/protected/home.htm");
    }
}
