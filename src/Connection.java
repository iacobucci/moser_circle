import java.util.Random;

import processing.core.PApplet;

public class Connection {
  PApplet pa;
  Point p1;
  Point p2;

  int col;

  public Connection(PApplet pa, Point p1, Point p2) {
    this.pa = pa;
    this.p1 = p1;
    this.p2 = p2;

    Random r = new Random();

    this.col = r.nextInt(255);
    this.col = 122;
  }

  @SuppressWarnings("static-access")
  public void show() {
    this.pa.colorMode(pa.HSB);
    this.pa.stroke(col,255,255);

    this.pa.line(this.p1.getX(), this.p1.getY(), this.p2.getX(), this.p2.getY());
  }

  public int getCol() {
    return col;
  }

  public void setCol(int col) {
    this.col = col;
  }

}
