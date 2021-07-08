import processing.core.PApplet;

public class Main extends PApplet {

  int num = 1;
  Moser m;

  public static void main(String[] args) {
    PApplet.main("Main");
  }

  public void settings() {
    size(800, 800);
  }

  public void setup() {
    ellipseMode(RADIUS);
    m = new Moser(this, 0, 300);
    m.setNum(num);
    stroke(255);
  }

  public void draw() {
    background(0, 0.35F);
    noFill();
    m.show(0.003F);

//    if (m.record())
//      saveFrame("res/####.png");
  }

  public void keyPressed() {
    if (key == '+')
      m.setNum(++num);

    if (key == '-')
      m.setNum(--num);

    if (key == ' ')
      m.setAnimate();
  }

}