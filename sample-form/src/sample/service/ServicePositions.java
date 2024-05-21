package sample.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.connection.DatabaseConnection;
import sample.model.ModelPositions;

/**
 *
 * @author RAVEN
 */
public class ServicePositions {

    public List<ModelPositions> getAll() throws SQLException {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet r = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("select * from positions");
            r = p.executeQuery();
            List<ModelPositions> list = new ArrayList<>();
            while (r.next()) {
                int positionId = r.getInt("positions_id");
                String positionsName = r.getString("positions_name");
                list.add(new ModelPositions(positionId, positionsName));
            }
            return list;
        } finally {
            DatabaseConnection.getInstance().close(r, p, con);
        }
    }
}
