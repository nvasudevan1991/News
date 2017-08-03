package com.project.registration;

import java.io.IOException;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		String insertTableSQL = "INSERT INTO newsdata" + "(Headlines, Url, Image, Video, date, Category, data) VALUES"
				+ "(?,?,?,?,?,?,?)";
		PreparedStatement prep = (PreparedStatement) con.prepareStatement(insertTableSQL);
		for (int i = 0; i < LocalYahooHeadlines.size(); i++) {
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

}