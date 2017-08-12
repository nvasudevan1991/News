package com.project.service;

import java.util.ArrayList;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;

import com.google.gson.Gson;
import com.project.registration.AccessManager;
import com.project.registration.Registration;

@Path("getUsers")
public class RegistrationService {

	@POST
	@Path("users")
	@Produces("application/json")
	public Response users(@FormParam("loginemail") String email, @FormParam("loginpass") String password,String LastLogout) {
		String users = null;

		try {
			users = new AccessManager().getDetails(email, password,LastLogout);
			String userName= users.split(" ")[0] + " " + users.split(" " )[1];
			String logoutDateTime = users.split(" " )[2]+ " "+ users.split(" ")[3] ;
			Gson gson = new Gson();
			userName = gson.toJson(userName + " " +logoutDateTime );
			if (!userName.contains("null null")) {
				String json = userName;
				return Response.ok(json, MediaType.APPLICATION_JSON).build();
			} else 
				
				return Response.status(Response.Status.BAD_REQUEST).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.ok().build();

	}

	@Path("createuser")
	@POST
	@Produces("application/x-www-form-urlencoded")
	@Consumes("application/x-www-form-urlencoded")
	public String addDetails(@FormParam("fname") String fname, @FormParam("lname") String lname,
			@FormParam("Email") String Email, @FormParam("password") String password,
			@FormParam("confirmpassword") String confirmpassword, @FormParam("mobile") String mobile,
			@FormParam("gender") String gender) {
		String response = "";
		Registration d = new Registration();
		try {
			d.setfirstName(fname);
			d.setlastName(lname);
			d.setEmail(Email);
			d.setPassword(password);
			d.setConfirmPassword(confirmpassword);
			d.setMobile(mobile);
			d.setGender(gender);
			Gson gson = new Gson();
			new AccessManager().ajouterDetails(d);
			response = gson.toJson(d);
		} catch (Exception er) {
			er.printStackTrace();
			String etat = "Error";
			//Gson gson = new Gson();
			//response = gson.toJson(etat);
			return etat;
			
		}
		return response;
	}

	@Path("changePassword")
	@POST
	@Produces("application/x-www-form-urlencoded")
	public void updatePassword(@FormParam("changeemail") String Email,@FormParam("currentpassword") String currentPassword,
			@FormParam("newpassword") String confirmpassword) {
		String response = "";
		//Registration d = new Registration();
		try {
			new AccessManager().modifyDetails(Email,confirmpassword,confirmpassword);
			Gson gson = new Gson();
			response = gson.toJson(response);
		} catch (Exception er) {
			er.printStackTrace();
			String etat = "ECHEC";
			Gson gson = new Gson();
			response = gson.toJson(etat);
		}
		
	}
	
	@Path("logoutdetails")
	@POST
	@Produces("application/x-www-form-urlencoded")
	public void updateLogoutTime(@FormParam("fname") String fname, @FormParam("lname") String lname){	
	String response = " ";
	System.out.println(fname + lname);
	try {
		new AccessManager().changeLogout(fname, lname);
		Gson gson = new Gson();
		response = gson.toJson(response);
	}catch (Exception er) {
		er.printStackTrace();
		String etat = "ECHEC";
		Gson gson = new Gson();
		response = gson.toJson(etat);
	}
}
	

}
