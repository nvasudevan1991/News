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
		ArrayList<String> PoliticsYahooHeadlines = d.yahooPoliticsNewsHeadlines();
		ArrayList<String> PoliticsYahooUrl = d.yahooPoliticsNewsUrl();
		ArrayList<String> PoliticsYahooImageUrl = d.yahooPoliticsImageUrl();
		ArrayList<String> PoliticsYahooData = d.yahooPoliticsNewsdata();
		ArrayList<String> LocalYorkHeadlines = d.yorkLocalNewsHeadlines();
		ArrayList<String> LocalYorkUrl = d.yorkLocalNewsUrl();
		ArrayList<String> LocalYorkImageUrl = d.yorkLocalImageUrl();
		ArrayList<String> LocalYorkData = d.yorkLocalNewsdata();
		ArrayList<String> WorldYorkHeadlines = d.yorkWorldNewsHeadlines();
		ArrayList<String> WorldYorkUrl = d.yorkWorldNewsUrl();
		ArrayList<String> WorldYorkImageUrl = d.yorkWorldImageUrl();
		ArrayList<String> WorldYorkData = d.yorkWorldNewsdata();
		ArrayList<String> PoliticsYorkHeadlines = d.yorkPoliticsNewsHeadlines();
		ArrayList<String> PoliticsYorkUrl = d.yorkPoliticsNewsUrl();
		ArrayList<String> PoliticsYorkImageUrl = d.yorkPoliticsImageUrl();
		ArrayList<String> PoliticsYorkData = d.yorkPoliticsNewsdata();

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
		for (int i = 0; i < PoliticsYahooHeadlines.size(); i++) {
			String checkContent = "SELECT COUNT(Headlines) FROM newsdata WHERE Headlines = ?";
			PreparedStatement stmt = con.prepareStatement(checkContent);
			stmt.setString(1, PoliticsYahooHeadlines.get(i).toString());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				if (count == 0)

				{
					String insertTableSQL = "INSERT INTO newsdata"
							+ "(Headlines, Url, Image, Video, date, Category, data) VALUES" + "(?,?,?,?,?,?,?)";
					PreparedStatement prep = (PreparedStatement) con.prepareStatement(insertTableSQL);
					prep.setString(1, PoliticsYahooHeadlines.get(i).toString());
					prep.setString(2, PoliticsYahooUrl.get(i).toString());
					prep.setString(3, PoliticsYahooImageUrl.get(i).toString());
					prep.setString(4, "null");
					prep.setString(5, "null");
					prep.setString(6, "PoliticsNews");
					prep.setString(7, PoliticsYahooData.get(i).toString());

					prep.executeUpdate();

				}

			}

		}

		for (int i = 0; i < LocalYorkHeadlines.size(); i++) {
			String checkContent = "SELECT COUNT(Headlines) FROM newsdata WHERE Headlines = ?";
			PreparedStatement stmt = con.prepareStatement(checkContent);
			stmt.setString(1, LocalYorkHeadlines.get(i).toString());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);

				if (count == 0)

				{
					String insertTableSQL = "INSERT INTO newsdata"
							+ "(Headlines, Url, Image, Video, date, Category, data) VALUES" + "(?,?,?,?,?,?,?)";
					PreparedStatement prep = (PreparedStatement) con.prepareStatement(insertTableSQL);
					prep.setString(1, LocalYorkHeadlines.get(i).toString());
					prep.setString(2, LocalYorkUrl.get(i).toString());
					prep.setString(3, LocalYorkImageUrl.get(i).toString());
					prep.setString(4, "null");
					prep.setString(5, "null");
					prep.setString(6, "LocalNews");
					prep.setString(7, LocalYorkData.get(i).toString());

					prep.executeUpdate();

				}

			}
		}
		for (int i = 0; i < WorldYorkHeadlines.size(); i++) {
			String checkContent = "SELECT COUNT(Headlines) FROM newsdata WHERE Headlines = ?";
			PreparedStatement stmt = con.prepareStatement(checkContent);
			stmt.setString(1, WorldYorkHeadlines.get(i).toString());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);

				if (count == 0)

				{
					String insertTableSQL = "INSERT INTO newsdata"
							+ "(Headlines, Url, Image, Video, date, Category, data) VALUES" + "(?,?,?,?,?,?,?)";
					PreparedStatement prep = (PreparedStatement) con.prepareStatement(insertTableSQL);
					prep.setString(1, WorldYorkHeadlines.get(i).toString());
					prep.setString(2, WorldYorkUrl.get(i).toString());
					prep.setString(3, WorldYorkImageUrl.get(i).toString());
					prep.setString(4, "null");
					prep.setString(5, "null");
					prep.setString(6, "WorldNews");
					prep.setString(7, WorldYorkData.get(i).toString());

					prep.executeUpdate();

				}

			}
		}

		for (int i = 0; i < PoliticsYorkHeadlines.size(); i++) {
			String checkContent = "SELECT COUNT(Headlines) FROM newsdata WHERE Headlines = ?";
			PreparedStatement stmt = con.prepareStatement(checkContent);
			stmt.setString(1, PoliticsYorkHeadlines.get(i).toString());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);

				if (count == 0)

				{
					String insertTableSQL = "INSERT INTO newsdata"
							+ "(Headlines, Url, Image, Video, date, Category, data) VALUES" + "(?,?,?,?,?,?,?)";
					PreparedStatement prep = (PreparedStatement) con.prepareStatement(insertTableSQL);
					prep.setString(1, PoliticsYorkHeadlines.get(i).toString());
					prep.setString(2, PoliticsYorkUrl.get(i).toString());
					prep.setString(3, PoliticsYorkImageUrl.get(i).toString());
					prep.setString(4, "null");
					prep.setString(5, "null");
					prep.setString(6, "PoliticsNews");
					prep.setString(7, PoliticsYorkData.get(i).toString());

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

	public ArrayList<String> yahooPoliticsNewsHeadlines() {

		ArrayList<String> PoliticsHeadlines = new ArrayList<>();
		try {
			Document document = Jsoup.connect("https://www.yahoo.com/news/politics/").get();
			Elements HeadLines = document.getElementsByClass("Mb(5px)").select("a");
			for (Element f : HeadLines) {
				PoliticsHeadlines.add(f.text());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return PoliticsHeadlines;
	}

	public ArrayList<String> yahooPoliticsNewsUrl() {
		ArrayList<String> PoliticsUrl = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://www.yahoo.com/news/politics/").get();
			Elements url = doc.getElementsByClass("Mb(5px)").select("a");
			for (Element e : url) {
				PoliticsUrl.add(e.attr("abs:href"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return PoliticsUrl;

	}

	public ArrayList<String> yahooPoliticsImageUrl() {

		ArrayList<String> PoliticsImageUrl = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://www.yahoo.com/news/politics/").get();
			Elements imageUrl = doc.getElementsByClass("Cf");
			for (Element g : imageUrl) {
				if (g.getElementsByTag("img").isEmpty() == false) {

					PoliticsImageUrl.add(g.select("img").attr("abs:src"));

				} else {
					PoliticsImageUrl.add("null");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return PoliticsImageUrl;
	}

	public ArrayList<String> yahooPoliticsNewsdata() {
		ArrayList<String> PoliticsData = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://www.yahoo.com/news/politics/").get();
			Elements data = doc.getElementsByClass("Cf").select("p");
			for (Element h : data) {
				if (!h.select("p").text().isEmpty())
					PoliticsData.add(h.select("p").text());
				else
					PoliticsData.add("null");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return PoliticsData;
	}

	public ArrayList<String> yorkLocalNewsHeadlines() {

		ArrayList<String> LocalHeadlines = new ArrayList<>();
		try {
			Document document = Jsoup.connect("https://www.nytimes.com/section/us").get();
			Elements HeadLines = document.getElementsByClass("story-meta").select("h2");
			for (Element f : HeadLines) {
				LocalHeadlines.add(f.text());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return LocalHeadlines;
	}

	public ArrayList<String> yorkLocalNewsUrl() {
		ArrayList<String> LocalUrl = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://www.nytimes.com/section/us").get();
			Elements url = doc.getElementsByClass("story-link").select("a");
			for (Element e : url) {
				LocalUrl.add(e.attr("abs:href"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return LocalUrl;

	}

	public ArrayList<String> yorkLocalImageUrl() {

		ArrayList<String> LocalImageUrl = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://www.nytimes.com/section/us").get();
			Elements imageUrl = doc.getElementsByClass("story-link");
			for (Element g : imageUrl) {
				if (g.getElementsByTag("img").isEmpty() == false) {

					LocalImageUrl.add(g.select("img").attr("abs:src"));

				} else {
					LocalImageUrl.add("null");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return LocalImageUrl;
	}

	public ArrayList<String> yorkLocalNewsdata() {
		ArrayList<String> LocalData = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://www.nytimes.com/section/us").get();
			Elements data = doc.getElementsByClass("story-meta");
			for (Element h : data) {
				if (!h.getElementsByClass("summary").select("p").text().isEmpty())
					LocalData.add(h.select("p").text());
				else
					LocalData.add("null");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return LocalData;
	}

	public ArrayList<String> yorkWorldNewsHeadlines() {

		ArrayList<String> WorldHeadlines = new ArrayList<>();
		try {
			Document document = Jsoup.connect("https://www.nytimes.com/section/world").get();
			Elements HeadLines = document.getElementsByClass("story-meta").select("h2");
			for (Element f : HeadLines) {
				WorldHeadlines.add(f.text());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return WorldHeadlines;
	}

	public ArrayList<String> yorkWorldNewsUrl() {
		ArrayList<String> WorldUrl = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://www.nytimes.com/section/world").get();
			Elements url = doc.getElementsByClass("story-link").select("a");
			for (Element e : url) {
				WorldUrl.add(e.attr("abs:href"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return WorldUrl;

	}

	public ArrayList<String> yorkWorldImageUrl() {

		ArrayList<String> WorldImageUrl = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://www.nytimes.com/section/world").get();
			Elements imageUrl = doc.getElementsByClass("story-link");
			for (Element g : imageUrl) {
				if (g.getElementsByTag("img").isEmpty() == false) {

					WorldImageUrl.add(g.select("img").attr("abs:src"));

				} else {
					WorldImageUrl.add("null");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return WorldImageUrl;
	}

	public ArrayList<String> yorkWorldNewsdata() {
		ArrayList<String> WorldData = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://www.nytimes.com/section/world").get();
			Elements data = doc.getElementsByClass("story-meta");
			for (Element h : data) {
				if (!h.getElementsByClass("summary").select("p").text().isEmpty())
					WorldData.add(h.select("p").text());
				else
					WorldData.add("null");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return WorldData;
	}

	public ArrayList<String> yorkPoliticsNewsHeadlines() {

		ArrayList<String> PoliticsHeadlines = new ArrayList<>();
		try {
			Document document = Jsoup.connect("https://www.nytimes.com/section/politics").get();
			Elements HeadLines = document.getElementsByClass("story-meta").select("h2");
			for (Element f : HeadLines) {
				PoliticsHeadlines.add(f.text());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return PoliticsHeadlines;
	}

	public ArrayList<String> yorkPoliticsNewsUrl() {
		ArrayList<String> PoliticsUrl = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://www.nytimes.com/section/politics").get();
			Elements url = doc.getElementsByClass("story-link").select("a");
			for (Element e : url) {
				PoliticsUrl.add(e.attr("abs:href"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return PoliticsUrl;

	}

	public ArrayList<String> yorkPoliticsImageUrl() {

		ArrayList<String> PoliticsImageUrl = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://www.nytimes.com/section/politics").get();
			Elements imageUrl = doc.getElementsByClass("story-link");
			for (Element g : imageUrl) {
				if (g.getElementsByTag("img").isEmpty() == false) {

					PoliticsImageUrl.add(g.select("img").attr("abs:src"));

				} else {
					PoliticsImageUrl.add("null");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return PoliticsImageUrl;
	}

	public ArrayList<String> yorkPoliticsNewsdata() {
		ArrayList<String> PoliticsData = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://www.nytimes.com/section/politics").get();
			Elements data = doc.getElementsByClass("story-meta");
			for (Element h : data) {
				if (!h.getElementsByClass("summary").select("p").text().isEmpty())
					PoliticsData.add(h.select("p").text());
				else
					PoliticsData.add("null");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return PoliticsData;
	}
}
