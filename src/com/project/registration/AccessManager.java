package com.project.registration;

import com.project.registration.Registration;
import com.project.registration.Access;
import java.util.ArrayList;

//import javax.servlet.Registration;

import com.mysql.jdbc.Connection;

public class AccessManager {

	Access access = new Access();

	public String getDetails(String str1,String str2) throws Exception {
		String details = null;
		Database db = new Database();
		Connection con = db.getConnection();
		details = access.getDetails(con,str1,str2);
		return details;
	}

	public void ajouterDetails(Registration d) throws Exception {
		Database db = new Database();
		Connection con = db.getConnection();
		access.addDetails(con, d);
	}

	public void modifyDetails(Registration d) throws Exception {
		Database db = new Database();
		Connection con = db.getConnection();
		access.updateDetails(con, d);
	}

}
