package com.study.springboot.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.auth.AuthInfo;
import com.study.springboot.auth.AuthService;
import com.study.springboot.spring.WrongIdPasswordException;


@Controller
public class LoginController {
	
	@Autowired
    private AuthService authService;

//    public void setAuthService(AuthService authService) {
//        this.authService = authService;
//    }

    @GetMapping("/login")
    public String form(LoginCommand loginCommand,
    		@CookieValue(value = "REMEMBER", required = false) Cookie rCookie) {
		if (rCookie != null) {
			loginCommand.setSnum(rCookie.getValue());
			loginCommand.isRememberSnum(true);
		}
    	return "login/loginForm";
    }

    @PostMapping("/login")
    public String submit(
    		LoginCommand loginCommand, Errors errors, HttpSession session,
    		HttpServletResponse response) {
        new LoginCommandValidator().validate(loginCommand, errors);
        if (errors.hasErrors()) {
            return "login/loginForm";
        }
        try {
            AuthInfo authInfo = authService.authenticate(
                    loginCommand.getSnum(),
                    loginCommand.getPassword());
            
            session.setAttribute("authInfo", authInfo);

			Cookie rememberCookie = 
					new Cookie("REMEMBER", ""+loginCommand.getSnum());
			rememberCookie.setPath("/");
			if (loginCommand.isRememberSnum(loginCommand.getRememberSnum())) {
				rememberCookie.setMaxAge(60 * 60 * 24 * 30);
			} else {
				rememberCookie.setMaxAge(0);
			}
			response.addCookie(rememberCookie);
			session.setAttribute("user", loginCommand.getSnum());
			session.setAttribute("password", loginCommand.getPassword());
			
			
            return "login/loginSuccess";
        } catch (WrongIdPasswordException e) {
            errors.reject("idPasswordNotMatching");
            return "login/loginForm";
        }
    }

@GetMapping("/index")
    public String index() {
        return "index";
    }
}
