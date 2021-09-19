package ar.com.fravega.fravegaChallenge.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "node")
public class Node {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	@JoinColumn(name = "branch_id", referencedColumnName = "id")
	private Branch branch;

	@OneToOne
	@JoinColumn(name = "pickup_id", referencedColumnName = "id")
	private PickupPoint pickupPoint;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public PickupPoint getPickupPoint() {
		return pickupPoint;
	}

	public void setPickupPoint(PickupPoint pickupPoint) {
		this.pickupPoint = pickupPoint;
	}
}
