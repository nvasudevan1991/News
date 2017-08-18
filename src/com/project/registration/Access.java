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
			localnewsQueryCustomer = "SELECT * FROM newsdata WHERE Category = ? AND date > ? ORDER BY `newsdata`.`date` DESC LIMIT 5";
			PreparedStatement stmt1 = con.prepareStatement(localnewsQueryCustomer);
			stmt1.setString(1, "LocalNews");
			stmt1.setString(2, logoutDetailTime);
			System.out.println(stmt1);
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
				System.out.println(localNewsList);
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
		System.out.println(logoutDetailTime);
		ResultSet rs = null;
		if (!logoutDetailTime.isEmpty()) {
			sportsnewsQueryCustomer = "SELECT * FROM newsdata WHERE Category = ? AND date > ? ORDER BY `newsdata`.`date` DESC LIMIT 5";
			PreparedStatement stmt1 = con.prepareStatement(sportsnewsQueryCustomer);
			stmt1.setString(1, "PoliticsNews");
			stmt1.setString(2, logoutDetailTime);
			System.out.println(stmt1);
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
		System.out.println(logoutDetailTime);
		ResultSet rs = null;
		if (!logoutDetailTime.isEmpty()) {
			worldnewsQueryCustomer = "SELECT * FROM newsdata WHERE Category = ? AND date > ? ORDER BY `newsdata`.`date` DESC LIMIT 5";
			PreparedStatement stmt1 = con.prepareStatement(worldnewsQueryCustomer);
			stmt1.setString(1, "WorldNews");
			stmt1.setString(2, logoutDetailTime);
			rs = stmt1.executeQuery();
			System.out.println(stmt1);
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

	public ArrayList<LocalNews> getrecommendedLocalNews(Connection con, String fname, String lname, String category)
			throws SQLException {
		String query = "Update registrationdetails SET LocalNewsCount = LocalNewsCount + 1 WHERE fname = ? AND Lname = ?";
		ArrayList<LocalNews> recommenedLocalNewsList = new ArrayList<LocalNews>();
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, fname.toString());
		stmt.setString(2, lname.toString());
		stmt.executeUpdate();
		return recommenedLocalNewsList;
	}

	public ArrayList<LocalNews> getrecommendedWorldNews(Connection con, String fname, String lname, String category)
			throws SQLException {
		String query = "Update registrationdetails SET WorldNewsCount = WorldNewsCount + 1 WHERE fname = ? AND Lname = ?";
		ArrayList<LocalNews> recommenedLocalNewsList = new ArrayList<LocalNews>();
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, fname.toString());
		stmt.setString(2, lname.toString());
		stmt.executeUpdate();
		return recommenedLocalNewsList;
	}

	public ArrayList<LocalNews> getrecommendedPoliticsNews(Connection con, String fname, String lname, String category)
			throws SQLException {
		String query = "Update registrationdetails SET PoliticsNewsCount = PoliticsNewsCount + 1 WHERE fname = ? AND Lname = ?";
		ArrayList<LocalNews> recommenedLocalNewsList = new ArrayList<LocalNews>();
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, fname.toString());
		stmt.setString(2, lname.toString());
		stmt.executeUpdate();
		return recommenedLocalNewsList;
	}

	public String getrecommendedNews(Connection con, String fname, String lname) throws SQLException {
		String query = "SELECT CASE WHEN LocalNewsCount > WorldNewsCount AND LocalNewsCount > PoliticsNewsCount THEN ? WHEN WorldNewsCount >LocalNewsCount AND WorldNewsCount >PoliticsNewsCount THEN ? WHEN PoliticsNewsCount >LocalNewsCount AND PoliticsNewsCount >WorldNewsCount THEN ? END FROM registrationdetails Where fname = ? AND lname = ?";
		String recommenededNewsList = null;
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, "LocalNews");
		stmt.setString(2, "WorldNews");
		stmt.setString(3, "PoliticsNews");
		stmt.setString(4, fname.toString());
		stmt.setString(5, lname.toString());
		ResultSet r = stmt.executeQuery();
		while (r.next()) {
			recommenededNewsList = r.getString(1);
		}
		return recommenededNewsList;
	}

	public ArrayList<LocalNews> getrecommendedList(Connection con) throws SQLException {
		String query = "SELECT *  FROM newsdata WHERE Category = ? ORDER BY `newsdata`.`date` DESC LIMIT 5";
		ArrayList<LocalNews> recommenedLocalNewsList = new ArrayList<LocalNews>();
		PreparedStatement stmt1 = con.prepareStatement(query);
		PreparedStatement stmt2 = con.prepareStatement(query);
		PreparedStatement stmt3 = con.prepareStatement(query);
		stmt1.setString(1, "LocalNews");
		stmt2.setString(1, "WorldNews");
		stmt3.setString(1, "PoliticsNews");
		ResultSet rs1 = stmt1.executeQuery();
		ResultSet rs2 = stmt2.executeQuery();
		ResultSet rs3 = stmt3.executeQuery();
		try {
			while (rs1.next()) {
				LocalNews l = new LocalNews();
				l.setId(rs1.getInt("S.No"));
				l.setCategory(rs1.getString("Category"));
				l.setData(rs1.getString("Data"));
				l.setHeadlines(rs1.getString("Headlines"));
				l.setDate(rs1.getDate("date"));
				l.setImage(rs1.getString("Image"));
				l.setUrl(rs1.getString("Url"));
				recommenedLocalNewsList.add(l);
			}
			while (rs2.next()) {
				LocalNews l = new LocalNews();
				l.setId(rs2.getInt("S.No"));
				l.setCategory(rs2.getString("Category"));
				l.setData(rs2.getString("Data"));
				l.setHeadlines(rs2.getString("Headlines"));
				l.setDate(rs2.getDate("date"));
				l.setImage(rs2.getString("Image"));
				l.setUrl(rs2.getString("Url"));
				recommenedLocalNewsList.add(l);
			}
			while (rs3.next()) {
				LocalNews l = new LocalNews();
				l.setId(rs3.getInt("S.No"));
				l.setCategory(rs3.getString("Category"));
				l.setData(rs3.getString("Data"));
				l.setHeadlines(rs3.getString("Headlines"));
				l.setDate(rs3.getDate("date"));
				l.setImage(rs3.getString("Image"));
				l.setUrl(rs3.getString("Url"));
				recommenedLocalNewsList.add(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return recommenedLocalNewsList;
	}
}
