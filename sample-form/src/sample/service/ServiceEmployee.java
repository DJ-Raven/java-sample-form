package sample.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.connection.DatabaseConnection;
import sample.model.ModelEmployee;
import sample.model.ModelPositions;

/**
 *
 * @author RAVEN
 */
public class ServiceEmployee {

    public List<ModelEmployee> getAll() throws SQLException {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet r = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("select * from employee join positions using (positions_id) order by positions_name, employee_name");
            r = p.executeQuery();
            List<ModelEmployee> list = new ArrayList<>();
            while (r.next()) {
                int employeeId = r.getInt("employee_id");
                String name = r.getString("employee_name");
                String location = r.getString("location");
                Date date = r.getDate("date");
                double salary = r.getDouble("salary");
                String description = r.getString("description");
                int positionId = r.getInt("positions_id");
                String positionsName = r.getString("positions_name");
                list.add(new ModelEmployee(employeeId, name, location, date, salary, description, new ModelPositions(positionId, positionsName)));
            }
            return list;
        } finally {
            DatabaseConnection.getInstance().close(r, p, con);
        }
    }

    public List<ModelEmployee> search(String search) throws SQLException {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet r = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("select * from employee join positions using (positions_id) where (positions_name like ? or employee_name like ? or description like ? or location like ?) order by positions_name, employee_name");
            p.setString(1, "%" + search + "%");
            p.setString(2, "%" + search + "%");
            p.setString(3, "%" + search + "%");
            p.setString(4, "%" + search + "%");
            r = p.executeQuery();
            List<ModelEmployee> list = new ArrayList<>();
            while (r.next()) {
                int employeeId = r.getInt("employee_id");
                String name = r.getString("employee_name");
                String location = r.getString("location");
                Date date = r.getDate("date");
                double salary = r.getDouble("salary");
                String description = r.getString("description");
                int positionId = r.getInt("positions_id");
                String positionsName = r.getString("positions_name");
                list.add(new ModelEmployee(employeeId, name, location, date, salary, description, new ModelPositions(positionId, positionsName)));
            }
            return list;
        } finally {
            DatabaseConnection.getInstance().close(r, p, con);
        }
    }

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

    public void edit(ModelEmployee data) throws SQLException {
        Connection con = null;
        PreparedStatement p = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("update employee set employee_name=?, location=?, date=?, salary=?, description=?, positions_id=? where employee_id=? limit 1");
            p.setString(1, data.getName());
            p.setString(2, data.getLocation());
            p.setDate(3, data.getDate());
            p.setDouble(4, data.getSalary());
            p.setString(5, data.getDescription());
            p.setInt(6, data.getPositions().getPositionsId());
            p.setInt(7, data.getEmployeeId());
            p.execute();
        } finally {
            DatabaseConnection.getInstance().close(p, con);
        }
    }

    public void delete(int id) throws SQLException {
        Connection con = null;
        PreparedStatement p = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("delete from employee where employee_id=? limit 1");
            p.setInt(1, id);
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
