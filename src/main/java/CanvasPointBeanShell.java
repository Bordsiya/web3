import java.io.Serializable;

public class CanvasPointBeanShell implements Serializable {
    private double canvasX;
    private double canvasY;
    private double canvasR;

    public CanvasPointBeanShell(){

    }

    public double getCanvasX() {
        return canvasX;
    }

    public double getCanvasY() {
        return canvasY;
    }

    public double getCanvasR() {
        return canvasR;
    }

    public void setCanvasX(double canvasX) {
        this.canvasX = canvasX;
    }

    public void setCanvasY(double canvasY) {
        this.canvasY = canvasY;
    }

    public void setCanvasR(double canvasR) {
        this.canvasR = canvasR;
    }
}
