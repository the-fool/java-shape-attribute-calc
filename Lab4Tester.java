package lab4;

import java.util.Arrays;

abstract class Shape {
	public abstract double getArea();
	public abstract String getDescription();
}

abstract class TwoDimensionalShape extends Shape {
	
	@Override
	public String getDescription() {
		return "Two-Dimensional Shape";
	}
}

abstract class ThreeDimensionalShape extends Shape {
	public abstract double getVolume();
	
	@Override
	public String getDescription() {
		return "Three-Dimensional Shape";
	}
}

class Circle extends TwoDimensionalShape {
	private static final double DEFAULT_RADIUS = 1;
	private final double radius;
	
	public Circle() {
		this(DEFAULT_RADIUS);
	}
	public Circle(double r) {
		radius = r;
	}
	@Override
	public String getDescription() {
		
	}
	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}	
}

class Triangle extends TwoDimensionalShape {
	private static final double DEFAULT_SIDE = 1;
	private double sideA, sideB, sideC;
	
	Triangle() {
		this(DEFAULT_SIDE, DEFAULT_SIDE, DEFAULT_SIDE);
	}
	Triangle (double a, double b, double c) {
		double [] ar = {a, b, c};
		Arrays.sort(ar);
		sideA = ar[2]; sideB = ar[1]; sideC = ar[0];
		try {
			if (a > (b + c)) {
				throw new IllegalArgumentException("Invalid side length - setting to default");
			}
		} catch (IllegalArgumentException e) {
			sideA = sideB = sideC = 1;
		}
	}
	
	@Override
	public double getArea() {
		return sideA * sideB * Math.cos(sideC) / 2;
	}
	
	@Override
	public String getDescription() {
		return (super.getDescription() + ": Triangle: sides (" 
	        + sideA + ", " + sideB + ", " + sideC + 
	        ") - Area: " + getArea());
	}
}


public class Lab4Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
