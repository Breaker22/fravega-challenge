package ar.com.fravega.fravegaChallenge.utils;

import java.text.ParseException;
import java.util.Objects;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;

import ar.com.fravega.fravegaChallenge.entity.Branch;
import ar.com.fravega.fravegaChallenge.entity.PickupPoint;
import ar.com.fravega.fravegaChallenge.exception.BadRequestException;
import ar.com.fravega.fravegaChallenge.request.BranchRequest;
import ar.com.fravega.fravegaChallenge.request.PickupPointRequest;

public class ValidateRequestUtils {

	private ValidateRequestUtils() {

	}

	public static void validateBranchRequest(BranchRequest request) throws BadRequestException {
		if (Strings.isEmpty(request.getAddress())) {
			throw new BadRequestException("El campo address es obligatorio!");
		}

		if (Strings.isEmpty(request.getDateAttention())) {
			throw new BadRequestException("El campo dateAttention es obligatorio!");
		}

		if (Strings.isEmpty(request.getLatitude())) {
			throw new BadRequestException("El campo latitude es obligatorio!");
		}

		if (Strings.isEmpty(request.getLongitude())) {
			throw new BadRequestException("El campo longitude es obligatorio!");
		}
	}

	public static void validatePickupPointRequest(PickupPointRequest request) throws BadRequestException {

		if (Objects.isNull(request.getCapacity())) {
			throw new BadRequestException("El campo capacity es obligatorio!");
		}

		if (Strings.isEmpty(request.getLatitude())) {
			throw new BadRequestException("El campo latitude es obligatorio!");
		}

		if (Strings.isEmpty(request.getLongitude())) {
			throw new BadRequestException("El campo longitude es obligatorio!");
		}
	}

	public static Branch validateUpdateBranch(Logger logger, Long id, BranchRequest request, Branch oldBranch)
			throws BadRequestException {
		Branch branch = new Branch();

		branch.setId(id);
		branch.setAddress(oldBranch.getAddress());
		branch.setDateAttention(oldBranch.getDateAttention());
		branch.setLatitude(oldBranch.getLatitude());
		branch.setLongitude(oldBranch.getLongitude());

		if (!Strings.isEmpty(request.getAddress())) {
			branch.setAddress(request.getAddress());
		}

		if (!Strings.isEmpty(request.getDateAttention())) {
			try {
				branch.setDateAttention(DateUtils.getParsedDate(request.getDateAttention()));
			} catch (ParseException ex) {
				LogsUtils.error(logger, ex.getMessage());
				throw new BadRequestException("El campo dateAttention debe tener el formato yyyy-MM-dd.");
			}
		}

		if (!Strings.isEmpty(request.getLatitude())) {
			branch.setLatitude(request.getLatitude());
		}

		if (!Strings.isEmpty(request.getLongitude())) {
			branch.setLongitude(request.getLongitude());
		}

		return branch;
	}

	public static PickupPoint validateUpdatePickup(Long id, PickupPointRequest request, PickupPoint oldPickup) {
		PickupPoint pickupPoint = new PickupPoint();

		pickupPoint.setId(id);
		pickupPoint.setCapacity(oldPickup.getCapacity());
		pickupPoint.setLatitude(oldPickup.getLatitude());
		pickupPoint.setLongitude(oldPickup.getLongitude());

		if (Objects.nonNull(request.getCapacity())) {
			pickupPoint.setCapacity(request.getCapacity());
		}

		if (!Strings.isEmpty(request.getLatitude())) {
			pickupPoint.setLatitude(request.getLatitude());
		}

		if (!Strings.isEmpty(request.getLongitude())) {
			pickupPoint.setLongitude(request.getLongitude());
		}

		return pickupPoint;
	}
}