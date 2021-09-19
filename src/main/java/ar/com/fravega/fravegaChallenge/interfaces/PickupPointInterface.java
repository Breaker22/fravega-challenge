package ar.com.fravega.fravegaChallenge.interfaces;

import ar.com.fravega.fravegaChallenge.exception.BadRequestException;
import ar.com.fravega.fravegaChallenge.exception.PickupPointNotFoundException;
import ar.com.fravega.fravegaChallenge.request.PickupPointRequest;

public interface PickupPointInterface {
	
	Long addPickupPoint(PickupPointRequest pickupPoint) throws BadRequestException;

	void updatePickupPoint(Long id, PickupPointRequest pickupPoint) throws BadRequestException, PickupPointNotFoundException;

	void deletePickupPoint(Long id) throws PickupPointNotFoundException;

}
