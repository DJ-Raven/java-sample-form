package sample.model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author RAVEN
 */
public class ModelEmployee {

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ModelPositions getPositions() {
        return positions;
    }

    public void setPositions(ModelPositions positions) {
        this.positions = positions;
    }

    public ModelEmployee(int employeeId, String name, String location, Date date, double salary, String description, ModelPositions positions) {
        this.employeeId = employeeId;
        this.name = name;
        this.location = location;
        this.date = date;
        this.salary = salary;
        this.description = description;
        this.positions = positions;
    }

    public ModelEmployee() {
    }

    private int employeeId;
    private String name;
    private String location;
    private Date date;
    private double salary;
    private String description;
    private ModelPositions positions;

    public Object[] toTableRow(int rowNum) {
        DateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");
        NumberFormat nf = new DecimalFormat("$ #,##0.##");
        return new Object[]{false, rowNum, this, location, date == null ? "" : df.format(date), nf.format(salary), positions, description};
    }

    @Override
    public String toString() {
        return name;
    }
}
