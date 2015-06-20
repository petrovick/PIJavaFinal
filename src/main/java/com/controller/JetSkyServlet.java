package com.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;

@WebServlet("/JetSkyServlet")
public class JetSkyServlet extends HttpServlet
{
	private static final long serialVersionUID = -7321681160776582861L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		JetSkiApplication jsa = new JetSkiApplication();
		JetSki j = new JetSki();
		String id = request.getParameter("descricao");
		ObjectId obId = new ObjectId(id);
		j.set_id(obId);
		j.setDescricao(request.getParameter("descricao"));
		j.setHp(Integer.parseInt(request.getParameter("hp")));
		j.setPeso(Integer.parseInt(request.getParameter("peso")));
		String retorno = jsa.Salvar(j);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Cervejas</h1><p>" + retorno + "</p>");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Refrigerante</h1>");
	}
	
}
