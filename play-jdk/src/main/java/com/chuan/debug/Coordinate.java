package com.chuan.debug;

import lombok.Data;

/**
 * @author xucy-e
 */
@Data
public class Coordinate {
    private Double cordX;
    private Double cordY;

    @Override
    public boolean equals(Object o) {
        System.out.println("equals");
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        System.out.println("hashCode");
        return super.hashCode();
    }

    @Override
    public String toString() {
        System.out.println("toString");
        return "Coordinate{" +
                "cordX=" + cordX +
                ", cordY=" + cordY +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("clone");
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
        super.finalize();
    }
}
