package src.util;

import java.io.Serializable;

public class Dimension2D implements Serializable {

    private static final long serialVersionUID = 7202662117698119284L;
    private double w;
    private double h;

    public Dimension2D(double size) {
        this.w = size;
        this.h = size;
    }

    public Dimension2D(double w, double h) {
        this.w = w;
        this.h = h;
    }

    public Dimension2D() {
        this.w = 0;
        this.h = 0;
    }

    public double getWidth() {
        return w;
    }

    public double getHeight() {
        return h;
    }

    public void setWidth(double w) {
        this.w = w;
    }

    public void setHeight(double h) {
        this.h = h;
    }

    @Override
    public String toString() {
        return "[ w:" + this.w + ", h:" + this.h + " ]";
    }

}
