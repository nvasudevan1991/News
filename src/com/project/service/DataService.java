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
			System.out.println(localNews);
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
			System.out.println(worldNews);
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
		System.out.println(logoutDetailTime);
		ArrayList<LocalNews> sportsNewsList = new ArrayList<LocalNews>();
		try {
			sportsNewsList = new NewsManager().getsportsNews(logoutDetailTime);
			Gson gson = new Gson();
			sportsNews = gson.toJson(sportsNewsList);
			System.out.println(sportsNews);
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

	@POST
	@Path("recommends")
	@Produces("application/json")
	public String recommendedLocalNews(@FormParam("id") String id, @FormParam("url") String url,
			@FormParam("fname") String fname, @FormParam("lname") String lname,
			@FormParam("category") String category) {
		String recommendedlocalNews = null;
		ArrayList<LocalNews> recommendedLocalNewsList = new ArrayList<LocalNews>();
		if (category.equals("LocalNews")) {
			if (!fname.contentEquals("null") && !lname.contentEquals("null")) {
				try {
					recommendedLocalNewsList = new NewsManager().getrecommendedLocalNews(fname, lname, category);
					Gson gson = new Gson();
					recommendedlocalNews = gson.toJson(recommendedLocalNewsList);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		} else if (category.equals("WorldNews")) {
			if (!fname.contentEquals("null") && !lname.contentEquals("null")) {
				try {
					recommendedLocalNewsList = new NewsManager().getrecommendedWorldNews(fname, lname, category);
					Gson gson = new Gson();
					recommendedlocalNews = gson.toJson(recommendedLocalNewsList);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		} else if (category.equals("PoliticsNews")) {
			if (!fname.contentEquals("null") && !lname.contentEquals("null")) {
				try {
					recommendedLocalNewsList = new NewsManager().getrecommendedPoliticsNews(fname, lname, category);
					Gson gson = new Gson();
					recommendedlocalNews = gson.toJson(recommendedLocalNewsList);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}

		return recommendedlocalNews;
	}

	@POST
	@Path("recommendslist")
	@Produces("application/json")
	public String recommendationList(@FormParam("fname") String fname, @FormParam("lname") String lname) {
		String search = null;
		ArrayList<LocalNews> searchNewsList = new ArrayList<LocalNews>();
		try {
			search = new NewsManager().getRecommendationList(fname, lname);
			String highest = search.split(" ")[0];
			String middle = search.split(" ")[1];
			String lowest = search.split(" ")[2];
				searchNewsList = new NewsManager().getrecommends(highest,middle,lowest);
				Gson gson = new Gson();
				search = gson.toJson(searchNewsList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return search;
	}

}
