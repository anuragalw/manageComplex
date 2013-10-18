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
import com.manage.complex.util.MailService;
import com.manage.complex.util.ManageComplexConstant;

/**
 * @author kumaamre
 * 
 */
@Controller
public class SignupController implements ManageComplexConstant {

	@Autowired
	private SignupService signupService;
	@RequestMapping(value = SIGN_UP, method = RequestMethod.GET)
	public ModelAndView getSignupPage(
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute(SIGN_UP_MODEL) SignupModel signupModel) {
		
		ModelAndView mv = null;
		
		mv = new ModelAndView(SIGN_UP);

		return mv;

	}
	
	/**
	 * @param request
	 * @param response
	 * @param signupModel
	 * @return
	 */
	@RequestMapping(value = SIGN_UP, method = RequestMethod.POST)
	public ModelAndView geSignupPage(
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute(SIGN_UP_MODEL) SignupModel signupModel) {
		
		ModelAndView mv = null;	
		// TODO server side validation
		// check user existence
		boolean isUserExit = signupService.isUserExit(signupModel);

		if (isUserExit) {
			mv = new ModelAndView(SIGN_UP);
			mv.addObject(USER_EXIT, USER_EXIT);
		} else {
			mv = new ModelAndView(SIGN_UP_SUCCESS);
			signupService.saveUser(signupModel);
			MailService ms = new MailService();
			int status = ms.sendMailSSL("Congratulations on joining Manage Complex","Welcome "+signupModel.getEmail()+","+"\n\n "+"Congratulations, and thank you for joining Manage Complex! We're excited to help you get started." +	"",signupModel.getEmail());
			System.out.println(" Status "+status);
		}
		
		return mv;

	}

}
