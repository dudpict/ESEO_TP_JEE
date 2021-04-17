package com.ocTwic.dao;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ocTwic.dto.Ville;
import com.ocTwic.toRefract.Builder;

public class VilleDaoImpl implements VilleDao {

	@Override
	public ArrayList<Ville> recupererVilleDeFrance() {

		Builder builder = new Builder();
		JSONArray json;
		ArrayList<Ville> listeVilles = null;
		try {
			json = builder.readJsonFromUrl("http://localhost:8181/ville");
			ObjectMapper mapper = new ObjectMapper();
			listeVilles = mapper.readValue(json.toString(), new TypeReference<ArrayList<Ville>>() {
			});
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("non");
		}

//		for (Ville current : listeVilles) {
//			System.out.println(current.getNom() + "/n");
//		}

		return listeVilles;
	}

	@Override
	public Ville recupererVilleDeFranceWithName(String nomToDel) {
		Builder builder = new Builder();
		JSONArray json;
		ArrayList<Ville> listeVilles = null;
		
		System.out.println("justeAvantLaLigne61 : valeur =     -"+nomToDel+"-");
		try {
			json = builder.readJsonFromUrl("http://localhost:8181/ville?nom=" + nomToDel);
			ObjectMapper mapper = new ObjectMapper();
			listeVilles = mapper.readValue(json.toString(), new TypeReference<ArrayList<Ville>>() {
			});
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		for (Ville current : listeVilles) {
//			System.out.println(current.getNom() + "\n");
//		}

		return listeVilles.get(0);
	}
	
	@Override
	public ArrayList<Ville> recupererVilleDeFranceTrieesParNom() {
		Builder builder = new Builder();
		JSONArray json;
		ArrayList<Ville> listeVilles = null;
		try {
			json = builder.readJsonFromUrl("http://localhost:8181/ville?orderByNom=yes");
			ObjectMapper mapper = new ObjectMapper();
			listeVilles = mapper.readValue(json.toString(), new TypeReference<ArrayList<Ville>>() {});
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		for (Ville current : listeVilles) {
//			System.out.println(current.getNom() + "\n");
//		}

		return listeVilles;
	}

	@Override
	public void deleteVilleWithNom(String nom) {
		try {
			URL url = new URL("http://127.0.0.1:8181/ville?nomVille="+nom);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setRequestMethod("DELETE");
			httpUrlConnection.setRequestProperty("Accept", "application/json");

			if (httpUrlConnection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + httpUrlConnection.getResponseCode());
			}

			System.out.println("Output from Serveur ... /n");
			httpUrlConnection.disconnect();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void addVille(String nomVille, String cc, String cp, String libelle, String ligne, String lat, String lon) {
		try {
			URL url = new URL("http://127.0.0.1:8181/ville?codeCommune=" + cc + "&codePostal=" + cp + "&nom=" + nomVille
					+ "&libelle=" + libelle + "&longitude=" + lon + "&latitude=" + lat + "&ligne=" + ligne);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setRequestMethod("POST");
			httpUrlConnection.setRequestProperty("Accept", "application/json");

			if (httpUrlConnection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + httpUrlConnection.getResponseCode());
			}

			System.out.println("Output from Serveur ... /n");
			httpUrlConnection.disconnect();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateVille(String nomToDel, String nomVille, String cc, String cp, String libelle, String ligne, String lat,
			String lon) {
		// TODO Auto-generated method stub
		
		try {
			URL url = new URL("http://127.0.0.1:8181/ville?nomToDel="+nomToDel + "&codeCommune=" + cc + "&codePostal=" + cp + "&nom=" + nomVille
					+ "&libelle=" + libelle + "&longitude=" + lon + "&latitude=" + lat + "&ligne=" + ligne);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setRequestMethod("PUT");
			httpUrlConnection.setRequestProperty("Accept", "application/json");

			if (httpUrlConnection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + httpUrlConnection.getResponseCode());
			}

			System.out.println("Output from Serveur ... /n");
			httpUrlConnection.disconnect();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
