package com.controller;

import java.util.List;

import com.google.gson.Gson;

public class Helper {
	public static JetSki toObject(String json)
	{
		Gson gson = new Gson();
		return gson.fromJson(json, JetSki.class);
	}
	
	public static String toString(JetSki j)
	{
		Gson gson = new Gson();
		return gson.toJson(j);
	}
	
	public static String toArrayString(List<JetSki> js)
	{
		Gson gson = new Gson();
		return gson.toJson(js);
	}
	
	

}
