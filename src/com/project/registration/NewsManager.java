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
	public ArrayList<LocalNews> getrecommendedLocalNews (String fname,String lname,String category) throws Exception{
		ArrayList<LocalNews> recommendedLocalNewsList = new ArrayList<LocalNews>();
		Database db =new Database();
		Connection con = db.getConnection();
		recommendedLocalNewsList = access.getrecommendedLocalNews(con,fname,lname,category);
		return recommendedLocalNewsList;
	}
	public ArrayList<LocalNews> getrecommendedWorldNews (String fname,String lname,String category) throws Exception{
		ArrayList<LocalNews> recommendedWorldNewsList = new ArrayList<LocalNews>();
		Database db =new Database();
		Connection con = db.getConnection();
		recommendedWorldNewsList = access.getrecommendedWorldNews(con,fname,lname,category);
		return recommendedWorldNewsList;
	}
	public ArrayList<LocalNews> getrecommendedPoliticsNews (String fname,String lname,String category) throws Exception{
		ArrayList<LocalNews> recommendedPoliticsNewsList = new ArrayList<LocalNews>();
		Database db =new Database();
		Connection con = db.getConnection();
		recommendedPoliticsNewsList = access.getrecommendedPoliticsNews(con,fname,lname,category);
		return recommendedPoliticsNewsList;
	}
	public String getRecommendationList (String fname,String lname) throws Exception{
		String recommendedNewsList = null;
		Database db =new Database();
		Connection con = db.getConnection();
		recommendedNewsList = access.getrecommendedNews(con,fname,lname);
		return recommendedNewsList;
	}
	public ArrayList<LocalNews> getrecommends() throws Exception {
		ArrayList<LocalNews> recommendedList = new ArrayList<LocalNews>();
		Database db =new Database();
		Connection con = db.getConnection();
		recommendedList = access.getrecommendedList(con);
		return recommendedList;	
	}
}

