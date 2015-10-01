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
		radius = Math.abs(r);
	}
	@Override
	public String getDescription() {
		return (super.getDescription() + ": Circle: radius (" + radius + ") - Area: " + getArea());
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
		double [] ar = {Math.abs(a), Math.abs(b), Math.abs(c)};
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

class Square extends TwoDimensionalShape {
	private static final double DEFAULT_SIDE = 1;
	private final double side;
	
	Square() {
		this(DEFAULT_SIDE);
	}
	Square(double s) {
		side = Math.abs(s);
	}
	@Override
	public String getDescription() {
		return (super.getDescription() + ": Square: side (" + side + ") - area: " + getArea());
	}
	@Override
	public double getArea() {
		return side * side;
	}
}

class Sphere extends ThreeDimensionalShape {
	private static final double DEFAULT_RADIUS = 1;
	private final double radius;
	
	Sphere() {
		this(DEFAULT_RADIUS);
	}
	Sphere(double r) {
		radius = Math.abs(r);
	}
	
	@Override
	public double getVolume() {
		return 4 * Math.PI * Math.pow(radius, 3) / 3;
	}

	@Override
	public double getArea() {
		return 4 * Math.PI * radius * radius;
	}
	
	@Override
	public String getDescription() {
		return (super.getDescription() + ": Sphere : radius (" + radius + 
				") - surface: " + getArea() + ", volume: " + getVolume());
	}
}

class Cube extends ThreeDimensionalShape {
	private static final double DEFAULT_SIDE = 1;
	private final double side;
	
	Cube() {
		this(DEFAULT_SIDE);
	}
	Cube(double s) {
		side = Math.abs(s);
	}
	@Override
	public double getVolume() {
		return Math.pow(side, 3);
	}

	@Override
	public double getArea() {
		return 6 * side * side;
	}
	
}

public class ShapeTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
