package com.project.registration;

import java.io.IOException;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.mysql.jdbc.Connection;

public class DataPuller {

	public static void main(String[] args) throws SQLException {
		String connectionURL = "jdbc:mysql://127.0.0.1:3306/registration";
		DataPuller d = new DataPuller();
		Connection con = null;
		con = (Connection) DriverManager.getConnection(connectionURL, "root", "root");
		ArrayList<String> LocalYahooHeadlines = d.yahooLocalNewsHeadlines();
		ArrayList<String> LocalYahooUrl = d.yahooLocalNewsUrl();
		ArrayList<String> LocalYahooImageUrl = d.yahooLocalImageUrl();
		ArrayList<String> LocalYahooData = d.yahooLocalNewsdata();
		ArrayList<String> WorldYahooHeadlines = d.yahooWorldNewsHeadlines();
		ArrayList<String> WorldYahooUrl = d.yahooWorldNewsUrl();
		ArrayList<String> WorldYahooImageUrl = d.yahooWorldImageUrl();
		ArrayList<String> WorldYahooData = d.yahooWorldNewsdata();
		ArrayList<String> SportsYahooHeadlines = d.yahooSportsNewsHeadlines();
		ArrayList<String> SportsYahooUrl = d.yahooSportsNewsUrl();
		ArrayList<String> SportsYahooImageUrl = d.yahooSportsImageUrl();
		ArrayList<String> SportsYahooData = d.yahooSportsNewsdata();
		for (int i = 0; i < LocalYahooHeadlines.size(); i++) {
			String checkContent = "SELECT COUNT(Headlines) FROM newsdata WHERE Headlines = ?";
			PreparedStatement stmt = con.prepareStatement(checkContent);
			stmt.setString(1, LocalYahooHeadlines.get(i).toString());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);

				if (count == 0)

				{
					String insertTableSQL = "INSERT INTO newsdata"
							+ "(Headlines, Url, Image, Video, date, Category, data) VALUES" + "(?,?,?,?,?,?,?)";
					PreparedStatement prep = (PreparedStatement) con.prepareStatement(insertTableSQL);
					prep.setString(1, LocalYahooHeadlines.get(i).toString());
					prep.setString(2, LocalYahooUrl.get(i).toString());
					prep.setString(3, LocalYahooImageUrl.get(i).toString());
					prep.setString(4, "null");
					prep.setString(5, "null");
					prep.setString(6, "LocalNews");
					prep.setString(7, LocalYahooData.get(i).toString());

					prep.executeUpdate();

				}

			}
		}
		for (int i = 0; i < WorldYahooHeadlines.size(); i++) {
			String checkContent = "SELECT COUNT(Headlines) FROM newsdata WHERE Headlines = ?";
			PreparedStatement stmt = con.prepareStatement(checkContent);
			stmt.setString(1, WorldYahooHeadlines.get(i).toString());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				if (count == 0)

				{
					String insertTableSQL = "INSERT INTO newsdata"
							+ "(Headlines, Url, Image, Video, date, Category, data) VALUES" + "(?,?,?,?,?,?,?)";
					PreparedStatement prep = (PreparedStatement) con.prepareStatement(insertTableSQL);
					prep.setString(1, WorldYahooHeadlines.get(i).toString());
					prep.setString(2, WorldYahooUrl.get(i).toString());
					prep.setString(3, WorldYahooImageUrl.get(i).toString());
					prep.setString(4, "null");
					prep.setString(5, "null");
					prep.setString(6, "WorldNews");
					prep.setString(7, WorldYahooData.get(i).toString());

					prep.executeUpdate();

				}

			}
		}
		for (int i = 0; i < SportsYahooHeadlines.size(); i++) {
			String checkContent = "SELECT COUNT(Headlines) FROM newsdata WHERE Headlines = ?";
			PreparedStatement stmt = con.prepareStatement(checkContent);
			stmt.setString(1, SportsYahooHeadlines.get(i).toString());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				if (count == 0)

				{
					String insertTableSQL = "INSERT INTO newsdata"
							+ "(Headlines, Url, Image, Video, date, Category, data) VALUES" + "(?,?,?,?,?,?,?)";
					PreparedStatement prep = (PreparedStatement) con.prepareStatement(insertTableSQL);
					prep.setString(1, SportsYahooHeadlines.get(i).toString());
					prep.setString(2, SportsYahooUrl.get(i).toString());
					prep.setString(3, SportsYahooImageUrl.get(i).toString());
					prep.setString(4, "null");
					prep.setString(5, "null");
					prep.setString(6, "SportsNews");
					prep.setString(7, SportsYahooData.get(i).toString());

					prep.executeUpdate();

				}

			}
		}

	}

	public ArrayList<String> yahooLocalNewsHeadlines() {

		ArrayList<String> Headlines = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://www.yahoo.com/news/us/").get();
			Elements HeadLines = doc.getElementsByClass("Mb(5px)").select("a");
			for (Element f : HeadLines) {
				Headlines.add(f.text());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Headlines;
	}

	public ArrayList<String> yahooLocalNewsUrl() {
		ArrayList<String> Url = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://www.yahoo.com/news/us/").get();
			Elements url = doc.getElementsByClass("Mb(5px)").select("a");
			for (Element e : url) {
				Url.add(e.attr("abs:href"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Url;

	}

	public ArrayList<String> yahooLocalImageUrl() {

		ArrayList<String> ImageUrl = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://www.yahoo.com/news/us/").get();
			Elements imageUrl = doc.getElementsByClass("Cf");
			for (Element g : imageUrl) {
				if (g.getElementsByTag("img").isEmpty() == false) {

					ImageUrl.add(g.select("img").attr("abs:src"));

				} else {
					ImageUrl.add("null");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return ImageUrl;
	}

	public ArrayList<String> yahooLocalNewsdata() {
		ArrayList<String> Data = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://www.yahoo.com/news/us/").get();
			Elements data = doc.getElementsByClass("Cf").select("p");
			for (Element h : data) {
				if (!h.select("p").text().isEmpty())
					Data.add(h.select("p").text());
				else
					Data.add("null");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return Data;
	}

	public ArrayList<String> yahooWorldNewsHeadlines() {

		ArrayList<String> WorldHeadlines = new ArrayList<>();
		try {
			Document document = Jsoup.connect("https://www.yahoo.com/news/world/").get();
			Elements HeadLines = document.getElementsByClass("Mb(5px)").select("a");
			for (Element f : HeadLines) {
				WorldHeadlines.add(f.text());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return WorldHeadlines;
	}

	public ArrayList<String> yahooWorldNewsUrl() {
		ArrayList<String> worldUrl = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://www.yahoo.com/news/world/").get();
			Elements url = doc.getElementsByClass("Mb(5px)").select("a");
			for (Element e : url) {
				worldUrl.add(e.attr("abs:href"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return worldUrl;

	}

	public ArrayList<String> yahooWorldImageUrl() {

		ArrayList<String> worldImageUrl = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://www.yahoo.com/news/world/").get();
			Elements imageUrl = doc.getElementsByClass("Cf");
			for (Element g : imageUrl) {
				if (g.getElementsByTag("img").isEmpty() == false) {

					worldImageUrl.add(g.select("img").attr("abs:src"));

				} else {
					worldImageUrl.add("null");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return worldImageUrl;
	}

	public ArrayList<String> yahooWorldNewsdata() {
		ArrayList<String> worldData = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://www.yahoo.com/news/world/").get();
			Elements data = doc.getElementsByClass("Cf").select("p");
			for (Element h : data) {
				if (!h.select("p").text().isEmpty())
					worldData.add(h.select("p").text());
				else
					worldData.add("null");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return worldData;
	}

	public ArrayList<String> yahooSportsNewsHeadlines() {

		ArrayList<String> SportsHeadlines = new ArrayList<>();
		try {
			Document document = Jsoup.connect("https://sports.yahoo.com/").get();
			Elements HeadLines = document.getElementsByClass("Mb(5px)").select("a");
			for (Element f : HeadLines) {
				SportsHeadlines.add(f.text());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SportsHeadlines;
	}

	public ArrayList<String> yahooSportsNewsUrl() {
		ArrayList<String> sportsUrl = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://sports.yahoo.com/").get();
			Elements url = doc.getElementsByClass("Mb(5px)").select("a");
			for (Element e : url) {
				sportsUrl.add(e.attr("abs:href"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sportsUrl;

	}

	public ArrayList<String> yahooSportsImageUrl() {

		ArrayList<String> sportsImageUrl = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://sports.yahoo.com/").get();
			Elements imageUrl = doc.getElementsByClass("Cf");
			for (Element g : imageUrl) {
				if (g.getElementsByTag("img").isEmpty() == false) {

					sportsImageUrl.add(g.select("img").attr("abs:src"));

				} else {
					sportsImageUrl.add("null");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return sportsImageUrl;
	}

	public ArrayList<String> yahooSportsNewsdata() {
		ArrayList<String> sportsData = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://sports.yahoo.com/").get();
			Elements data = doc.getElementsByClass("Cf").select("p");
			for (Element h : data) {
				if (!h.select("p").text().isEmpty())
					sportsData.add(h.select("p").text());
				else
					sportsData.add("null");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return sportsData;
	}

}
