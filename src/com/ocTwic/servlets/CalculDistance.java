package com.ocTwic.servlets;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ocTwic.dao.VilleDaoImpl;
import com.ocTwic.dto.DistanceGestionner;
import com.ocTwic.dto.Ville;

/**
 * Servlet implementation class CalculDistance
 */
@WebServlet("/CalculDistance")
public class CalculDistance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VilleDaoImpl villeDaoImpl;
	ArrayList<Ville> villes;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalculDistance() {
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
		
		villeDaoImpl = new VilleDaoImpl();
		villes = villeDaoImpl.recupererVilleDeFranceTrieesParNom();
		request.setAttribute("villes", villes);

		this.getServletContext().getRequestDispatcher("/WEB-INF/calculDistance.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		villeDaoImpl = new VilleDaoImpl();
		villes = villeDaoImpl.recupererVilleDeFranceTrieesParNom();
		
		String nomA = request.getParameter("pointA");
		request.setAttribute("nomA", nomA);
		String nomB = request.getParameter("pointB");
		request.setAttribute("nomB", nomB);
		
		Ville villeA = new Ville();
		Ville villeB = new Ville();

		for (Ville current : villes) {
			if (current.getNom().equals(nomA)) {
				villeA = current;
			} else if (current.getNom().equals(nomB)) {
				villeB = current;
			}
		}
		
		DistanceGestionner distanceGestionner = new DistanceGestionner();
		double distance = distanceGestionner.get_distance_m(villeA.getLatitude(), villeA.getLongitude(), villeB.getLatitude(), villeB.getLongitude()) / 1000;
		DecimalFormat format = new DecimalFormat();
		format.setMaximumFractionDigits(1);
		request.setAttribute("distance", format.format(distance));
		
		doGet(request, response);
	}
}
