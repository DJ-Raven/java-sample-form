package sample.form;

import com.formdev.flatlaf.FlatClientProperties;
import raven.extras.AvatarIcon;
import sample.model.ModelEmployee;
import sample.swing.EventCardSelection;

/**
 *
 * @author Raven
 */
public class Card extends javax.swing.JPanel {

    public ModelEmployee getEmployee() {
        return employee;
    }

    private final ModelEmployee employee;

    public Card(ModelEmployee employee, EventCardSelection event) {
        this.employee = employee;
        initComponents();
        putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:30");
        lbName.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +2;");
        txtDescription.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:0,0,0,0;"
                + "background:null;");
        cmdView.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:999;"
                + "margin:3,25,3,25;"
                + "borderWidth:1;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "background:null;");
        if (employee.getProfile().getIcon() != null) {
            lbPic.setIcon(new AvatarIcon(employee.getProfile().getIcon(), 150, 150, 25));
        }
        lbName.setText(employee.getName());
        txtDescription.setText(employee.getDescription());
        cmdView.addActionListener((e) -> {
            event.selected(this);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbPic = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextArea();
        cmdView = new javax.swing.JButton();

        lbName.setText("Name");

        txtDescription.setEditable(false);
        txtDescription.setColumns(15);
        txtDescription.setLineWrap(true);
        txtDescription.setRows(1);
        txtDescription.setWrapStyleWord(true);

        cmdView.setText("View");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbPic, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdView)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(cmdView))
                    .addComponent(lbPic, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdView;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbPic;
    private javax.swing.JTextArea txtDescription;
    // End of variables declaration//GEN-END:variables
}
