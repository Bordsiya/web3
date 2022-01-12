import java.io.Serializable;

public class PointBeanShell implements Serializable {
    private double x;
    private double y;
    private double rVal1 = 1, rVal2 = 1.5, rVal3 = 2, rVal4 = 2.5, rVal5 = 3;
    private boolean rState1, rState2, rState3, rState4, rState5;

    public PointBeanShell(){

    }

    public double getX() {
        return x;
    }

    public double getrVal1() {
        return rVal1;
    }

    public double getrVal2() {
        return rVal2;
    }

    public double getrVal3() {
        return rVal3;
    }

    public double getrVal4() {
        return rVal4;
    }

    public double getrVal5() {
        return rVal5;
    }

    public boolean isrState1() {
        return rState1;
    }

    public boolean isrState2() {
        return rState2;
    }

    public boolean isrState3() {
        return rState3;
    }

    public boolean isrState4() {
        return rState4;
    }

    public boolean isrState5() {
        return rState5;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setrVal1(double rVal1) {
        this.rVal1 = rVal1;
    }

    public void setrVal2(double rVal2) {
        this.rVal2 = rVal2;
    }

    public void setrVal3(double rVal3) {
        this.rVal3 = rVal3;
    }

    public void setrVal4(double rVal4) {
        this.rVal4 = rVal4;
    }

    public void setrVal5(double rVal5) {
        this.rVal5 = rVal5;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setrState1(boolean rState1) {
        this.rState1 = rState1;
    }

    public void setrState2(boolean rState2) {
        this.rState2 = rState2;
    }

    public void setrState3(boolean rState3) {
        this.rState3 = rState3;
    }

    public void setrState4(boolean rState4) {
        this.rState4 = rState4;
    }

    public void setrState5(boolean rState5) {
        this.rState5 = rState5;
    }
}
