package edu.kh.poly.ex1.model.vo;

public class Spark extends Car{ // 경차
	
	private double discountoffer; // 할인혜택
	
	public Spark() {}

	public Spark(String engine, String fuel, int wheel, double discountoffer) {
		super(engine, fuel, wheel);
		this.discountoffer = discountoffer;
	}

	public double getDiscountoffer() {
		return discountoffer;
	}

	public void setDiscountoffer(double discountoffer) {
		this.discountoffer = discountoffer;
	}
	
	@Override
	public String toString() {
		return super.toString() + " / " + discountoffer;
	}
}
