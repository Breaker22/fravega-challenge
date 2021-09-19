package ar.com.fravega.fravegaChallenge.response;

import ar.com.fravega.fravegaChallenge.entity.Node;
import io.swagger.annotations.ApiModelProperty;

public class NodeResponse {
	
	@ApiModelProperty(value = "Sucursal", name = "branch", required = true)
	private BranchResponse branch;
	
	public NodeResponse() {
		
	}
 
	public NodeResponse(Node node) {
		this.branch = new BranchResponse(node);
	}

	public BranchResponse getBranch() {
		return branch;
	}

	public void setBranch(BranchResponse branch) {
		this.branch = branch;
	}

}