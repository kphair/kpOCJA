package com.kevinphair.ocja.exercises.passingparameters;

/**
 * An application to demonstrate passing by reference
 * 
 * @author Kevin Phair
 * @date 21 Jul 2015
 */
public class ByReferenceApp {

	public static void main(String[] args) {

			ByReferenceApp va = new ByReferenceApp();
			Car myCar = new Car();
			System.out.println(myCar.getModel());
			va.changeCar(myCar);
			System.out.println(myCar.getModel());
	}

	private void changeCar (Car car) {
		car.setModel("Veyron");
	}
}
