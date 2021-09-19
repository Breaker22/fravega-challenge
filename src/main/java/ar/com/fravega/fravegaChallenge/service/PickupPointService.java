package ar.com.fravega.fravegaChallenge.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.fravega.fravegaChallenge.entity.Node;
import ar.com.fravega.fravegaChallenge.entity.PickupPoint;
import ar.com.fravega.fravegaChallenge.exception.BadRequestException;
import ar.com.fravega.fravegaChallenge.exception.PickupPointNotFoundException;
import ar.com.fravega.fravegaChallenge.interfaces.PickupPointInterface;
import ar.com.fravega.fravegaChallenge.repository.NodeRepository;
import ar.com.fravega.fravegaChallenge.repository.PickupPointRepository;
import ar.com.fravega.fravegaChallenge.request.PickupPointRequest;

@Service
public class PickupPointService implements PickupPointInterface {

	@Autowired
	private NodeRepository nodeRepo;

	@Autowired
	private PickupPointRepository pickupPointRepo;

	@Override
	public Long addPickupPoint(PickupPointRequest pickupPoint) throws BadRequestException {
		PickupPoint newPickupPoint = new PickupPoint();
		Node node = new Node();

		newPickupPoint.setCapacity(pickupPoint.getCapacity());
		newPickupPoint.setLatitude(pickupPoint.getLatitude());
		newPickupPoint.setLongitude(pickupPoint.getLongitude());

		node.setPickupPoint(newPickupPoint);

		pickupPointRepo.save(newPickupPoint);
		nodeRepo.save(node);

		return newPickupPoint.getId() + 1L;
	}

	@Override
	public void updatePickupPoint(Long id, PickupPointRequest pickupPoint)
			throws BadRequestException, PickupPointNotFoundException {
		Optional<PickupPoint> oldPickupPoint = pickupPointRepo.findById(id);

		if (!oldPickupPoint.isPresent()) {
			throw new PickupPointNotFoundException("No existe el punto de retiro!");
		}

		PickupPoint newPickupPoint = new PickupPoint();

		newPickupPoint.setId(id);
		newPickupPoint.setCapacity(pickupPoint.getCapacity());
		newPickupPoint.setLatitude(pickupPoint.getLatitude());
		newPickupPoint.setLongitude(pickupPoint.getLongitude());

		pickupPointRepo.save(newPickupPoint);
	}

	@Override
	public void deletePickupPoint(Long id) throws PickupPointNotFoundException {
		Optional<PickupPoint> pickupPoint = pickupPointRepo.findById(id);

		if (!pickupPoint.isPresent()) {
			throw new PickupPointNotFoundException("No existe el punto de retiro!");
		}

		pickupPointRepo.delete(pickupPoint.get());
	}

}
