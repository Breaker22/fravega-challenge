package ar.com.fravega.fravegaChallenge.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import ar.com.fravega.fravegaChallenge.utils.LogsUtils;

@Service
public class PickupPointService implements PickupPointInterface {

	@Autowired
	private NodeRepository nodeRepo;

	@Autowired
	private PickupPointRepository pickupPointRepo;

	private static final Logger logger = LoggerFactory.getLogger(PickupPointService.class);
	private static final String PICKUP_POINT_NOT_FOUND = "No existe el punto de retiro!";

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

		Long nodeId = node.getId();

		LogsUtils.info(logger, "Punto de Retiro guardado OK con id ".concat(Long.toString(newPickupPoint.getId())));
		LogsUtils.info(logger, "Nodo guardado OK con id ".concat(Long.toString(nodeId)));

		return nodeId;
	}

	@Override
	public void updatePickupPoint(Long id, PickupPointRequest pickupPoint)
			throws BadRequestException, PickupPointNotFoundException {
		Optional<PickupPoint> oldPickupPoint = pickupPointRepo.findById(id);

		if (!oldPickupPoint.isPresent()) {
			LogsUtils.error(logger, PICKUP_POINT_NOT_FOUND);
			throw new PickupPointNotFoundException(PICKUP_POINT_NOT_FOUND);
		}

		PickupPoint newPickupPoint = new PickupPoint();

		newPickupPoint.setId(id);
		newPickupPoint.setCapacity(pickupPoint.getCapacity());
		newPickupPoint.setLatitude(pickupPoint.getLatitude());
		newPickupPoint.setLongitude(pickupPoint.getLongitude());

		pickupPointRepo.save(newPickupPoint);

		LogsUtils.info(logger, "Update de Punto de Retiro OK");
	}

	@Override
	public void deletePickupPoint(Long id) throws PickupPointNotFoundException {
		Optional<PickupPoint> pickupPoint = pickupPointRepo.findById(id);

		if (!pickupPoint.isPresent()) {
			LogsUtils.error(logger, PICKUP_POINT_NOT_FOUND);
			throw new PickupPointNotFoundException(PICKUP_POINT_NOT_FOUND);
		}

		pickupPointRepo.delete(pickupPoint.get());

		LogsUtils.info(logger, "Punto de retiro borrado OK");
	}

}
