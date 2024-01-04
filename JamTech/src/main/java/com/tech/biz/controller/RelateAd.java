package com.tech.biz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/relateAd")
public class RelateAd {
	
	@GetMapping("/relateAd")
	public String relateAd() {
		return "relateAd";
	}
}
