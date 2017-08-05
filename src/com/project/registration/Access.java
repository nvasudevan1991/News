package com.project.registration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

import com.mysql.fabric.xmlrpc.base.Array;
import java.sql.PreparedStatement;

public class Access {
	public String getDetails(Connection con, String str3, String str4) throws SQLException {
		String fname = null ,lname = null,fullName = null,Email=null;
		String findTableSQL = "SELECT fname,lname,Email FROM registrationdetails WHERE Email= ? AND password = ?" ;
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(findTableSQL);
		statement.setString(1, str3.toString());
		statement.setString(2, str4.toString());
		ResultSet r = statement.executeQuery();
		while(r.next()){
			
		fname = r.getString(1);
		lname = r.getString(2);
		Email = r.getString(3);
		}
		fullName = fname + " " + lname;
		
		return fullName ;
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

	public void updateDetails(Connection con, String str1,String str2,String str3) throws SQLException {
		String insertTableSQL = "UPDATE registrationdetails SET password = ?, confirmpassword = ? WHERE Email = ?";
		PreparedStatement prep = (PreparedStatement) con.prepareStatement(insertTableSQL);
		prep.setString(1, str2.toString());
		prep.setString(2, str3.toString());
		prep.setString(3,str1.toString());
		prep.executeUpdate();
	}
	public  ArrayList<LocalNews> getNews(Connection con ) throws SQLException
	{
		ArrayList<LocalNews> localNewsList = new ArrayList<LocalNews>();
		String localnewsQuery = "SELECT * FROM newsdata WHERE Category = ? ORDER BY 'S.No' DESC";
		PreparedStatement stmt = con.prepareStatement(localnewsQuery);
		stmt.setString(1, "LocalNews");
		ResultSet rs =stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				LocalNews l =new LocalNews();
				l.setId(rs.getInt("S.No"));
				l.setCategory(rs.getString("Category"));
				l.setData(rs.getString("Data"));
				l.setHeadlines(rs.getString("Headlines"));
				l.setDate(rs.getString("date"));
				l.setImage(rs.getString("Image"));
				l.setVideo(rs.getString("Video"));
				l.setUrl(rs.getString("Url"));
				localNewsList.add(l);
			}
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		return localNewsList;
	}
	public  ArrayList<LocalNews> getsportsNews(Connection con ) throws SQLException
	{
		ArrayList<LocalNews> sportsNewsList = new ArrayList<LocalNews>();
		String sportsNewsQuery = "SELECT * FROM newsdata WHERE Category = ? ORDER BY 'S.No' DESC";
		PreparedStatement stmt = con.prepareStatement(sportsNewsQuery);
		stmt.setString(1, "PoliticsNews");
		ResultSet rs =stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				LocalNews l =new LocalNews();
				l.setId(rs.getInt("S.No"));
				l.setCategory(rs.getString("Category"));
				l.setData(rs.getString("Data"));
				l.setHeadlines(rs.getString("Headlines"));
				l.setDate(rs.getString("date"));
				l.setImage(rs.getString("Image"));
				l.setVideo(rs.getString("Video"));
				l.setUrl(rs.getString("Url"));
				sportsNewsList.add(l);
			}
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		return sportsNewsList;
	}
	public  ArrayList<LocalNews> getWorldNews(Connection con ) throws SQLException
	{
		String worldNewsQuery = "SELECT * FROM newsdata WHERE Category = ? ORDER BY 'S.No' DESC";
		ArrayList<LocalNews> worldNewsList = new ArrayList<LocalNews>();
		PreparedStatement stmt = con.prepareStatement(worldNewsQuery);
		stmt.setString(1, "WorldNews");
		ResultSet rs =stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				LocalNews l =new LocalNews();
				l.setId(rs.getInt("S.No"));
				l.setCategory(rs.getString("Category"));
				l.setData(rs.getString("Data"));
				l.setHeadlines(rs.getString("Headlines"));
				l.setDate(rs.getString("date"));
				l.setImage(rs.getString("Image"));
				l.setVideo(rs.getString("Video"));
				l.setUrl(rs.getString("Url"));
				worldNewsList.add(l);
			}
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		return worldNewsList;
	}
}
