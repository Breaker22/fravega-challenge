package ar.com.fravega.fravegaChallenge.controller;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.fravega.fravegaChallenge.exception.BadRequestException;
import ar.com.fravega.fravegaChallenge.exception.BranchNotFoundException;
import ar.com.fravega.fravegaChallenge.interfaces.BranchInterface;
import ar.com.fravega.fravegaChallenge.request.BranchRequest;

@RestController
public class BranchController {

	@Autowired
	private BranchInterface branchService;

	@PostMapping("/")
	public ResponseEntity<String> addBranch(@Valid @RequestBody BranchRequest branch) throws BadRequestException {
		branchService.addBranch(branch);

		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	@PutMapping("/")
	public ResponseEntity<String> updateBranch(@Valid @RequestParam(required = true) @PathParam(value = "id") Long id,
			@Valid @RequestBody BranchRequest branch) throws BadRequestException, BranchNotFoundException {
		branchService.updateBranch(id, branch);

		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@DeleteMapping("/")
	public ResponseEntity<String> deleteBranch(@Valid @RequestParam(required = true) @PathParam(value = "id") Long id)
			throws BranchNotFoundException {
		branchService.deleteBranch(id);

		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<String> dateParseEx(BadRequestException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

	@ExceptionHandler(BranchNotFoundException.class)
	public ResponseEntity<String> notFoundBranch() {
		return ResponseEntity.notFound().build();
	}
}