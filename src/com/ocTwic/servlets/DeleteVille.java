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
 * Servlet implementation class DeleteVille
 */
@WebServlet("/DeleteVille")
public class DeleteVille extends HttpServlet {
	private static final long serialVersionUID = 1L;

	VilleDaoImpl villeDaoImpl = new VilleDaoImpl();
	ArrayList<Ville> villes;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteVille() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String ville = request.getParameter("ville");
		System.out.println("le parametre est :" + ville);

		villeDaoImpl.deleteVilleWithNom(ville);
		this.getServletContext().getRequestDispatcher("/WEB-INF/deleteVille.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ville = request.getParameter("nomVilleDel");

		villeDaoImpl.deleteVilleWithNom(ville);

		doGet(request, response);
	}

}
