abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}
class Triangle extends Shape {
    double s1, s2, s3;

    Triangle(double side1, double side2, double side3) {
        s1 = side1;
        s2 = side2;
        s3 = side3;
    }

    @Override
    double getPerimeter() {
        return s1 + s2 + s3;
    }

    @Override
    double getArea() {
        return Math.sqrt((s1 + s2 + s3) * (s1 + s2 - s3) * (s1 - s2 + s3) * (s2 - s1 + s3) / 16);
    }
}

class Circle extends Shape {
    double r;

    Circle(double rad) {
        r = rad;
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * r;
    }

    @Override
    double getArea() {
        return Math.PI * r * r;
    }
}

class Rectangle extends Shape {
    double w, h;

    Rectangle(double width, double height) {
        w = width;
        h = height;
    }

    @Override
    double getPerimeter() {
        return w + w + h + h;
    }

    @Override
    double getArea() {
        return w * h;
    }
}