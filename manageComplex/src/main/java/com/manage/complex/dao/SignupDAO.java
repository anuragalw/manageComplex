/**
 * 
 */
package com.manage.complex.dao;

import com.manage.complex.model.SignupModel;

/**
 * @author kumaamre
 *
 */
public interface SignupDAO {
	
	public void saveUser(SignupModel signupModel);
	public boolean isSignSucessfull(SignupModel signupModel);
	public boolean isUserExit(SignupModel signupModel);

}
