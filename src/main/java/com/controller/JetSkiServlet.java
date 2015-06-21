package com.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;

@WebServlet("/JetSkyServlet")
public class JetSkiServlet extends HttpServlet
{
	private static final long serialVersionUID = -7321681160776582861L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		JetSkiApplication jsa = new JetSkiApplication();
		JetSki j = new JetSki();
		String id = request.getParameter("_id");
		
		j.setDescricao(request.getParameter("descricao"));
		j.setHp(Integer.parseInt(request.getParameter("hp")));
		j.setPeso(Integer.parseInt(request.getParameter("peso")));
		String mensagem = validar(request.getParameter("descricao"), request.getParameter("hp"), request.getParameter("peso"));
		if(mensagem == null)
			mensagem = jsa.create(j);
		List<JetSki> jsl = jsa.todos();
		getServletContext().setAttribute("jetskies", jsl);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		JetSkiApplication jsa = new JetSkiApplication();
		List<JetSki> jsl = jsa.todos();
		
		getServletContext().setAttribute("jetskies", jsl);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
	
	public String validar(String descricao, String hp, String peso)
	{
		String mensagem = null;
		try
		{
			Integer.parseInt(hp);
			Integer.parseInt(peso);
		}
		catch(Exception ex)
		{
			mensagem = ex.getMessage();
		}
		if(descricao.length() < 10)
			mensagem = "Sua descrição deve ter acima de 10 letras";
		
		return mensagem;
	}
}
