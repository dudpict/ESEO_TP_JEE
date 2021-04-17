package com.ocTwic.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ocTwic.dao.VilleDaoImpl;
import com.ocTwic.dto.Ville;

/**
 * Servlet implementation class UpdateVille
 */
@WebServlet("/UpdateVille")
public class UpdateVille extends HttpServlet {
	private static final long serialVersionUID = 1L;

	VilleDaoImpl villeDaoImpl = new VilleDaoImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateVille() {
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

		String choosenVilleToDel = request.getParameter("ville");

		if (choosenVilleToDel != null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("ChangedVille", choosenVilleToDel);

			Ville ville = villeDaoImpl.recupererVilleDeFranceWithName(choosenVilleToDel);

			request.setAttribute("villeToDel", choosenVilleToDel);
			request.setAttribute("nom", ville.getNom());
			request.setAttribute("cc", ville.getCodeCommune());
			request.setAttribute("cp", ville.getCodePostal());
			request.setAttribute("lat", ville.getLatitude());
			request.setAttribute("lon", ville.getLongitude());
			request.setAttribute("libelle", ville.getLibelle());
			request.setAttribute("ligne", ville.getLigne());
			
			
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/updateVille.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String villeToDel = (String)request.getSession().getAttribute("ChangedVille");
		String nom = request.getParameter("nom");
		String cc = request.getParameter("cc");
		String cp = request.getParameter("cp");
		String lat = request.getParameter("lat");
		String lon = request.getParameter("lon");
		String libelle = request.getParameter("libelle");
		String ligne = request.getParameter("ligne");

	
		
		System.out.println("QJNFJDGNSGUS9DHGUSHU : *-----" + villeToDel+ "-------" );
		villeDaoImpl.updateVille(villeToDel, nom, cc, cp, libelle, ligne, lat, lon);
		doGet(request, response);
	}

}
