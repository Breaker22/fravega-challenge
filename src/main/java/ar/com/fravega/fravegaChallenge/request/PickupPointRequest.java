package ar.com.fravega.fravegaChallenge.request;

import io.swagger.annotations.ApiModelProperty;

public class PickupPointRequest {
	
	@ApiModelProperty(value = "Capacidad", name = "capacity", required = true, example = "10")
	private Integer capacity;

	@ApiModelProperty(value = "Latitud", name = "latitude", required = true, example = "-34.6201463")
	private String latitude;

	@ApiModelProperty(value = "Longitud", name = "longitude", required = true, example = "-58.4423909,17")
	private String longitude;

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
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