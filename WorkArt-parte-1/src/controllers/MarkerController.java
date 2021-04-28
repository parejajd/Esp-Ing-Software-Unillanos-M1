/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.Circle;
import models.Line;
import DAO.ShapesDAO;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import models.Point;
import views.MainWindow;

public class MarkerController {
    ShapesDAO shapes;
    MainWindow mainwindow;
    public MarkerController() {
       shapes=new ShapesDAO();
       mainwindow= new  MainWindow(shapes);
       mainwindow.setPanel();
    }
    public void start()
    {
        mainwindow.setVisible(true);
    } 
}
