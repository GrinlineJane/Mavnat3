// אור גלבוע 324188754
// ורברה גריניוב 338055866

package org.example;

public class Line {
    private Point p1;
    private Point p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP1() {
        return p1;
    }

    @Override
    public String toString() {
        return "Line{" +
                "p1=" + p1.toString() +
                ", p2=" + p2.toString() +
                '}';
    }
}
