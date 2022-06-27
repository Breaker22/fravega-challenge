package ar.com.fravega.fravegaChallenge.interfaces;

import ar.com.fravega.fravegaChallenge.exception.BadRequestException;
import ar.com.fravega.fravegaChallenge.exception.BranchNotFoundException;
import ar.com.fravega.fravegaChallenge.request.BranchRequest;
import ar.com.fravega.fravegaChallenge.response.BranchResponse;

public interface BranchInterface {

	BranchResponse addBranch(BranchRequest branch) throws BadRequestException;

	void updateBranch(Long id, BranchRequest branch) throws BadRequestException, BranchNotFoundException;

	void deleteBranch(Long id) throws BranchNotFoundException;
}
