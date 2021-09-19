package ar.com.fravega.fravegaChallenge.response;

import ar.com.fravega.fravegaChallenge.entity.Node;
import ar.com.fravega.fravegaChallenge.entity.PickupPoint;
import ar.com.fravega.fravegaChallenge.request.PickupPointRequest;

public class PickupPointResponse extends PickupPointRequest {

	public PickupPointResponse(PickupPoint pickupPoint) {
		super.setCapacity(pickupPoint.getCapacity());
		super.setLatitude(pickupPoint.getLatitude());
		super.setLongitude(pickupPoint.getLongitude());
	}

	public PickupPointResponse(Node node) {
		super.setCapacity(node.getPickupPoint().getCapacity());
		super.setLatitude(node.getPickupPoint().getLatitude());
		super.setLongitude(node.getPickupPoint().getLongitude());
	}

}
