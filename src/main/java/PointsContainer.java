import utils.RPair;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean(name = "pointsContainer", eager = true)
@SessionScoped
public class PointsContainer implements Serializable {
    @ManagedProperty(value = "#{oracleReader}")
    private OracleReader oracleReader;

    @ManagedProperty(value = "#{oracleWriter}")
    private OracleWriter oracleWriter;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

    private PointBeanShell pointBean = new PointBeanShell();

    private CanvasPointBeanShell canvasPointBean = new CanvasPointBeanShell();

    private ArrayList<Point> pointsList;

    @PostConstruct
    public void init(){
        this.pointsList = oracleReader.readPoints();
    }

    public PointsContainer(){

    }

    public void addPoint(){
        long enterTime = System.nanoTime();
        if (pointsList == null){
            pointsList = oracleReader.readPoints();
        }
        RPair pair1 = new RPair(pointBean.getrVal1(), pointBean.isrState1());
        RPair pair2 = new RPair(pointBean.getrVal2(), pointBean.isrState2());
        RPair pair3 = new RPair(pointBean.getrVal3(), pointBean.isrState3());
        RPair pair4 = new RPair(pointBean.getrVal4(), pointBean.isrState4());
        RPair pair5 = new RPair(pointBean.getrVal5(), pointBean.isrState5());
        List<RPair> pairList = Arrays.asList(pair1, pair2, pair3, pair4, pair5);
        for(RPair pair: pairList){
            if(pair.isState()){
                Point newPoint = new Point(
                        pointBean.getX(),
                        pointBean.getY(),
                        pair.getValue(),
                        LocalDateTime.now(),
                        (System.nanoTime() - enterTime) / 1000000.0);
                pointsList.add(newPoint);
                oracleWriter.write(newPoint);
            }
        }
        pointBean = new PointBeanShell();
    }

    public void canvasAddPoint(){
        long enterTime = System.nanoTime();
        System.out.println(canvasPointBean.getCanvasX());
        System.out.println(canvasPointBean.getCanvasY());
        System.out.println(canvasPointBean.getCanvasR());
        if (pointsList == null){
            pointsList = oracleReader.readPoints();
        }
        Point newPoint = new Point(
                canvasPointBean.getCanvasX(),
                canvasPointBean.getCanvasY(),
                canvasPointBean.getCanvasR(),
                LocalDateTime.now(),
                (System.nanoTime() - enterTime) / 1000000.0);
        pointsList.add(newPoint);
        oracleWriter.write(newPoint);
    }

    public void clearTable(){
        if(oracleWriter.clearTable()) this.pointsList = new ArrayList<>();
    }

    public void setPointsList(ArrayList<Point> pointsList) {
        this.pointsList = pointsList;
    }

    public ArrayList<Point> getPointsList() {
        return pointsList;
    }

    public PointBeanShell getPointBean() {
        return pointBean;
    }

    public CanvasPointBeanShell getCanvasPointBean() {
        return canvasPointBean;
    }

    public OracleReader getOracleReader() {
        return oracleReader;
    }

    public OracleWriter getOracleWriter() {
        return oracleWriter;
    }

    public void setPointBean(PointBeanShell pointBean) {
        this.pointBean = pointBean;
    }

    public void setCanvasPointBean(CanvasPointBeanShell canvasPointBean) {
        this.canvasPointBean = canvasPointBean;
    }

    public void setOracleReader(OracleReader oracleReader) {
        this.oracleReader = oracleReader;
    }

    public void setOracleWriter(OracleWriter oracleWriter) {
        this.oracleWriter = oracleWriter;
    }

    public void setFormatter(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }
}
