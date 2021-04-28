/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import models.Circle;
import models.Ellipse;
import models.Line;
import models.Rectangle;
import models.Square;

public class ShapesDAO {

    ArrayList<Line> lines;
    ArrayList<Circle> circles;
    ArrayList<Ellipse> ellipse;
    ArrayList<Square> square;
    ArrayList<Rectangle> rectangle;

    public ShapesDAO() {
        lines = new ArrayList();
        circles = new ArrayList();
        ellipse = new ArrayList();
        square = new ArrayList();
        rectangle = new ArrayList();
    }

   

    

    public void addShape(Ellipse ellipses) {
        ellipse.add(ellipses);
    }

    public void addShape(Square squares) {
        square.add(squares);
    }

    public void addShape(Rectangle rectangles) {
        rectangle.add(rectangles);
    }
    
    public void addShape(Line line) {
        lines.add(line);
    }
    
    public ArrayList<Ellipse> getEllipses() {
        return ellipse;
    }
    public ArrayList<Line> getLines() {
        return lines;
    }

    public ArrayList<Circle> getCircles() {
        return circles;
    }

    

    public ArrayList<Square> getSquare() {
        return square;
    }

    public ArrayList<Rectangle> getRectangle() {
        return rectangle;
    }
     public void addShape(Circle circle) {
        circles.add(circle);
    }
}
