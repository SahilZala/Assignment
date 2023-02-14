package com.pack.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pack.exceptions.UsernameNotFoundException;
import com.pack.model.GeoIP;
import com.pack.model.History;
import com.pack.model.JWTRequest;
import com.pack.model.JWTResponse;
import com.pack.model.StatusModel;
import com.pack.service.HistoryService;
import com.pack.service.UserService;
import com.pack.service.impl.RawDBDemoGeoIPLocationServiceImpl;
import com.pack.util.HttpUtils;
import com.pack.util.JWTUtil;

@RestController
@CrossOrigin
public class LoginController {
	
	private RawDBDemoGeoIPLocationServiceImpl locationService;
	    
	public LoginController() throws IOException {
	       locationService = new RawDBDemoGeoIPLocationServiceImpl();
	}
	
	@Autowired
	public AuthenticationManager authenticationManger;	
	
	@Autowired
	public UserDetailsService userDetailsService; 
	
	@Autowired
	public UserService userModelService;
	
	@Autowired
	public HistoryService historyService;
	
	@Autowired
	public JWTUtil jwtUtil;
	
	@PostMapping("/login")
	public ResponseEntity<StatusModel> generateToken(HttpServletRequest request,HttpServletResponse response,@RequestBody JWTRequest jwtRequest){
		try {
			authenticationManger.authenticate(new UsernamePasswordAuthenticationToken(
					jwtRequest.getUserName(),jwtRequest.getPassword()));
			UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUserName());	
			
			String token = jwtUtil.generateToken(userDetails);
			
			GeoIP g = locationService.getLocation(HttpUtils.getRequestIP(request));
			History h = new History(
					String.valueOf(new Date().getTime()),
					userDetails.getUsername(),
					g.getCity()+g.getIpAddress(),
					LocalDate.now().toString(),
					"",
					token
				);
			
			historyService.createHistory(h);
			
			return new ResponseEntity<>(new StatusModel(LocalDateTime.now().toString(),HttpStatus.OK,"no error","/login",new JWTResponse(token,userDetails.getAuthorities().toArray()[0].toString())),HttpStatus.OK);
		}
		catch(UsernameNotFoundException ex) {
			return new ResponseEntity<>(new StatusModel(LocalDateTime.now().toString(),HttpStatus.FORBIDDEN,ex.getMessage(),"/login","no data"),HttpStatus.FORBIDDEN);
		}	
		catch(Exception ex) {
			return new ResponseEntity<>(new StatusModel(LocalDateTime.now().toString(),HttpStatus.BAD_REQUEST,ex.getMessage(),"/login","no data"),HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("/check")
	public ResponseEntity<Boolean> dumy() {
		return new ResponseEntity<>(true,HttpStatus.OK);
	}
	
}
