package com.hexaware.medicalbillingsystems.restcontroller;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.medicalbillingsystems.service.AuthJWTService;
/*
@Author :  Hema Sree   
Modified Date : 14-11-2023
Description : Controller  for Login
*/
@RestController
@RequestMapping("/api/v1/login")
public class LoginRestController {
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private AuthJWTService jwtService;
	
	Logger logger=LoggerFactory.getLogger(LoginRestController.class);

	public String hello() {
		return "Welcome to Login Page";
	}

	@PostMapping("/authenticate")
	public String authenticateAndGenerateToken(@RequestBody AuthRequest authReq) {
		
			Authentication authenticate = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authReq.getUsername(), authReq.getPassword()));

			// If authentication is successful, generate a JWT
			String Token=null;
			if (authenticate.isAuthenticated()) {
				Token=jwtService.generateToken(authReq.getUsername());
				logger.info("JWT Token successfully generated!!!");
			}

			else {
				logger.info("Not Found USERNAME!!!!");
				throw new UsernameNotFoundException("UserName Not Found!!!! ");
			}
		 return Token;
		
	}
}