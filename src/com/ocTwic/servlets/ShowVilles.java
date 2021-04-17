package com.ocTwic.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ocTwic.dao.VilleDaoImpl;
import com.ocTwic.dto.Ville;

/**
 * Servlet implementation class ShowVilles
 */
@WebServlet("/ShowVilles")
public class ShowVilles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	VilleDaoImpl villeDaoImpl = new VilleDaoImpl();
	ArrayList<Ville> villes;
    public ShowVilles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		villes = villeDaoImpl.recupererVilleDeFrance();
		request.setAttribute("villes", villes);
		this.getServletContext().getRequestDispatcher("/WEB-INF/showVilles.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
