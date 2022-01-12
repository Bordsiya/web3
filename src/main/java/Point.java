import java.time.LocalDateTime;

public class Point {
    private double x;
    private double y;
    private double r;
    private LocalDateTime creationDate;
    private double workingTime;

    public Point(){

    }

    public Point(double x, double y, double r, LocalDateTime creationDate,
                 double workingTime)
    {
        this.x = x;
        this.y = y;
        this.r = r;
        this.creationDate = creationDate;
        this.workingTime = workingTime;
    }

    public boolean getHit(){
        return (x <= 0 && x >= -r && y >= 0 && y <= r) ||
                //triangle
                (x >= 0 && x <= r && y >= 0 && y <= -x/2 + r/2) ||
                //circle
                (x <= 0 && x >= -r/2 && y <= 0 && x * x + y * y <= (r/2) * (r/2));
    }

    public double getWorkingTime() {
        return workingTime;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public void setWorkingTime(double workingTime) {
        this.workingTime = workingTime;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setR(double r) {
        this.r = r;
    }
}
