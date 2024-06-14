package sample.table;

import java.awt.Component;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.DefaultCellEditor;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JTextField;
import raven.datetime.component.date.DatePicker;

/**
 *
 * @author Raven
 */
public class DateTableCellEditor extends DefaultCellEditor {

    private final DatePicker datePicker = new DatePicker();
    private final JFormattedTextField dateEditor = new JFormattedTextField();

    public DateTableCellEditor() {
        super(new JTextField());
        datePicker.setEditor(dateEditor);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value == null) {
            datePicker.clearSelectedDate();
        } else if (value instanceof Date) {
            Date date = (Date) value;
            datePicker.setSelectedDate(date.toLocalDate());
        }
        return dateEditor;
    }

    @Override
    public Object getCellEditorValue() {
        LocalDate date = datePicker.getSelectedDate();
        return date == null ? null : Date.valueOf(datePicker.getSelectedDate());
    }
}
