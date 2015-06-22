package com.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JetSkiServlet")
public class JetSkiServlet extends HttpServlet
{
	private static final long serialVersionUID = -7321681160776582861L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		JetSkiApplication jsa = new JetSkiApplication();
		StringBuffer mensagem = new StringBuffer();
		boolean valido = jsa.validar(request.getParameter("descricao"), request.getParameter("hp"), request.getParameter("peso"), mensagem);
		JetSki j = new JetSki();
		if(valido)
		{
			String id = request.getParameter("_id");
			j.setDescricao(request.getParameter("descricao"));
			j.setHp(Integer.parseInt(request.getParameter("hp")));
			j.setPeso(Integer.parseInt(request.getParameter("peso")));
			if(mensagem == null)
				mensagem.append(jsa.create(j));
		}
		List<JetSki> jsl = new ArrayList<JetSki>();
		try
		{
			jsl = jsa.todos();
		}
		catch(Exception ex)
		{
			mensagem.append(ex.getMessage());
		}
		getServletContext().setAttribute("jetskies", jsl);
		getServletContext().setAttribute("mensagem", mensagem);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		JetSkiApplication jsa = new JetSkiApplication();
		List<JetSki> jsl = new ArrayList<JetSki>();
		String mensagem = "";
		try
		{
			jsl = jsa.todos();
		}
		catch(Exception ex)
		{
			mensagem = ex.getMessage();
		}
		getServletContext().setAttribute("jetskies", jsl);
		getServletContext().setAttribute("mensagem", mensagem);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
	
}
