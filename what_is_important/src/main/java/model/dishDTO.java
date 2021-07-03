package model;

public class dishDTO {
	private String product_num;
	private String product_madeBy;
	private String product_name;
	private String energy_rank;
	private String counsum_E;
	private String product_price;
	private String water_pressure;
	private String product_capacity;
	private String drying_method;
		
	public dishDTO(String product_num, String product_madeBy, String product_name, 
			String energy_rank, String counsum_E, String product_price,
			String water_pressure, String product_capacity,  String drying_method) {
		this.product_num = product_num;
		this.product_madeBy = product_madeBy;
		this.product_name = product_name;
		this.energy_rank = energy_rank;
		this.counsum_E = counsum_E;
		this.product_price = product_price;
		this.water_pressure = water_pressure;
		this.product_capacity = product_capacity;
		this.drying_method = drying_method;

	}

	public String getProduct_num() {
		return product_num;
	}



	public void setProduct_num(String product_num) {
		this.product_num = product_num;
	}



	public String getProduct_madeBy() {
		return product_madeBy;
	}



	public void setProduct_madeBy(String product_madeBy) {
		this.product_madeBy = product_madeBy;
	}



	public String getProduct_name() {
		return product_name;
	}



	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}



	public String getEnergy_rank() {
		return energy_rank;
	}



	public void setEnergy_rank(String energy_rank) {
		this.energy_rank = energy_rank;
	}



	public String getCounsum_E() {
		return counsum_E;
	}



	public void setCounsum_E(String counsum_E) {
		this.counsum_E = counsum_E;
	}



	public String getProduct_price() {
		return product_price;
	}



	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}



	public String getWater_pressure() {
		return water_pressure;
	}



	public void setWater_pressure(String water_pressure) {
		this.water_pressure = water_pressure;
	}



	public String getProduct_capacity() {
		return product_capacity;
	}



	public void setProduct_capacity(String product_capacity) {
		this.product_capacity = product_capacity;
	}



	public String getDrying_method() {
		return drying_method;
	}



	public void setDrying_method(String drying_method) {
		this.drying_method = drying_method;
	}
	
}
