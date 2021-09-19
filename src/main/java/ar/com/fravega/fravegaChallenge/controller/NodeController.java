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

	@ExceptionHandler(NodeNotFoudException.class)
	public ResponseEntity<String> notFoundNode() {
		return ResponseEntity.notFound().build();
	}
}
