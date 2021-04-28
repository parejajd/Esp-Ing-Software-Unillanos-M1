/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import DAO.ShapesDAO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
 
public class MainPanel extends javax.swing.JPanel {

    /**
     * Creates new form MainPanel
     */
    ShapesDAO shapes;
    private Image image;
    
    public MainPanel(ShapesDAO shapes) {
        initComponents();
        this.shapes = shapes;       
        this.setSize(1000, 800);
    }
       @Override
    protected void paintComponent(Graphics g) {
        if (this.image != null) {
            g.drawImage(this.image, 0, 0, 1000, 800, null);
	} 
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        
       /*g.setColor(Color.red);
        g.drawRect(10, 10, 500, 300);*/
       DrawHelper helper=new DrawHelper(g);
       helper.draw(shapes);
       
    }
    public void setBackground(String imagePath) {
		
		// Construimos la imagen y se la asignamos al atributo background.
		this.setOpaque(false);
		this.image = new ImageIcon(imagePath).getImage();
		repaint();
	}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
