package ar.com.fravega.fravegaChallenge.utils;

import org.apache.logging.log4j.util.Strings;

import ar.com.fravega.fravegaChallenge.exception.BadRequestException;
import ar.com.fravega.fravegaChallenge.request.BranchRequest;

public class ValidateRequestUtils {

	private ValidateRequestUtils() {

	}

	public static void validateBranchRequest(BranchRequest request) throws BadRequestException {
		if (Strings.isEmpty(request.getAddress())) {
			throw new BadRequestException("El campo address es obligatorio!");
		}

		if (Strings.isEmpty(request.getDateAttention())) {
			throw new BadRequestException("El campo dateAttention es obligatorio!");
		}

		if (Strings.isEmpty(request.getLatitude())) {
			throw new BadRequestException("El campo latitude es obligatorio!");
		}

		if (Strings.isEmpty(request.getLongitude())) {
			throw new BadRequestException("El campo longitude es obligatorio!");
		}
	}

}
