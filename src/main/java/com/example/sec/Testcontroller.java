package com.example.sec;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Testcontroller {
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("hi")
	public String m1() {
		return "hi";
	}
	@PreAuthorize("hasRole('USER')")
	@GetMapping("hello")
	public String m2() {
		return "bye";
	}
	
	
	@GetMapping("/api/hello")
	public String m3() {
		return "success";
	}
}
