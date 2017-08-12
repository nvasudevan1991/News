package com.project.registration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Access {
	public String getDetails(Connection con, String str3, String str4, String str5) throws SQLException {
		String fname = null, lname = null, fullName = null, LogoutTime = null;
		String findTableSQL = "SELECT fname,lname,LogoutTime FROM registrationdetails WHERE Email= ? AND password = ?";
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(findTableSQL);
		statement.setString(1, str3.toString());
		statement.setString(2, str4.toString());
		ResultSet r = statement.executeQuery();
		while (r.next()) {

			fname = r.getString(1);
			lname = r.getString(2);
			LogoutTime = r.getString(3);
		}
		fullName = fname + " " + lname;

		return fullName + " " + LogoutTime;
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

	public void updateDetails(Connection con, String str1, String str2, String str3) throws SQLException {
		String insertTableSQL = "UPDATE registrationdetails SET password = ?, confirmpassword = ? WHERE Email = ?";
		PreparedStatement prep = (PreparedStatement) con.prepareStatement(insertTableSQL);
		prep.setString(1, str2.toString());
		prep.setString(2, str3.toString());
		prep.setString(3, str1.toString());
		prep.executeUpdate();
	}

	public void updateLogoutDetails(Connection con, String str1, String str2) throws SQLException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String insertTableSQL = "UPDATE registrationdetails SET LogoutTime = ? WHERE fname = ? AND lname = ?";
		PreparedStatement prep = (PreparedStatement) con.prepareStatement(insertTableSQL);
		prep.setString(1, dtf.format(now));
		prep.setString(2, str1.toString());
		prep.setString(3, str2.toString());
		prep.executeUpdate();
	}

	public ArrayList<LocalNews> getNews(Connection con, String logoutDetailTime) throws SQLException {
		String localnewsQueryCustomer = null;
		String localnewsQuery = null;
		ArrayList<LocalNews> localNewsList = new ArrayList<LocalNews>();
		localNewsList.clear();
		ResultSet rs = null;
		System.out.println(logoutDetailTime);
		if (!logoutDetailTime.isEmpty()) {
			localnewsQueryCustomer = "SELECT * FROM newsdata WHERE Category = ? AND date > 'logoutDetailTime' ORDER BY `newsdata`.`date` DESC LIMIT 5";
			PreparedStatement stmt1 = con.prepareStatement(localnewsQueryCustomer);
			stmt1.setString(1, "LocalNews");
			rs = stmt1.executeQuery();
		} else if (logoutDetailTime.isEmpty()) {
			localnewsQuery = "SELECT * FROM newsdata WHERE Category = ? ORDER BY `newsdata`.`date` DESC ";
			PreparedStatement stmt = con.prepareStatement(localnewsQuery);
			stmt.setString(1, "LocalNews");
			rs = stmt.executeQuery();
		}
		try {
			while (rs.next()) {

				LocalNews l = new LocalNews();
				l.setId(rs.getInt("S.No"));
				l.setCategory(rs.getString("Category"));
				l.setData(rs.getString("Data"));
				l.setHeadlines(rs.getString("Headlines"));
				l.setDate(rs.getDate("date"));
				l.setImage(rs.getString("Image"));
				l.setUrl(rs.getString("Url"));
				localNewsList.add(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return localNewsList;
	}

	public ArrayList<LocalNews> getsportsNews(Connection con, String logoutDetailTime) throws SQLException {
		String sportsnewsQueryCustomer = null;
		String sportsnewsQuery = null;
		ArrayList<LocalNews> sportsNewsList = new ArrayList<LocalNews>();
		sportsNewsList.clear();
		ResultSet rs = null;
		if (!logoutDetailTime.isEmpty()) {
			sportsnewsQueryCustomer = "SELECT * FROM newsdata WHERE Category = ? AND date > 'logoutDetailTime' ORDER BY `newsdata`.`date` DESC LIMIT 5";
			PreparedStatement stmt1 = con.prepareStatement(sportsnewsQueryCustomer);
			stmt1.setString(1, "PoliticsNews");
			rs = stmt1.executeQuery();
		} else if (logoutDetailTime.isEmpty()) {
			sportsnewsQuery = "SELECT * FROM newsdata WHERE Category = ? ORDER BY `newsdata`.`date` DESC ";
			PreparedStatement stmt = con.prepareStatement(sportsnewsQuery);
			stmt.setString(1, "PoliticsNews");
			rs = stmt.executeQuery();
		}
		try {
			while (rs.next()) {
				LocalNews l = new LocalNews();
				l.setId(rs.getInt("S.No"));
				l.setCategory(rs.getString("Category"));
				l.setData(rs.getString("Data"));
				l.setHeadlines(rs.getString("Headlines"));
				l.setDate(rs.getDate("date"));
				l.setImage(rs.getString("Image"));
				l.setUrl(rs.getString("Url"));
				sportsNewsList.add(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sportsNewsList;
	}

	public ArrayList<LocalNews> getWorldNews(Connection con, String logoutDetailTime) throws SQLException {
		String worldnewsQueryCustomer = null;
		String worldnewsQuery = null;
		ArrayList<LocalNews> worldNewsList = new ArrayList<LocalNews>();
		worldNewsList.clear();
		ResultSet rs = null;
		if (!logoutDetailTime.isEmpty()) {
			worldnewsQueryCustomer = "SELECT * FROM newsdata WHERE Category = ? AND date > 'logoutDetailTime' ORDER BY `newsdata`.`date` DESC LIMIT 5";
			PreparedStatement stmt1 = con.prepareStatement(worldnewsQueryCustomer);
			stmt1.setString(1, "WorldNews");
			rs = stmt1.executeQuery();
		} else if (logoutDetailTime.isEmpty()) {
			worldnewsQuery = "SELECT * FROM newsdata WHERE Category = ? ORDER BY `newsdata`.`date` DESC ";
			PreparedStatement stmt = con.prepareStatement(worldnewsQuery);
			stmt.setString(1, "WorldNews");
			rs = stmt.executeQuery();
		}
		try {
			while (rs.next()) {
				LocalNews l = new LocalNews();
				l.setId(rs.getInt("S.No"));
				l.setCategory(rs.getString("Category"));
				l.setData(rs.getString("Data"));
				l.setHeadlines(rs.getString("Headlines"));
				l.setDate(rs.getDate("date"));
				l.setImage(rs.getString("Image"));
				l.setUrl(rs.getString("Url"));
				worldNewsList.add(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return worldNewsList;
	}

	public ArrayList<LocalNews> getSearchNews(Connection con, String searchcontent) throws SQLException {
		String searchNewsQuery = "SELECT * FROM newsdata WHERE Data LIKE ? ORDER BY `newsdata`.`date` DESC LIMIT 20";
		ArrayList<LocalNews> searchNewsList = new ArrayList<LocalNews>();
		PreparedStatement stmt = con.prepareStatement(searchNewsQuery);
		stmt.setString(1, "%" + searchcontent.toString() + "%");
		ResultSet rs = stmt.executeQuery();
	try {
			while (rs.next()) {
				LocalNews l = new LocalNews();
				l.setId(rs.getInt("S.No"));
				l.setCategory(rs.getString("Category"));
				l.setData(rs.getString("Data"));
				l.setHeadlines(rs.getString("Headlines"));
				l.setDate(rs.getDate("date"));
				l.setImage(rs.getString("Image"));
				l.setUrl(rs.getString("Url"));
				searchNewsList.add(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchNewsList;
	}
}
