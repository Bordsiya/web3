package utils;

public class RPair {
    private double value;
    private boolean state;

    public RPair(double value, boolean state){
        this.value = value;
        this.state = state;
    }

    public double getValue() {
        return value;
    }

    public boolean isState() {
        return state;
    }
}
