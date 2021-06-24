package com.pranav.db;

import com.pranav.entity.User;

public interface UserDtlsInterface {
	public User getUser(String email, String pwd);
	boolean save(User user);
}
