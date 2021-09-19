package ar.com.fravega.fravegaChallenge.service;

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
}