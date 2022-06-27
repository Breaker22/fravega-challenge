package ar.com.fravega.fravegaChallenge.response;

public class BranchResponse {

	public Long nodeId;

	public Long branchId;

	public BranchResponse() {
	}

	public BranchResponse(Long nodeId, Long branchId) {
		this.nodeId = nodeId;
		this.branchId = branchId;
	}

	public Long getNodeId() {
		return nodeId;
	}

	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}
}
