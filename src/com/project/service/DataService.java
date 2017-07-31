package com.project.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.project.registration.LocalNews;
import com.project.registration.NewsManager;

@Path("data")
public class DataService {

	@GET
	@Path("localnews")
	@Produces("application/json")
	public String localNewsData()
	{
		String localNews = null;
		ArrayList<LocalNews> localNewsList = new ArrayList<LocalNews>();
		try {
			localNewsList = new NewsManager().getNews();
			Gson gson = new Gson();
			localNews = gson.toJson(localNewsList);
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return localNews;
	}
	
	@GET
	@Path("worldnews")
	@Produces("application/json")
	public String worldNewsData()
	{
		String worldNews = null;
		ArrayList<LocalNews> worldNewsList = new ArrayList<LocalNews>();
		try {
			worldNewsList = new NewsManager().getWorldNews();
			Gson gson = new Gson();
			worldNews = gson.toJson(worldNewsList);
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return worldNews;
	}
	@GET
	@Path("sportsnews")
	@Produces("application/json")
	public String sportsNewsData()
	{
		String sportsNews = null;
		ArrayList<LocalNews> sportsNewsList = new ArrayList<LocalNews>();
		try {
			sportsNewsList = new NewsManager().getsportsNews();
			Gson gson = new Gson();
			sportsNews = gson.toJson(sportsNewsList);
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return sportsNews;
	}
}
