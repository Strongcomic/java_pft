package ru.stqa.pft.sandbox;

class A
{
	public static void main(String arg[]) {
		hello("Misha");
		double l = 8;
		System.out.println("Площать квадрата со стороной: " + l + " = " + area(l));
		double a = 5;
		double b = 4;
		System.out.println("Площать прямоугольника со сторонами: " + a + " и " + b + " = " + area(a,b));
	}
	public static void hello(String somebody) {

		System.out.println("Hello " + somebody);
	}

	public static double area(double len) {
		return len * len;
	}

	public static double area(double a, double b) {
		return a * b;
	}
}