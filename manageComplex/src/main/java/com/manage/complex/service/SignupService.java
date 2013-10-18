/**
 * 
 */
package com.manage.complex.service;


import com.manage.complex.model.SignupModel;

/**
 * @author kumaamre
 *
 */
public interface SignupService {
	
	public void saveUser(SignupModel signupModel);
	
	public boolean isSignSucessfull(SignupModel signupModel);
	
	public boolean isUserExit(SignupModel signupModel);

}
