package com.project.registration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
//import java.sql.PreparedStatement;
import com.mysql.jdbc.PreparedStatement;
public class Access {
	public ArrayList<Registration> getDetails(Connection con) throws SQLException {
		ArrayList<Registration> details = new ArrayList<Registration>();
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("SELECT * FROM registrationdetails");
		ResultSet r = statement.executeQuery();
		System.out.println(r);
		try {
			while (r.next()) {
				Registration value = new Registration();
				value.setfirstName(r.getString("fname"));
				value.setlastName(r.getString("lname"));
				value.setEmail(r.getString("Email"));
				value.setPassword(r.getString("password"));
				value.setConfirmPassword(r.getString("confirmpassword"));
				value.setMobile(r.getString("mobile"));
				value.setGender(r.getString("gender"));
				details.add(value);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return details;
	}

	public void addDetails(Connection con, Registration d) throws SQLException {
		String insertTableSQL = "INSERT INTO registrationdetails"
				+ "(fname, lname, Email, password, confirmpassword, mobile, gender) VALUES" + "(?,?,?,?,?,?,?)";
		PreparedStatement prep = (PreparedStatement) con.prepareStatement(insertTableSQL);
		prep.setString(1, d.getfirstName().toString());
		prep.setString(2, d.getlastName().toString());
		prep.setString(3, d.getEmail().toString());
		prep.setString(4, d.getPassword().toString());
		prep.setString(5, d.getConfirmpassword().toString());
		prep.setString(6, d.getMobile().toString());
		prep.setString(7, d.getGender().toString());

		prep.executeUpdate();
	}

	public void updateDetails(Connection con, Registration d) throws SQLException {
		String insertTableSQL = "UPDATE registrationdetails SET password = ?, confirmpassword = ? WHERE Email = ?";
		PreparedStatement prep = (PreparedStatement) con.prepareStatement(insertTableSQL);
		prep.setString(1, d.getEmail().toString());
		prep.setString(2, d.getPassword().toString());
		prep.setString(3, d.getConfirmpassword().toString());
		prep.executeUpdate();
	}
}
