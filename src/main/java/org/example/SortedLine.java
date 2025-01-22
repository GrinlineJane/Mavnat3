// אור גלבוע 324188754
// ורברה גריניוב 338055866

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
