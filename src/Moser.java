import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;

public class Moser {
  PApplet pa;

  boolean anim;
  int num;
  float r;

  float dtheta;

  List<Point> points;
  List<Connection> connections;

  public Moser(PApplet pa, int num, float r) {
    this.pa = pa;
    this.dtheta = 0;
    this.setR(r);
    this.setNum(num);
    this.anim = false;
  }

  private void update() {
    this.points = new ArrayList<>();
    this.connections = new ArrayList<>();

    for (int i = 0; i < this.num; i++)
      this.points.add(new Point(this.pa, 0.0F, 0.0F));

    for (int i = 0; i < this.num; i++) {
//      this.points.get(i).setR(i*(this.r/this.num));
      this.points.get(i).setR(this.r);
      this.points.get(i).setTheta((float) (i * (2 * Math.PI / this.num)));
    }

    for (Point p1 : this.points)
      for (Point p2 : this.points)
        if (!p1.equals(p2))
          this.connections.add(new Connection(this.pa, p1, p2));

    for (int i = 0; i < this.connections.size(); i++)
      if (this.num % 2 == 0)
        if (i % (this.num / 2) == 0)
          this.connections.get(i).setCol(242);
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
    this.update();
  }

  public float getR() {
    return r;
  }

  public void setR(float r) {
    this.r = r;
    this.update();
  }

  public void setAnimate() {
    this.anim = !this.anim;
  }

  public void animate(float ddtheta) {

    dtheta += ddtheta;

    for (int i = 1; i < this.num; i++) {
      this.points.get(i).setTheta(this.points.get(i - 1).getTheta() + this.dtheta);
    }
  }

  public boolean record() {
    if (this.anim && this.dtheta <= Math.PI * 2)
      return true;
    return false;
  }

  public void show(float ddtheta) {

    if (this.anim)
      this.animate(ddtheta);

    for (int i = 0; i < this.num; i++)
      this.points.get(i).show();

    for (Connection c : this.connections)
      c.show();
  }
}
