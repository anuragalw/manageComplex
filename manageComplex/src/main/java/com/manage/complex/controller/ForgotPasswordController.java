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
public class ForgotPasswordController implements ManageComplexConstant {

	@Autowired
	private SignupService signupService;
	@RequestMapping(value = FORGOT_PW, method = RequestMethod.GET)
	public ModelAndView geForgotPW(
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute(SIGN_UP_MODEL) SignupModel signupModel) {
		
		ModelAndView mv = null;
		
		mv = new ModelAndView(FORGOT_PW);

		return mv;

	}
	
	/**
	 * @param request
	 * @param response
	 * @param signupModel
	 * @return
	 */
	@RequestMapping(value = FORGOT_PW, method = RequestMethod.POST)
	public ModelAndView geForgotPWPage(
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute(SIGN_UP_MODEL) SignupModel signupModel) {
		
		ModelAndView mv = null;	
		// TODO server side validation
		// check user existence
		boolean isUserExit = signupService.isUserExit(signupModel);

		if (isUserExit) {
			// user is exit, send the e-mail
			MailService ms = new MailService();
			int status = ms.sendMailSSL("Action required: Reset your Manage complex password","Hello "+signupModel.getEmail()+"\n\n "+"To begin the password-reset process" +	"",signupModel.getEmail());
			System.out.println(" Status "+status);
			mv = new ModelAndView(FORGOT_PW_SUCCESS);
			
		} else {
			//if user does not exit even though show the message to user e-mail has sent in your account for security reason
			mv = new ModelAndView(FORGOT_PW_SUCCESS);
			
		}
		
		return mv;

	}

}
