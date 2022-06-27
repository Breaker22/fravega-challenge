package ar.com.fravega.fravegaChallenge.response;

import ar.com.fravega.fravegaChallenge.entity.Node;
import io.swagger.annotations.ApiModelProperty;

public class NodeResponse {

	@ApiModelProperty(value = "Sucursal", name = "branch", required = true)
	private BranchNodeResponse branch;

	@ApiModelProperty(value = "Punto de retiro", name = "pickupPoint", required = true)
	private PickupPointResponse pickupPoint;

	public NodeResponse() {

	}

	public NodeResponse(Node node) {
		if (node.getBranch() != null) {
			this.branch = new BranchNodeResponse(node);
		}

		if (node.getPickupPoint() != null) {
			this.pickupPoint = new PickupPointResponse(node);
		}
	}

	public BranchNodeResponse getBranch() {
		return branch;
	}

	public void setBranch(BranchNodeResponse branch) {
		this.branch = branch;
	}

	public PickupPointResponse getPickupPoint() {
		return pickupPoint;
	}

	public void setPickupPoint(PickupPointResponse pickupPoint) {
		this.pickupPoint = pickupPoint;
	}
}