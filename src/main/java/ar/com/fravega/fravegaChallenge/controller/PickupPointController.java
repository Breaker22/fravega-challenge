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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.fravega.fravegaChallenge.exception.BadRequestException;
import ar.com.fravega.fravegaChallenge.exception.PickupPointNotFoundException;
import ar.com.fravega.fravegaChallenge.interfaces.PickupPointInterface;
import ar.com.fravega.fravegaChallenge.request.PickupPointRequest;
import ar.com.fravega.fravegaChallenge.utils.ValidateRequestUtils;

@RestController
@RequestMapping("/pickupPoint")
public class PickupPointController {

	@Autowired
	private PickupPointInterface pickupPointService;

	@PostMapping
	public ResponseEntity<String> addPickupPoint(@Valid @RequestBody PickupPointRequest pickupPoint)
			throws BadRequestException {
		ValidateRequestUtils.validatePickupPointRequest(pickupPoint);

		Long id = pickupPointService.addPickupPoint(pickupPoint);

		StringBuilder idPickup = new StringBuilder("El id creado es: ").append(Long.toString(id));

		return new ResponseEntity<String>(idPickup.toString(), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<String> updatePickupPoint(
			@Valid @RequestParam(required = true) @PathParam(value = "id") Long id,
			@Valid @RequestBody PickupPointRequest pickupPoint)
			throws BadRequestException, PickupPointNotFoundException {
		pickupPointService.updatePickupPoint(id, pickupPoint);

		return ResponseEntity.ok().build();
	}

	@DeleteMapping
	public ResponseEntity<String> deletePickupPoint(
			@Valid @RequestParam(required = true) @PathParam(value = "id") Long id)
			throws PickupPointNotFoundException {

		pickupPointService.deletePickupPoint(id);

		return ResponseEntity.ok().build();
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<String> badRequest(BadRequestException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

	@ExceptionHandler(PickupPointNotFoundException.class)
	public ResponseEntity<String> notFound() {
		return ResponseEntity.notFound().build();
	}

}
