/*
This file is part of JNesBR.

JNesBR is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

JNesBR is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with JNesBR.  If not, see <http://www.gnu.org/licenses/>.
 */
package jnesbr.gui.debugger;

import java.awt.Color;
import java.awt.Graphics;
import jnesbr.util.JNesUtil;
import jnesbr.video.memory.VideoMemory;
import jnesbr.video.memory.VideoMemoryMap;

/**
 *
 * @author Leandro
 */
public class NameTableWindow extends javax.swing.JFrame {

    /** Creates new form NameTableWindow */
    public NameTableWindow() {
        initComponents();
    }

    private void buildNameTable(int initialAddress) {
        int rectangleSize = 15;
        int initialX = 75;
        int initialY = 35;
        int x = initialX;
        int y = initialY;
        Graphics grap = jPnNameTable.getGraphics();
        for (int line = 0; line < 30; line++) {
            for (int row = 0; row < 32; row++) {
                grap.setColor(Color.BLACK);
                grap.drawRect(x, y, rectangleSize, rectangleSize);
                grap.setColor(Color.RED);
                grap.fillRect(x, y, rectangleSize, rectangleSize);
                grap.setColor(Color.WHITE);
                short value = VideoMemory.getMemory().read(initialAddress++);
                grap.drawString(JNesUtil.giveMeHexaStringFormattedWith2Space(value), x, y + 12);
                x += rectangleSize + 1;
            }
            y += rectangleSize + 1;
            x = initialX;
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnShwName0 = new javax.swing.JButton();
        jBtnShwName1 = new javax.swing.JButton();
        jBtnShwName2 = new javax.swing.JButton();
        jBtnShwName3 = new javax.swing.JButton();
        jPnNameTable = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Name Table Viewer");
        setLocationByPlatform(true);
        setResizable(false);

        jBtnShwName0.setText("Show Name Table 0");
        jBtnShwName0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnShwName0ActionPerformed(evt);
            }
        });

        jBtnShwName1.setText("Show Name Table 1");
        jBtnShwName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnShwName1ActionPerformed(evt);
            }
        });

        jBtnShwName2.setText("Show Name Table 2");
        jBtnShwName2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnShwName2ActionPerformed(evt);
            }
        });

        jBtnShwName3.setText("Show Name Table 3");
        jBtnShwName3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnShwName3ActionPerformed(evt);
            }
        });

        jPnNameTable.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPnNameTableLayout = new javax.swing.GroupLayout(jPnNameTable);
        jPnNameTable.setLayout(jPnNameTableLayout);
        jPnNameTableLayout.setHorizontalGroup(
            jPnNameTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 601, Short.MAX_VALUE)
        );
        jPnNameTableLayout.setVerticalGroup(
            jPnNameTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 543, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPnNameTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnShwName0)
                .addGap(37, 37, 37)
                .addComponent(jBtnShwName1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jBtnShwName2)
                .addGap(32, 32, 32)
                .addComponent(jBtnShwName3)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPnNameTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnShwName0)
                    .addComponent(jBtnShwName3)
                    .addComponent(jBtnShwName1)
                    .addComponent(jBtnShwName2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnShwName0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnShwName0ActionPerformed
        buildNameTable(VideoMemoryMap.NAME_TABLE_0_START);
    }//GEN-LAST:event_jBtnShwName0ActionPerformed

    private void jBtnShwName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnShwName1ActionPerformed
        buildNameTable(VideoMemoryMap.NAME_TABLE_1_START);
    }//GEN-LAST:event_jBtnShwName1ActionPerformed

    private void jBtnShwName2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnShwName2ActionPerformed
        buildNameTable(VideoMemoryMap.NAME_TABLE_2_START);
    }//GEN-LAST:event_jBtnShwName2ActionPerformed

    private void jBtnShwName3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnShwName3ActionPerformed
        buildNameTable(VideoMemoryMap.NAME_TABLE_3_START);
    }//GEN-LAST:event_jBtnShwName3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new NameTableWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnShwName0;
    private javax.swing.JButton jBtnShwName1;
    private javax.swing.JButton jBtnShwName2;
    private javax.swing.JButton jBtnShwName3;
    private javax.swing.JPanel jPnNameTable;
    // End of variables declaration//GEN-END:variables
}