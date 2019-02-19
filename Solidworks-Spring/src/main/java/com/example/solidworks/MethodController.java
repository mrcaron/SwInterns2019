package com.example.solidworks;
/*
 * A simple controller for all our methods
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MethodController {
	/*
	 * maps to our default home page
	 */
	@RequestMapping("/home")
	 public String home() {
	  return "index";
	 }
}
