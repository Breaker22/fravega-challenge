package ar.com.fravega.fravegaChallenge.service;

import java.text.ParseException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.fravega.fravegaChallenge.entity.Branch;
import ar.com.fravega.fravegaChallenge.entity.Node;
import ar.com.fravega.fravegaChallenge.exception.BadRequestException;
import ar.com.fravega.fravegaChallenge.exception.BranchNotFoundException;
import ar.com.fravega.fravegaChallenge.interfaces.BranchInterface;
import ar.com.fravega.fravegaChallenge.repository.BranchRepository;
import ar.com.fravega.fravegaChallenge.repository.NodeRepository;
import ar.com.fravega.fravegaChallenge.request.BranchRequest;
import ar.com.fravega.fravegaChallenge.utils.DateUtils;

@Service
public class BranchService implements BranchInterface {

	@Autowired
	private NodeRepository nodeRepo;

	@Autowired
	private BranchRepository branchRepo;

	@Override
	public Long addBranch(BranchRequest branch) throws BadRequestException {
		Branch newBranch = new Branch();
		Node node = new Node();

		newBranch.setAddress(branch.getAddress());

		try {
			newBranch.setDateAttention(DateUtils.getParsedDate(branch.getDateAttention()));
		} catch (ParseException ex) {
			throw new BadRequestException("El campo dateAttention debe tener el formato yyyy-MM-dd.");
		}

		newBranch.setLatitude(branch.getLatitude());
		newBranch.setLongitude(branch.getLongitude());

		node.setBranch(newBranch);

		branchRepo.save(newBranch);
		nodeRepo.save(node);

		return newBranch.getId() + 1L;
	}

	@Override
	public void updateBranch(Long id, BranchRequest branch) throws BadRequestException, BranchNotFoundException {
		Branch newBranch = new Branch();

		try {
			newBranch.setDateAttention(DateUtils.getParsedDate(branch.getDateAttention()));
		} catch (ParseException ex) {
			throw new BadRequestException("El campo dateAttention debe tener el formato yyyy-MM-dd.");
		}

		Optional<Branch> oldBranch = branchRepo.findById(id);

		if (!oldBranch.isPresent()) {
			throw new BranchNotFoundException("No existe la sucursal!");
		}

		newBranch.setId(id);
		newBranch.setAddress(branch.getAddress());
		newBranch.setLatitude(branch.getLatitude());
		newBranch.setLongitude(branch.getLongitude());

		branchRepo.save(newBranch);
	}

	@Override
	public void deleteBranch(Long id) throws BranchNotFoundException {
		Optional<Branch> branch = branchRepo.findById(id);

		if (!branch.isPresent()) {
			throw new BranchNotFoundException("No existe la sucursal!");
		}

		branchRepo.delete(branch.get());
	}

}
