package com.project.service;

import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.project.registration.LocalNews;
import com.project.registration.NewsManager;

@Path("data")
public class DataService {

	@POST
	@Path("localnews")
	@Produces("application/json")
	public String localNewsData(@FormParam("logoutDetailTime") String logoutDetailTime) {
		String localNews = null;
		ArrayList<LocalNews> localNewsList = new ArrayList<LocalNews>();
		try {
			localNewsList = new NewsManager().getNews(logoutDetailTime);
			Gson gson = new Gson();
			localNews = gson.toJson(localNewsList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return localNews;
	}

	@POST
	@Path("worldnews")
	@Produces("application/json")
	public String worldNewsData(@FormParam("logoutDetailTime") String logoutDetailTime) {
		String worldNews = null;
		ArrayList<LocalNews> worldNewsList = new ArrayList<LocalNews>();
		try {
			worldNewsList = new NewsManager().getWorldNews(logoutDetailTime);
			Gson gson = new Gson();
			worldNews = gson.toJson(worldNewsList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return worldNews;
	}

	@POST
	@Path("sportsnews")
	@Produces("application/json")
	public String sportsNewsData(@FormParam("logoutDetailTime") String logoutDetailTime) {
		String sportsNews = null;
		ArrayList<LocalNews> sportsNewsList = new ArrayList<LocalNews>();
		try {
			sportsNewsList = new NewsManager().getsportsNews(logoutDetailTime);
			Gson gson = new Gson();
			sportsNews = gson.toJson(sportsNewsList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sportsNews;
	}

	@POST
	@Path("search")
	@Produces("application/json")
	public String searchNewsData(@FormParam("searchcontent") String searchcontent) {
		String search = null;
		ArrayList<LocalNews> searchNewsList = new ArrayList<LocalNews>();
		try {
			searchNewsList = new NewsManager().getSearchNews(searchcontent);
			Gson gson = new Gson();
			search = gson.toJson(searchNewsList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return search;
	}

}
