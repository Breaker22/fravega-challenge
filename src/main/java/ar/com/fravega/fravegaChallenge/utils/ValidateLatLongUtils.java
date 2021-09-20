package ar.com.fravega.fravegaChallenge.utils;

public class ValidateLatLongUtils {

	private ValidateLatLongUtils() {

	}

	public static double getDistanceFromLatLonInKm(Double lat1, Double lon1, Double lat2, Double lon2) {
		int R = 6371; // radio de la tierra en KM
		Double dLat = deg2rad(lat2 - lat1);
		Double dLon = deg2rad(lon2 - lon1);
		Double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
		;
		Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		Double d = R * c; // Distancia en KM

		return d;
	}

	private static Double deg2rad(Double deg) {
		return deg * (Math.PI / 180);
	}
}
