package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JetSkiController
{
	@RequestMapping(value = "/logout")
	public ModelAndView index()
	{
		ModelAndView model = new ModelAndView("login");
		return model;
	}

}
