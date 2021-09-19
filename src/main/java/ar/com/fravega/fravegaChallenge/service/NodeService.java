package ar.com.fravega.fravegaChallenge.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.fravega.fravegaChallenge.entity.Node;
import ar.com.fravega.fravegaChallenge.exception.NodeNotFoudException;
import ar.com.fravega.fravegaChallenge.interfaces.NodeInterface;
import ar.com.fravega.fravegaChallenge.repository.NodeRepository;
import ar.com.fravega.fravegaChallenge.response.NodeResponse;

@Service
public class NodeService implements NodeInterface {

	@Autowired
	private NodeRepository nodeRepo;

	@Override
	public NodeResponse findNode(Long id) throws NodeNotFoudException {

		Optional<Node> node = nodeRepo.findById(id);

		if (!node.isPresent()) {
			throw new NodeNotFoudException("No existe el Nodo!");
		}

		return new NodeResponse(node.get());
	}
}