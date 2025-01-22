package org.example;

public class SortedLine extends Line{
    private String type;

    public SortedLine(Line line, String type) {
        super(line.getP1(), line.getP2());
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

}
