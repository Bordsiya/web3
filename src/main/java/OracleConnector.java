import javax.annotation.Resource;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@ManagedBean(name = "oracleConnector", eager = true)
@ApplicationScoped
public class OracleConnector {

    @Resource(name="java:/ExampleDS")
    private DataSource dataSource;

    public Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            return null;
        }
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
