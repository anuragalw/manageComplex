/**
 * 
 */
package com.manage.complex.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.manage.complex.model.SignupModel;

/**
 * @author kumaamre
 *
 */
@Repository
public class SignupDAOImpl implements SignupDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void saveUser(SignupModel signupModel) {
		sessionFactory.getCurrentSession().save(signupModel);
		
	}
	
	public boolean isSignSucessfull(SignupModel signupModel){
		
		boolean isSignSucessfull = false;
		
		String hql = "from SignupModel signup where EMAIL=?  OR PHONENO = ? and password=?";
		
		Query query   =   sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0,signupModel.getEmail());
		query.setString(1,signupModel.getEmail());
		query.setString(2,signupModel.getPassword());
		
		List<SignupModel> sm = query.list();
		
		if(sm.size()>0){			
			isSignSucessfull =true;	
		}
		
		return isSignSucessfull;
		
	}
	
	public boolean isUserExit(SignupModel signupModel) {

		boolean isUserExit = false;

		String hql = "from SignupModel signup where EMAIL=?";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, signupModel.getEmail());
		

		List<SignupModel> sm = query.list();

		if (sm.size() > 0) {
			isUserExit = true;
		}

		return isUserExit;

	}

}
