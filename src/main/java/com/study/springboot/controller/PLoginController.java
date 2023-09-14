package com.study.springboot.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.auth.AuthServiceP;
import com.study.springboot.auth.PAuthInfo;
import com.study.springboot.spring.WrongIdPasswordException;


@Controller
@RequestMapping("/loginP")
public class PLoginController {
	
	@Autowired
    private AuthServiceP authServiceP;

//    public void setAuthService(AuthService authService) {
//        this.authService = authService;
//    }

    @GetMapping
    public String form(@ModelAttribute("pLoginCommand") PLoginCommand pLoginCommand,
    		@CookieValue(value = "REMEMBER", required = false) Cookie rCookie) {
		if (rCookie != null) {
			pLoginCommand.setPnum(rCookie.getValue());
			pLoginCommand.isRememberPnum(true);
		}
    	return "loginP/loginForm";
    }

    @PostMapping
    public String submit(
    		PLoginCommand pLoginCommand, Errors errors, HttpSession session,
    		HttpServletResponse response) {
        new PLoginCommandValidator().validate(pLoginCommand, errors);
        if (errors.hasErrors()) {
            return "loginP/loginForm";
        }
        try {
            PAuthInfo pAuthInfo = authServiceP.authenticateP(
                    pLoginCommand.getPnum(),
                    pLoginCommand.getPassword());
             
            session.setAttribute("pAuthInfo", pAuthInfo);

			Cookie rememberCookie = 
					new Cookie("REMEMBER", ""+pLoginCommand.getPnum());
			rememberCookie.setPath("/");
			if (pLoginCommand.isRememberPnum(pLoginCommand.getRememberPnum())) {
				rememberCookie.setMaxAge(60 * 60 * 24 * 30);
			} else {
				rememberCookie.setMaxAge(0);
			}
			response.addCookie(rememberCookie);
			session.setAttribute("user", pLoginCommand.getPnum());
			session.setAttribute("password", pLoginCommand.getPassword());
			
            return "loginP/loginSuccess";
            
        } catch (WrongIdPasswordException e) {
            errors.reject("idPasswordNotMatching");
            return "loginP/loginForm";
        }
    }
    
}
