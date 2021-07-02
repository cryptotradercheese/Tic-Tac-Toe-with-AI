abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}

class Triangle extends Shape {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getPerimeter() {
        return this.a + this.b + this.c;
    }

    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.pow(p * (p - a) * (p - b) * (p - c), 0.5);
    }
}

class Rectangle extends Shape {
    private double a;
    public double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getPerimeter() {
        return (a + b) * 2;
    }

    public double getArea() {
        return a * b;
    }
}

class Circle extends Shape {
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    public double getPerimeter() {
        return 2 * Math.PI * r;
    }

    public double getArea() {
        return Math.PI * r * r;
    }
}