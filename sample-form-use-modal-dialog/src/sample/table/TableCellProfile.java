package sample.table;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Font;
import sample.model.ModelEmployee;

/**
 *
 * @author RAVEN
 */
public class TableCellProfile extends javax.swing.JPanel {

    public TableCellProfile(ModelEmployee data, Font font) {
        initComponents();
        lbName.setFont(font);
        lbLocation.setFont(font);
        lbName.setText(data.getName());
        lbLocation.setText(data.getLocation());
        lbLocation.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Label.disabledForeground");
        if (data.getProfile().getIcon() != null) {
            pic.setIcon(data.getProfile().getAvatarIcon());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbName = new javax.swing.JLabel();
        lbLocation = new javax.swing.JLabel();
        pic = new javax.swing.JLabel();

        lbName.setText("Name");

        lbLocation.setText("Location");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbName)
                    .addComponent(lbLocation))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLocation)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbLocation;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel pic;
    // End of variables declaration//GEN-END:variables
}
