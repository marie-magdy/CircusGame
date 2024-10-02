/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package World;

import Strategy.StrategyType;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Philimon 15-1-2021
 */
public class CurtainsClosed extends javax.swing.JFrame {

    /**
     * Creates new form CurtainsClosed
     */
    public CurtainsClosed() {
        initComponents();
        resizeImage();
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1050, 630));
        getContentPane().setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/start.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(444, 330, 150, 90);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jLabel1.setMaximumSize(new java.awt.Dimension(500, 500));
        jLabel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jLabel1.setPreferredSize(new java.awt.Dimension(500, 500));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(180, 60, 690, 540);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/curtainsVideo.gif"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(1200, 1200));
        jLabel2.setMinimumSize(new java.awt.Dimension(960, 590));
        jLabel2.setPreferredSize(new java.awt.Dimension(960, 590));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1080, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        GameLauncher game = new GameLauncher(StrategyType.EASY, 3);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void resizeImage() {

        // Replace "/logo.png" with the actual path to your image
        String imagePath = "/logo.png";
        ImageIcon originalIcon = new ImageIcon(getClass().getResource(imagePath));

        // Resize the image to fit the label dimensions
        int labelWidth = 500;
        int labelHeight = 500;
        Image resizedImage = originalIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);

        // Create a new ImageIcon with the resized image
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        // Set the resized ImageIcon on the JLabel
        jLabel1.setIcon(resizedIcon);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new CurtainsClosed().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
