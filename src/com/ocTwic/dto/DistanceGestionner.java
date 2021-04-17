package com.ocTwic.dto;

public class DistanceGestionner {

	public double get_distance_m(String lat1, String lng1, String lat2, String lng2) {
		int earth_radius = 6378137; // Terre = sphère de 6378km de rayon
		double rlo1 = deg2rad(Double.parseDouble(lng1));
		double rla1 = deg2rad(Double.parseDouble(lat1));
		double rlo2 = deg2rad(Double.parseDouble(lng2));
		double rla2 = deg2rad(Double.parseDouble(lat2));
		double dlo = (rlo2 - rlo1) / 2;
		double dla = (rla2 - rla1) / 2;

		double a = (Math.sin(dla) * Math.sin(dla)) + Math.cos(rla1) * Math.cos(rla2) * (Math.sin(dlo) * Math.sin(dlo));
		double d = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		return (earth_radius * d);
	}

	double deg2rad(double coord) {
		return coord * Math.PI / 180;
	}
}
