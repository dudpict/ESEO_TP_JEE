package com.ocTwic.dao;

import java.util.ArrayList;

import com.ocTwic.dto.Ville;

public interface VilleDao {

	ArrayList<Ville> recupererVilleDeFrance();

	Ville recupererVilleDeFranceWithName(String cp);
	
	public ArrayList<Ville> recupererVilleDeFranceTrieesParNom();

	void deleteVilleWithNom(String cp);

	void addVille(String nomVille, String cc, String cp, String libelle, String ligne, String lat, String lon);

	void updateVille(String nomToDel, String nomVille, String cc, String cp, String libelle, String ligne, String lat, String lon);

	
}
