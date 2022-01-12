import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

@ManagedBean(name = "oracleReader", eager = true)
@ApplicationScoped
public class OracleReader {
    @ManagedProperty(value = "#{oracleConnector}")
    private OracleConnector oracleConnector;

    public ArrayList<Point> readPoints(){
        ArrayList<Point> pointsList = new ArrayList<>();
        try {
            Connection connection = oracleConnector.getConnection();
            if (connection == null) throw new SQLException();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM POINTS");
            while(resultSet.next()){
                double x = resultSet.getDouble("X");
                double y = resultSet.getDouble("Y");
                double r = resultSet.getDouble("R");
                LocalDateTime creationDate = resultSet.getTimestamp("CREATIONDATA").toLocalDateTime();
                double workingTime = resultSet.getDouble("WORKINGTIME");
                Point point = new Point();
                point.setX(x);
                point.setY(y);
                point.setR(r);
                point.setCreationDate(creationDate);
                point.setWorkingTime(workingTime);
                pointsList.add(point);
            }
            System.out.println("Reading is over");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pointsList;
    }

    public OracleConnector getOracleConnector() {
        return oracleConnector;
    }

    public void setOracleConnector(OracleConnector oracleConnector) {
        this.oracleConnector = oracleConnector;
    }
}
