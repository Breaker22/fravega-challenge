package ar.com.fravega.fravegaChallenge.request;

import io.swagger.annotations.ApiModelProperty;

public class BranchRequest {

	@ApiModelProperty(value = "Direccion", name = "address", required = true, example = "Av. Rivadavia 5216")
	private String address;

	@ApiModelProperty(value = "Fecha atencion", name = "dateAttention", required = true, example = "2021-09-05")
	private String dateAttention;

	@ApiModelProperty(value = "Latitud", name = "latitude", required = true, example = "-34.6201463")
	private String latitude;

	@ApiModelProperty(value = "Longitud", name = "longitude", required = true, example = "-58.4423909,17")
	private String longitude;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateAttention() {
		return dateAttention;
	}

	public void setDateAttention(String dateAttention) {
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