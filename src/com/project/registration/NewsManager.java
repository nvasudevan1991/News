package com.project.registration;

import java.sql.Connection;
import java.util.ArrayList;

import org.apache.tomcat.jni.Local;

import com.mysql.fabric.xmlrpc.base.Array;

public class NewsManager {

	Access access = new Access();

	public ArrayList<LocalNews>getNews(String logoutDetailTime) throws Exception {
		ArrayList<LocalNews> localNewsList = new ArrayList<LocalNews>();
		Database db =new Database();
		Connection con = db.getConnection();
		localNewsList = access.getNews(con,logoutDetailTime);
		return localNewsList;
	}
	public ArrayList<LocalNews> getWorldNews(String logoutDetailTime) throws Exception {
		ArrayList<LocalNews> WorldNewsList = new ArrayList<LocalNews>();
		Database db =new Database();
		Connection con = db.getConnection();
		WorldNewsList = access.getWorldNews(con,logoutDetailTime);
		return WorldNewsList;
	}
	public ArrayList<LocalNews> getsportsNews(String logoutDetailTime) throws Exception {
		ArrayList<LocalNews> SportsNewsList = new ArrayList<LocalNews>();
		Database db =new Database();
		Connection con = db.getConnection();
		SportsNewsList = access.getsportsNews(con,logoutDetailTime);
		return SportsNewsList;
	}
	public ArrayList<LocalNews> getSearchNews(String searchcontent) throws Exception {
		ArrayList<LocalNews> SearchNewsList = new ArrayList<LocalNews>();
		Database db =new Database();
		Connection con = db.getConnection();
		SearchNewsList = access.getSearchNews(con,searchcontent);
		return SearchNewsList;
	}
}

