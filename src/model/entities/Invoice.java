package model.entities;

public class Invoice {
	
	private Double basicPaiment;
	private Double tax;
	
	public Invoice() {
	}
	
	public Invoice(Double basicPaiment, Double tax) {
		this.basicPaiment = basicPaiment;
		this.tax = tax;
	}

	public Double getBasicPaiment() {
		return basicPaiment;
	}

	public void setBasicPaiment(Double basicPaiment) {
		this.basicPaiment = basicPaiment;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}
	
	public Double getTotalPayment() {
		return getBasicPaiment() + getTax();
	}
	
}
