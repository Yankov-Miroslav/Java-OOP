package PointInRectangle;

public class Rectangle {
    private final Point pointA;
    private final Point pointC;

    public Rectangle(Point pointA, Point pointC) {

        this.pointA = pointA;
        this.pointC = pointC;
    }

    public boolean isInside(Point p) {
        return p.isGreaterOrEqualThan(pointA) &&
                p.isLessThanOrEqual(pointC);

    }
}
