import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

@ManagedBean(name = "oracleWriter", eager = true)
@ApplicationScoped
public class OracleWriter {
    @ManagedProperty(value = "#{oracleConnector}")
    private OracleConnector oracleConnector;

    public void write(ArrayList<Point> pointsList){
        try {
            Connection connection = oracleConnector.getConnection();
            if (connection == null) throw new SQLException();
            for(Point pointBean: pointsList){
                prepareWriteStatement(pointBean, connection);
            }
            System.out.println("Saving success");
        } catch (SQLException e){
            System.out.println("Problems while saving");
        }

    }

    public void write(Point point){
        try{
            Connection connection = oracleConnector.getConnection();
            if (connection == null) throw new SQLException();
            prepareWriteStatement(point, connection);
            System.out.println("Saving success");
        } catch (SQLException e){
            System.out.println("Problems while saving: " + e);
        }
    }

    public boolean clearTable(){
        try{
            Connection connection = oracleConnector.getConnection();
            if (connection == null) throw new SQLException();
            prepareClearStatement(connection);
            System.out.println("Cleaning success");
            return true;
        } catch (SQLException e){
            System.out.println("Problems while cleaning the table :" + e);
            return false;
        }
    }

    private void prepareWriteStatement(Point point, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO POINTS (X, Y, R, CREATIONDATA, WORKINGTIME) VALUES (?, ?, ?, ?, ?)");
        preparedStatement.setDouble(1, point.getX());
        preparedStatement.setDouble(2, point.getY());
        preparedStatement.setDouble(3, point.getR());
        preparedStatement.setTimestamp(4, Timestamp.valueOf(point.getCreationDate()));
        preparedStatement.setDouble(5, point.getWorkingTime());
        preparedStatement.execute();
    }

    private void prepareClearStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM POINTS");
        preparedStatement.execute();
    }

    public OracleConnector getOracleConnector() {
        return oracleConnector;
    }

    public void setOracleConnector(OracleConnector oracleConnector) {
        this.oracleConnector = oracleConnector;
    }
}
