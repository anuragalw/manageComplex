package com.manage.complex.dao;

import java.util.List;

import com.manage.complex.form.Contact;


public interface ContactDAO {
	
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
}
