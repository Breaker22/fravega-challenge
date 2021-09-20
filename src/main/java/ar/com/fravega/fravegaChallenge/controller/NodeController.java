package ar.com.fravega.fravegaChallenge.controller;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.fravega.fravegaChallenge.exception.NodeNotFoudException;
import ar.com.fravega.fravegaChallenge.interfaces.NodeInterface;
import ar.com.fravega.fravegaChallenge.response.NodeResponse;

@RestController
public class NodeController {

	@Autowired
	private NodeInterface nodeService;

	@GetMapping("/")
	public ResponseEntity<NodeResponse> findNode(@Valid @RequestParam(required = true) @PathParam(value = "id") Long id)
			throws NodeNotFoudException {
		return ResponseEntity.ok().body(nodeService.findNode(id));
	}

	@GetMapping("/findNodeByPoint")
	public ResponseEntity<NodeResponse> findNodeByPoint(
			@Valid @RequestParam(required = true) @PathParam(value = "latitude") String latitude,
			@Valid @RequestParam(required = true) @PathParam(value = "longitude") String longitude)
			throws NodeNotFoudException {
		return ResponseEntity.ok().body(nodeService.findBranchByPoint(latitude, longitude));
	}

	@ExceptionHandler(NodeNotFoudException.class)
	public ResponseEntity<String> notFoundNode() {
		return ResponseEntity.notFound().build();
	}
}
