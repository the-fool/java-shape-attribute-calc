package lab4;

import java.util.Arrays;

abstract class Shape {
	public abstract double getArea();
	public abstract String getDescription(String type);
	public abstract String getDescription();
}

abstract class TwoDimensionalShape extends Shape {
	
	@Override
	public String getDescription(String type) {
		return "Two-Dimensional Shape: " + type + ": area: " + getArea();
	}
}

abstract class ThreeDimensionalShape extends Shape {
	public abstract double getVolume();
	
	@Override
	public String getDescription(String type) {
		return "Three-Dimensional Shape: " + type + ": area: " + getArea() + ", volume " + getVolume();	
		}
	
}

class Circle extends TwoDimensionalShape {
	private static final double DEFAULT_RADIUS = 1;
	private final double radius;
	
	public Circle() {
		this(DEFAULT_RADIUS);
	}
	public Circle(double r) {
		try {
			if (r <= 0) {
				throw new IllegalArgumentException("Invalid argument - setting to default");
			}
		} catch (IllegalArgumentException e) {
			r = DEFAULT_RADIUS;
		}
		radius = r;
	}
	
	public String getDescription() {
		return (super.getDescription("Circle: radius (" + radius + ")"));
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
				throw new IllegalArgumentException("Invalid argument - setting to default");
			}
		} catch (IllegalArgumentException e) {
			sideA = sideB = sideC = 1;
		}
	}
	
	@Override
	public double getArea() {
		return sideA * sideB * Math.cos(sideC) / 2;
	}
	
	public String getDescription() {
		return (super.getDescription("Triangle: sides (" 
		        + sideA + ", " + sideB + ", " + sideC + 
		        ")"));
	}
}

class Square extends TwoDimensionalShape {
	private static final double DEFAULT_SIDE = 1;
	private final double side;
	
	Square() {
		this(DEFAULT_SIDE);
	}
	Square(double s) {
		try {
			if (s <= 0) {
				throw new IllegalArgumentException("Invalid argument - setting to default");
			}
		} catch (IllegalArgumentException e) {
			s = DEFAULT_SIDE;
		}
		side = s;
	}
	
	public String getDescription() {
		return super.getDescription("Square: side (" + side + ")"); 
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
		try {
			if (r <= 0) {
				throw new IllegalArgumentException("Invalid argument - setting to default");
			}
		} catch (IllegalArgumentException e) {
			r = DEFAULT_RADIUS;
		}
		radius = r;
	}
	
	@Override
	public double getVolume() {
		return 4 * Math.PI * Math.pow(radius, 3) / 3;
	}

	@Override
	public double getArea() {
		return 4 * Math.PI * radius * radius;
	}

	public String getDescription() {
		return super.getDescription("Sphere : radius (" + radius + 
				")");
	}
}

class Cube extends ThreeDimensionalShape {
	private static final double DEFAULT_SIDE = 1;
	private final double side;
	
	Cube() {
		this(DEFAULT_SIDE);
	}
	Cube(double s) {
		try {
			if (s <= 0) {
				throw new IllegalArgumentException("Invalid argument - setting to default");
			}
		} catch (IllegalArgumentException e) {
			s = DEFAULT_SIDE;
		}
		side = s;
	}
	@Override
	public double getVolume() {
		return Math.pow(side, 3);
	}

	@Override
	public double getArea() {
		return 6 * side * side;
	}

	public String getDescription() {
		return super.getDescription("Cube: side (" + side + ")");
	}
}

class RegularTetrahedron extends ThreeDimensionalShape {
	private static final double DEFAULT_SIDE = 1;
	private final double side;
	
	RegularTetrahedron() {
		this(DEFAULT_SIDE);
	}
	RegularTetrahedron(double s) {
		try {
			if (s <= 0) {
				throw new IllegalArgumentException("Invalid argument - setting to default");
			}
		} catch (IllegalArgumentException e) {
			s = DEFAULT_SIDE;
		}
		side = s;
	}
	
	@Override
	public double getVolume() {
		return Math.pow(side, 3) / (6 * Math.pow(2, .5));
	}
	
	@Override
	public double getArea() {
		return Math.pow(3, .5) * side * side;
	}
	
	public String getDescription() {
		return super.getDescription("Regular Tetrahedron: side (" + side + ")");
	}
	
}

public class ShapeTester {

	public static void main(String[] args) {
		Shape [] array = new Shape[6];
		array[0] = new Circle(4.1);
		array[1] = new Square(3.1);
		array[2] = new Triangle(3,3,3);
		array[3] = new Sphere(10);
		array[4] = new Cube(9);
		array[5] = new RegularTetrahedron(13);

		for (Shape a : array) {
			System.out.println(a.getDescription());
		}

	}

}
