package com.project.registration;

import java.awt.Image;
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
		// String connectionURL = "jdbc:mysql://127.0.0.1:3306/registration";
		DataPuller d = new DataPuller();
		// Connection con = null;
		// con = (Connection) DriverManager.getConnection(connectionURL, "root",
		// "root");
		ArrayList<String> answer = d.localNews();
		System.out.println(answer);
		/*
		 * String insertTableSQL = "INSERT INTO newsdata" +
		 * "(Headlines, Url, Image, Video, date, Category, data) VALUES" +
		 * "(?,?,?,?,?,?,?)"; PreparedStatement prep = (PreparedStatement)
		 * con.prepareStatement(insertTableSQL); prep.setString(1,
		 * answer.get(0).toString()); prep.setString(2,
		 * answer.get(0).toString()); prep.setString(3,
		 * answer.get(0).toString()); prep.setString(4,
		 * answer.get(0).toString()); prep.setString(5,
		 * answer.get(0).toString()); //prep.setString(6,
		 * Integer.toString(datetoday)); prep.setString(7,
		 * answer.get(0).toString());
		 * 
		 * prep.executeUpdate();
		 */
	}

	public ArrayList<String> localNews() {

		ArrayList<String> Headlines = new ArrayList<>();
		ArrayList<String> Url = new ArrayList<>();
		ArrayList<String> ImageUrl = new ArrayList<>();
		ArrayList<String> Data = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://www.yahoo.com/news/us/").get();
			Elements url = doc.getElementsByClass("Mb(5px)").select("a");
			Elements HeadLines = doc.getElementsByClass("Mb(5px)").select("a");
			Elements imageUrl = doc.getElementsByClass("Cf");
			Elements data = doc.getElementsByClass("Cf").select("p");
			// System.out.println(imageUrl);
			for (Element e : url) {
				Url.add(e.attr("abs:href"));
			}
			for (Element f : HeadLines) {
				Headlines.add(f.text());
			}
			for (Element g : imageUrl) {
				if (g.getElementsByTag("img").isEmpty() == false) {
					if (!g.select("img").attr("abs:src").contains(".gif"))

						ImageUrl.add(g.select("img").attr("abs:src"));
				} else {
					ImageUrl.add(null);
				}
			}
			for (Element h : data) {

				Data.add(h.select("p").text());
			}
			System.out.println(Url.get(0));
			System.out.println(ImageUrl.get(0));
			System.out.println(Headlines.get(0));
			System.out.println(Data.get(3));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return Headlines;
	}
}
