package ru.stqa.pft.sandbox;

class A
{
	public static void main(String arg[]) {
		hello("Misha");

		Square s = new Square(8);
		System.out.println("Площать квадрата со стороной: " + s.l + " = " + s.area());

		Rectangle f = new Rectangle(5,4);
		System.out.println("Площать прямоугольника со сторонами: " + f.a + " и " + f.b + " = " + f.area());

		System.out.println("ДЗ");
		Point y = new Point(8,-1,4,2);
		System.out.println("Расстояние от точки: " + y.x1 +"/"+ y.y1 + " до точки: " + y.x2 + "/" + y.y2 + " = " + y.distance());
	}
	public static void hello(String somebody) {

		System.out.println("Hello " + somebody);
	}




}