/**
 * 
 */
package com.manage.complex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.complex.dao.SignupDAO;
import com.manage.complex.model.SignupModel;

/**
 * @author kumaamre
 *
 */
@Service
public class SignupServiceImpl implements SignupService {

	@Autowired
	private SignupDAO signupDAO;
	
	@Transactional
	public void saveUser(SignupModel signupModel) {
		signupDAO.saveUser(signupModel);
		
	}

	@Transactional
	public boolean isSignSucessfull(SignupModel signupModel) {
		
		boolean isSignSucessfull = signupDAO.isSignSucessfull(signupModel);	
		
		return isSignSucessfull;
	}
	
	@Transactional
	public boolean isUserExit(SignupModel signupModel) {
		
		boolean isUserExit = signupDAO.isUserExit(signupModel);	
		
		return isUserExit;
	}

}
