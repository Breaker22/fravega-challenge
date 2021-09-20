package ar.com.fravega.fravegaChallenge.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.fravega.fravegaChallenge.entity.Node;
import ar.com.fravega.fravegaChallenge.exception.NodeNotFoudException;
import ar.com.fravega.fravegaChallenge.interfaces.NodeInterface;
import ar.com.fravega.fravegaChallenge.repository.NodeRepository;
import ar.com.fravega.fravegaChallenge.response.NodeResponse;
import ar.com.fravega.fravegaChallenge.utils.LogsUtils;
import ar.com.fravega.fravegaChallenge.utils.ValidateLatLongUtils;

@Service
public class NodeService implements NodeInterface {

	@Autowired
	private NodeRepository nodeRepo;

	private static final Logger logger = LoggerFactory.getLogger(NodeService.class);
	private static final String NODE_NOT_FOUND = "No existe el Nodo!";

	@Override
	public NodeResponse findNode(Long id) throws NodeNotFoudException {

		Optional<Node> node = nodeRepo.findById(id);

		if (!node.isPresent()) {
			LogsUtils.error(logger, NODE_NOT_FOUND);
			throw new NodeNotFoudException(NODE_NOT_FOUND);
		}

		LogsUtils.info(logger, "Nodo encontrado OK");

		return new NodeResponse(node.get());
	}

	@Override
	public NodeResponse findBranchByPoint(String latitude, String longitude) {

		List<Node> listNodes = nodeRepo.findAll();
		Double distanceBranch = new Double("0");
		Double distancePickup = new Double("0");
		NodeResponse nodeResponse = new NodeResponse();
		NodeResponse nodeResponse2 = new NodeResponse();

		for (Node node : listNodes) {
			Double auxDistanceBranch = new Double("0"); // 0km 0km 20km 20km
			Double auxDistancePickup = new Double("0");

			if (node.getBranch() != null && distanceBranch <= auxDistanceBranch) {
				distanceBranch = ValidateLatLongUtils.getDistanceFromLatLonInKm(Double.parseDouble(latitude),
						Double.parseDouble(longitude), Double.parseDouble(node.getBranch().getLatitude()),
						Double.parseDouble(node.getBranch().getLongitude()));
				auxDistanceBranch = new Double(distanceBranch);
				nodeResponse = new NodeResponse(node);
			}

			if (node.getPickupPoint() != null && distancePickup <= auxDistancePickup) {
				distancePickup = ValidateLatLongUtils.getDistanceFromLatLonInKm(Double.parseDouble(latitude),
						Double.parseDouble(longitude), Double.parseDouble(node.getPickupPoint().getLatitude()),
						Double.parseDouble(node.getPickupPoint().getLongitude()));
				auxDistancePickup = new Double(distancePickup);
				nodeResponse2 = new NodeResponse(node);
			}

		}
		
		if(distancePickup < distanceBranch) {
			return nodeResponse2;
		}

		return nodeResponse;
	}
}