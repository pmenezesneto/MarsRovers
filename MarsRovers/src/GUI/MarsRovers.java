package GUI;

import Controller.ControlMarsRovers;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Severino de Menezes Neto
 */

public class MarsRovers extends javax.swing.JFrame {
    
    //<editor-fold defaultstate="collapsed" desc="Attributes and Properties">
    
    private String position, instruction;
    private final ControlMarsRovers control = new ControlMarsRovers();
    
    //</editor-fold>
   
    //<editor-fold defaultstate="collapsed" desc="Builder">
    
    public MarsRovers() {
        initComponents();
    }
    
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_roversPosition = new javax.swing.JLabel();
        txt_roversPosition = new javax.swing.JTextField();
        lbl_instructions = new javax.swing.JLabel();
        txt_instructions = new javax.swing.JTextField();
        txt_output = new javax.swing.JTextField();
        btn_start = new javax.swing.JButton();
        bnt_hintRoversPosition = new javax.swing.JButton();
        bnt_hintInstructions = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lbl_roversPosition.setText("Rovers Position:");

        lbl_instructions.setText("Instructions:");

        txt_output.setEditable(false);

        btn_start.setText("Start");
        btn_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startActionPerformed(evt);
            }
        });

        bnt_hintRoversPosition.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hint.png"))); // NOI18N
        bnt_hintRoversPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_hintRoversPositionActionPerformed(evt);
            }
        });

        bnt_hintInstructions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hint.png"))); // NOI18N
        bnt_hintInstructions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_hintInstructionsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addComponent(txt_output, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_roversPosition)
                            .addComponent(lbl_instructions))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_roversPosition)
                            .addComponent(txt_instructions, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bnt_hintRoversPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bnt_hintInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(btn_start)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_roversPosition)
                                .addComponent(txt_roversPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bnt_hintRoversPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_instructions)
                            .addComponent(txt_instructions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(bnt_hintInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(btn_start)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(txt_output, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="Methods">
    
    private void btn_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_startActionPerformed
        instruction = txt_instructions.getText();
        position = txt_roversPosition.getText();
        if(control.CheckFieldPosition(position))
        {
            if(control.CheckFieldInstruction(instruction))
            {
                control.InstanceRover(position);
                control.ExecuteInstructions(instruction);
                txt_output.setText(control.Output());
            }
            else
            {
                JOptionPane.showMessageDialog(null, "The field Instructions have a wrong value, please, check the Hint to more information", "Wrong Value", JOptionPane.ERROR_MESSAGE);
                txt_instructions.requestFocus();                
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "The field Rovers Position have a wrong value, please, check the Hint to more information", "Wrong Value", JOptionPane.ERROR_MESSAGE);
            txt_roversPosition.requestFocus();
        }
    }//GEN-LAST:event_btn_startActionPerformed

    private void bnt_hintRoversPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_hintRoversPositionActionPerformed
        JOptionPane.showMessageDialog(null, "This field must contain 2 numbers and 1 uppercase letter with spaces between each caracter. Exemple: 0 0 N", "Information", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_bnt_hintRoversPositionActionPerformed

    private void bnt_hintInstructionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_hintInstructionsActionPerformed
        JOptionPane.showMessageDialog(null, "This field must contain letters with no space. The letters must be 'LRM', any other letter will not work here.", "Information", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_bnt_hintInstructionsActionPerformed

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Main">
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
        */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MarsRovers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MarsRovers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MarsRovers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MarsRovers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MarsRovers().setVisible(true);
            }
        });
        
    //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnt_hintInstructions;
    private javax.swing.JButton bnt_hintRoversPosition;
    private javax.swing.JButton btn_start;
    private javax.swing.JLabel lbl_instructions;
    private javax.swing.JLabel lbl_roversPosition;
    private javax.swing.JTextField txt_instructions;
    private javax.swing.JTextField txt_output;
    private javax.swing.JTextField txt_roversPosition;
    // End of variables declaration//GEN-END:variables
}
