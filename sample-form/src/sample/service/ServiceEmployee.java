package sample.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import net.coobird.thumbnailator.Thumbnails;
import sample.connection.DatabaseConnection;
import sample.model.ModelEmployee;
import sample.model.ModelPositions;
import sample.model.other.ModelProfile;

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
                ModelProfile profile = new ModelProfile(r.getBytes("profile"));
                list.add(new ModelEmployee(employeeId, name, location, date, salary, description, profile, new ModelPositions(positionId, positionsName)));
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
                ModelProfile profile = new ModelProfile(r.getBytes("profile"));
                list.add(new ModelEmployee(employeeId, name, location, date, salary, description, profile, new ModelPositions(positionId, positionsName)));
            }
            return list;
        } finally {
            DatabaseConnection.getInstance().close(r, p, con);
        }
    }

    public void create(ModelEmployee data) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement p = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("insert into employee (employee_name, location, date, salary, description, positions_id, profile) values (?,?,?,?,?,?,?)");
            p.setString(1, data.getName());
            p.setString(2, data.getLocation());
            p.setDate(3, data.getDate());
            p.setDouble(4, data.getSalary());
            p.setString(5, data.getDescription());
            p.setInt(6, data.getPositions().getPositionsId());
            if (data.getProfile() != null) {
                p.setBytes(7, getByteImage(data.getProfile().getPath()));
            } else {
                p.setBytes(7, null);
            }
            p.execute();
        } finally {
            DatabaseConnection.getInstance().close(p, con);
        }
    }

    public void edit(ModelEmployee data) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement p = null;
        try {
            boolean isEditProfile = data.getProfile() == null || data.getProfile().getPath() != null;
            String sql = isEditProfile ? "update employee set employee_name=?, location=?, date=?, salary=?, description=?, positions_id=?, profile=? where employee_id=? limit 1"
                    : "update employee set employee_name=?, location=?, date=?, salary=?, description=?, positions_id=? where employee_id=? limit 1";
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement(sql);
            p.setString(1, data.getName());
            p.setString(2, data.getLocation());
            p.setDate(3, data.getDate());
            p.setDouble(4, data.getSalary());
            p.setString(5, data.getDescription());
            p.setInt(6, data.getPositions().getPositionsId());
            if (isEditProfile) {
                if (data.getProfile() != null) {
                    p.setBytes(7, getByteImage(data.getProfile().getPath()));
                } else {
                    p.setBytes(7, null);
                }
                p.setInt(8, data.getEmployeeId());
            } else {
                p.setInt(7, data.getEmployeeId());
            }

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

    private byte[] getByteImage(File file) throws IOException {
        BufferedImage image = Thumbnails.of(file)
                .width(500)
                .outputQuality(0.7f)
                .asBufferedImage();
        ByteArrayOutputStream out = null;
        try {
            out = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", out);
            byte[] data = out.toByteArray();
            return data;
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    private ServicePositions servicePositions;
}
