import processing.core.PApplet;

public class Point {
  PApplet pa;

  float x;
  float y;

  float r;
  float theta;

  public Point(PApplet pa, float x, float y) {
    this.pa = pa;

    this.x = x;
    this.y = y;

  }

  public void setX(float x) {
    this.x = x;

    float t;

    if (this.x == 0) {
      if (this.y >= 0)
        this.theta = (float) (Math.PI / 2);
      if (this.y < 0)
        this.theta = (float) (3 * Math.PI / 2);
    } else {
      t = (float) Math.abs(Math.acos(this.y / this.x));

      if (this.x > 0 && this.y >= 0)
        this.theta = t;

      if (this.x < 0 && this.y >= 0)
        this.theta = (float) (t + Math.PI / 2);

      if (this.x < 0 && this.y < 0)
        this.theta = (float) (t + 2 * Math.PI / 2);

      if (this.x > 0 && this.y < 0)
        this.theta = (float) (t + 3 * Math.PI / 2);
    }

    this.r = (float) Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));

  }

  public void setY(float y) {
    this.y = y;

    float t;

    if (this.x == 0) {
      if (this.y >= 0)
        this.theta = (float) (Math.PI / 2);
      if (this.y < 0)
        this.theta = (float) (3 * Math.PI / 2);
    } else {
      t = (float) Math.abs(Math.acos(this.y / this.x));

      if (this.x > 0 && this.y >= 0)
        this.theta = t;

      if (this.x < 0 && this.y >= 0)
        this.theta = (float) (t + Math.PI / 2);

      if (this.x < 0 && this.y < 0)
        this.theta = (float) (t + 2 * Math.PI / 2);

      if (this.x > 0 && this.y < 0)
        this.theta = (float) (t + 3 * Math.PI / 2);
    }

    this.r = (float) Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
  }

  public void setTheta(float theta) {
    this.theta = theta;

    this.x = (float) (pa.width / 2 + this.r * Math.cos(theta));
    this.y = (float) (pa.height / 2 + this.r * Math.sin(theta));
  }

  public void setR(float r) {
    this.r = r;

    this.x = (float) (pa.width / 2 + r * Math.cos(this.theta));
    this.y = (float) (pa.height / 2 + r * Math.sin(this.theta));
  }

  @SuppressWarnings("static-access")
  public void show() {
    this.pa.fill(255);
    this.pa.noStroke();
    this.pa.ellipseMode(this.pa.RADIUS);
    this.pa.ellipse(this.x, this.y, 4, 4);
  }

  public float getX() {
    return x;
  }

  public float getY() {
    return y;
  }

  public float getTheta() {
    return this.theta;
  }

  public float getR() {
    return this.r;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((pa == null) ? 0 : pa.hashCode());
    result = prime * result + Float.floatToIntBits(x);
    result = prime * result + Float.floatToIntBits(y);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Point other = (Point) obj;
    if (pa == null) {
      if (other.pa != null)
        return false;
    } else if (!pa.equals(other.pa))
      return false;
    if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
      return false;
    if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
      return false;
    return true;
  }

}
