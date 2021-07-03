package model;

public class frigeDTO {
	
	private String product_num;
	private String product_madeBy;
	private String product_name;
	private String product_capacity;
	private String product_type;
	private String cooling_method;
	private String energy_rank;
	private String counsum_E;
	private String product_price;
	
	public frigeDTO(String product_num, String product_madeBy, String product_name, String product_type,
			String product_capacity,  String cooling_method, String energy_rank, String counsum_E, String product_price ) {
		this.product_num = product_num;
		this.product_madeBy = product_madeBy;
		this.product_name = product_name;
		this.product_type = product_type;
		this.product_capacity = product_capacity;
		this.cooling_method = cooling_method;
		this.energy_rank = energy_rank;
		this.counsum_E = counsum_E;
		this.product_price = product_price;
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

	public String getProduct_capacity() {
		return product_capacity;
	}

	public void setProduct_capacity(String product_capacity) {
		this.product_capacity = product_capacity;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public String getCooling_method() {
		return cooling_method;
	}

	public void setCooling_method(String cooling_method) {
		this.cooling_method = cooling_method;
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

	
}
