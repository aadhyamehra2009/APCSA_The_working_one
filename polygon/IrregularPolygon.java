package polygon;

import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*; // for DrawingTool

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    // constructor
    public IrregularPolygon() {}

    // public methods
    public void add(Point2D.Double aPoint)
    {
        // Add a point to the IrregularPolygon.
        // We simply append the provided point to our list.
        myPolygon.add(aPoint);
    }

    public double perimeter() {
        // Calculate the perimeter by summing the distance between
        // consecutive points (closing the polygon by connecting
        // the last point back to the first).  If there are fewer
        // than 2 points the perimeter is zero.
        int n = myPolygon.size();
        if (n < 2) {
            return 0.0;
        }
        double peri = 0.0;
        for (int i = 0; i < n; i++) {
            Point2D.Double p1 = myPolygon.get(i);
            Point2D.Double p2 = myPolygon.get((i + 1) % n);
            double dx = p2.x - p1.x;
            double dy = p2.y - p1.y;
            peri += Math.hypot(dx, dy);
        }
        return peri;
    }

    public double area() {
        // Calculate the area using the shoelace formula.  The formula
        // works for any simple polygon and will return a signed area;
        // we take the absolute value.  If fewer than 3 points, area is 0.
        int n = myPolygon.size();
        if (n < 3) {
            return 0.0;
        }
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            Point2D.Double p1 = myPolygon.get(i);
            Point2D.Double p2 = myPolygon.get((i + 1) % n);
            sum += p1.x * p2.y - p2.x * p1.y;
        }
        return Math.abs(sum) / 2.0;
    }

    public void draw()
    {
        // Wrap the DrawingTool in a try/catch to allow development without need for graphics.
        try {
            if (myPolygon.isEmpty()) {
                return; // nothing to draw
            }
            DrawingTool myDrawingTool = new DrawingTool(new SketchPad(500, 500));
            // move to first point without drawing
            Point2D.Double first = myPolygon.get(0);
            myDrawingTool.up();
            myDrawingTool.move(first.x, first.y);
            myDrawingTool.down();

            // draw lines to each subsequent point
            for (int i = 1; i < myPolygon.size(); i++) {
                Point2D.Double p = myPolygon.get(i);
                myDrawingTool.move(p.x, p.y);
            }
            // close the polygon by returning to the first point
            myDrawingTool.move(first.x, first.y);
        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }

}
