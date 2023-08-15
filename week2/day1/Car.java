package week2.day1;

public class Car {
	
	public void driveCar()
	{
		System.out.println("Drive car");
	}
	public void applyBrake()
	{
		System.out.println("Apply Brake");
	}
	public void soundHorn()
	{
		System.out.println("Sound Horn");
	}
	public boolean isPuncture(boolean a)

	{
		System.out.println(a);
		return a;
	}
	


	public static void main(String[] args) {
		
		Car objCar = new Car();
		
		objCar.driveCar();
		objCar.applyBrake();
		objCar.soundHorn();
		objCar.isPuncture(false);
	}

}

