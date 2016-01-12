/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhfr.security.core.util;

import static com.google.common.collect.Lists.newArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author Deni Husni Fahri Rizal
 * @version 1
 * @since 18 January 2014
 */
public class UserInfoUtil {

    public static String getUserName() {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();
    }

    public static String getRequestRemoteAddr() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();
        return request.getRemoteAddr();
    }

    public static List<String> toStringList(Iterable<? extends GrantedAuthority> grantedAuthorities) {
        List<String> result = newArrayList();

        for (GrantedAuthority grantedAuthority : grantedAuthorities) {
            result.add(grantedAuthority.getAuthority());
        }

        return result;
    }

    public static List<String> getRoles() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<String> listAuth;
        if (auth != null) {
            listAuth = toStringList(auth.getAuthorities());
        } else {
            listAuth = Collections.emptyList();
        }
        return listAuth;

    }

    public static Boolean hasRole(String roleName) {
        Boolean isHasRole = Boolean.FALSE;
        for (String role : getRoles()) {
            if (role.equalsIgnoreCase(roleName)) {
                isHasRole = Boolean.TRUE;
                break;
            } 
        }
        return isHasRole;
    }

    public static String getRolesString() {
        List<String> roles = getRoles();
        String role = roles.toString();
        return role.substring(1, role.length() - 1);
    }
    
}
