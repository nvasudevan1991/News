package com.project.registration;
import java.awt.Image;
import java.awt.image.*;
import java.sql.Blob;
import java.sql.Date;

public class LocalNews {
	private int id;
	private String Headlines;
	private String Data;
	private String Url;
	private String image;
	private String video;
	private String date;
	private String category;
	
	public LocalNews()
	{
		
	}
	public LocalNews(int id,String Headlines,String Url,String image,String video,String date,String category,String Data)
	{
		super();
		this.id =id;
		this.Headlines =Headlines;
		this.Data =Data;
		this.Url = Url;
		this.image = image;
		this.video = video;
		this.date=date;
		this.category = category;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getHeadlines(){
		return Headlines;
	}
	public void setHeadlines(String Headlines){
		this.Headlines = Headlines;
	}
	public String getData()
	{
		return Data;
	}
	public void setData(String Data)
	{
		this.Data = Data;
	}
	public String getUrl()
	{
		return Url;
	}
	public void setUrl(String Url)
	{
		this.Url = Url;
	}
	public String getImage()
	{
		return image;
	}
	public void setImage(String image)
	{
		this.image = image;
	}
	public String getVideo()
	{
		return video;
	}
	public void setVideo(String video)
	{
		this.video = video;
	}
	public String getDate(){
		return date;
	}
	public void setDate(String date)
	{
		this.date = date;
	}
	public String getCategory()
	{
		return category;
		
	}
	public void setCategory(String category)
	{
		this.category = category;
	}
}
