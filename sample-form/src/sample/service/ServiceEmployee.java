package sample.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sample.connection.DatabaseConnection;
import sample.model.ModelEmployee;

/**
 *
 * @author RAVEN
 */
public class ServiceEmployee {

    public void create(ModelEmployee data) throws SQLException {
        Connection con = null;
        PreparedStatement p = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("insert into employee (employee_name, location, date, salary, description, positions_id) values (?,?,?,?,?,?)");
            p.setString(1, data.getName());
            p.setString(2, data.getLocation());
            p.setDate(3, data.getDate());
            p.setDouble(4, data.getSalary());
            p.setString(5, data.getDescription());
            p.setInt(6, data.getPositions().getPositionsId());
            p.execute();
        } finally {
            DatabaseConnection.getInstance().close(p, con);
        }
    }

    public ServicePositions getServicePositions() {
        if (servicePositions == null) {
            servicePositions = new ServicePositions();
        }
        return servicePositions;
    }

    private ServicePositions servicePositions;
}
