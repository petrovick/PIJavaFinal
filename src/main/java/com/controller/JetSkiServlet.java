package com.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JetSkiServlet")
public class JetSkiServlet extends HttpServlet
{
	private static final long serialVersionUID = 6365446292797964305L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		JetSkiApplication jsa = new JetSkiApplication();
		JetSki j = new JetSki();
		String id = request.getParameter("_id");
		
		j.setDescricao(request.getParameter("descricao"));
		j.setHp(Integer.parseInt(request.getParameter("hp")));
		j.setPeso(Integer.parseInt(request.getParameter("peso")));
		String mensagem = jsa.create(j);
		response.setContentType("text/html");
		List<JetSki> jl = jsa.todos();
		request.setAttribute("jetskies", jl);
		request.setAttribute("mensagem", mensagem);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		JetSkiApplication jsa = new JetSkiApplication();
		response.setContentType("text/html");
		List<JetSki> jl = jsa.todos();
		
		request.setAttribute("jetskies", jl);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
}