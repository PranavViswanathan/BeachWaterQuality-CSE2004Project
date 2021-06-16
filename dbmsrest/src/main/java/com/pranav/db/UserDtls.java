package com.pranav.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pranav.entity.User;

public class UserDtls implements UserDtlsInterface {

	Connection connection = ConnectionUtil.openConnection();

	@Override
	public User getUser(String email, String pwd) {
		try {
			PreparedStatement ps = connection.prepareStatement("select id,nameu, email, pwd,admin from user_dtls where email=? and pwd=?");
            String emailStripped = email.trim();
            String pwdStripped = pwd.trim();
            ps.setString(1, emailStripped);
            ps.setString(2, pwdStripped);
            ResultSet rs =ps.executeQuery();
            if(rs.next()) {
            	User u = new User();
            	u.setId(rs.getInt("id"));
            	u.setNameu(rs.getString("nameu"));
            	u.setEmail(rs.getString("email"));
            	u.setPwd(rs.getString("pwd"));
            	if(rs.getString("admin").equals("y")) {
            		u.setAdminUser(true);
            	}else{
            		u.setAdminUser(false);
            	}
            	System.out.println(u.toString());
            	return u;
            }
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean save(User user) {
		boolean flag = false;
		try {
			String adminUser="n";
			if(user.isAdminUser()) {
				adminUser = "y";
			}
			String sql = String.format("INSERT INTO user_dtls(nameu, email, pwd, admin) VALUES ('%s','%s','%s','%s')", 
					user.getNameu(), user.getEmail(), user.getPwd(),adminUser);
			System.out.println("sql:"+sql);
			connection = ConnectionUtil.openConnection();
			PreparedStatement ps =connection.prepareStatement(sql);
			ps.executeUpdate();
			flag = true;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return flag;
	}
}
