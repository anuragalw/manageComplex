/**
 * 
 */
package com.manage.complex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.manage.complex.model.SignupModel;
import com.manage.complex.service.SignupService;
import com.manage.complex.util.ManageComplexConstant;

/**
 * @author kumaamre
 * 
 */
@Controller
public class SigninController implements ManageComplexConstant {

	@Autowired
	private SignupService signupService;
	
	@RequestMapping(value = SIGN_IN, method = RequestMethod.GET)
	public ModelAndView getSignupPage(
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute(SIGN_UP_MODEL) SignupModel signupModel) {
		
		ModelAndView mv = null;
		
		mv = new ModelAndView(SIGN_IN);

		return mv;

	}
	
	@RequestMapping(value = SIGN_IN, method = RequestMethod.POST)
	public ModelAndView geSignupPage(
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute(SIGN_UP_MODEL) SignupModel signupModel) {
		
		ModelAndView mv = null;		
		mv = new ModelAndView(SIGN_IN_SUCCESS);
		
		boolean isSignSucessfull =  signupService.isSignSucessfull(signupModel);
		if(isSignSucessfull){
			// go to homepage
			mv.addObject("msg","successfully");
		}else{
			mv.addObject("msg","fail");
		}
		// else error message
		return mv;

	}

}
