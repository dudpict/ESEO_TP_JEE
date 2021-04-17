package com.ocTwic.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ocTwic.dao.VilleDaoImpl;

/**
 * Servlet implementation class AddVille
 */
@WebServlet("/AddVille")
public class AddVille extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVille() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/addVille.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nom = request.getParameter("nom");
		String cc = request.getParameter("cc");
		String cp = request.getParameter("cp");
		String libelle = request.getParameter("libelle");
		String lon = request.getParameter("lon");
		String lat = request.getParameter("lat");
		String ligne = request.getParameter("ligne");
		
		VilleDaoImpl villeDaoImpl = new VilleDaoImpl();
		villeDaoImpl.addVille(nom, cc, cp, libelle, ligne, lat, lon);
		
		doGet(request, response);
	}

}
