package ru.stqa.pft.sandbox;

public class Point {
  int x1;
  int y1;

  int x2;
  int y2;

  public Point(int x1, int y1, int x2, int y2) {
    // First dot
    this.x1 = x1;
    this.y1 = y1;
    // Second dot
    this.x2 = x2;
    this.y2 = y2;
  }
  // Ф-я вычисления расстояния двух точек на плоскости  корень( (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1) )
  public double distance() {
    return Math.sqrt((x2 - x1) * (x2-x1) + (y2-y1) * (y2-y1));
  }
}

