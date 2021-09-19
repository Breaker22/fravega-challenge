package ar.com.fravega.fravegaChallenge.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "branch")
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "date_attention", nullable = false)
	private Date dateAttention;

	@Column(name = "latitude", nullable = false)
	private String latitude;

	@Column(name = "longitude", nullable = false)
	private String longitude;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateAttention() {
		return dateAttention;
	}

	public void setDateAttention(Date dateAttention) {
		this.dateAttention = dateAttention;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}
