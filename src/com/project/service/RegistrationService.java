package com.project.service;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


import com.google.gson.Gson;
import com.project.registration.AccessManager;
import com.project.registration.Registration;

@Path("getUsers")
public class RegistrationService {
	
	@GET
	@Path("users")
	@Produces("application/json")
	public String users() {
		String users = null;
		ArrayList<Registration> details = new ArrayList<Registration>();
		try {
			details = new AccessManager().getDetails();
			Gson gson = new Gson();
			users = gson.toJson(details);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
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
			String etat = "ECHEC";
			Gson gson = new Gson();
			response = gson.toJson(etat);
		}
		return response;
	}

	@Path("changePassword")
	@POST
	@Produces("application/x-www-form-urlencoded")
	public String updatePassword(@FormParam("Email") String Email, @FormParam("password") String password,
			@FormParam("confirmpassword") String confirmpassword) {
		String response = "";
		Registration d = new Registration();
		try {
			d.setEmail(Email);
			d.setPassword(password);
			d.setConfirmPassword(confirmpassword);
			Gson gson = new Gson();
			new AccessManager().modifyDetails(d);
			response = gson.toJson(d);
		} catch (Exception er) {
			er.printStackTrace();
			String etat = "ECHEC";
			Gson gson = new Gson();
			response = gson.toJson(etat);
		}
		return response;
	}
}

