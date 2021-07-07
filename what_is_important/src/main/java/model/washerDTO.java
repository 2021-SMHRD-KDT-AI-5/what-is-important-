package model;

public class washerDTO {
	private String product_num;
	private String product_madeBy;
	private String product_name;
	private String energy_rank;
	private String counsum_E;
	private String product_price;
	private String product_type;
	private String product_year;
	private String product_capacity;
		
	public washerDTO(String product_num, String product_madeBy, String product_name, 
			String energy_rank, String counsum_E, String product_price,
			String product_type, String product_year,  String product_capacity) {
		this.product_num = product_num;
		this.product_madeBy = product_madeBy;
		this.product_name = product_name;
		this.energy_rank = energy_rank;
		this.counsum_E = counsum_E;
		this.product_price = product_price;
		this.product_type = product_type;
		this.product_year = product_year;
		this.product_capacity = product_capacity;

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



	public String getproduct_type() {
		return product_type;
	}



	public void setproduct_type(String product_type) {
		this.product_type = product_type;
	}



	public String getproduct_year() {
		return product_year;
	}



	public void setproduct_year(String product_year) {
		this.product_year = product_year;
	}



	public String getproduct_capacity() {
		return product_capacity;
	}



	public void setproduct_capacity(String product_capacity) {
		this.product_capacity = product_capacity;
	}
	
}
