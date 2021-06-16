package com.dbms.db;

import com.dbms.entity.User;

public interface UserDtlsInterface {
	public User getUser(String email, String pwd);
	boolean save(User user);
}
