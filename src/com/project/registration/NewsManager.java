package com.project.registration;

import java.sql.Connection;
import java.util.ArrayList;

import org.apache.tomcat.jni.Local;

import com.mysql.fabric.xmlrpc.base.Array;

public class NewsManager {

	Access access = new Access();

	public ArrayList<LocalNews>getNews() throws Exception {
		ArrayList<LocalNews> localNewsList = new ArrayList<LocalNews>();
		Database db =new Database();
		Connection con = db.getConnection();
		localNewsList = access.getNews(con);
		return localNewsList;
	}
	public ArrayList<LocalNews> getWorldNews() throws Exception {
		ArrayList<LocalNews> WorldNewsList = new ArrayList<LocalNews>();
		Database db =new Database();
		Connection con = db.getConnection();
		WorldNewsList = access.getWorldNews(con);
		return WorldNewsList;
	}
	public ArrayList<LocalNews> getsportsNews() throws Exception {
		ArrayList<LocalNews> SportsNewsList = new ArrayList<LocalNews>();
		Database db =new Database();
		Connection con = db.getConnection();
		SportsNewsList = access.getsportsNews(con);
		return SportsNewsList;
	}
}
