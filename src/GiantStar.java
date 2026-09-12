import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class GiantStar extends Star{

    public void setMass(){
        Random rand = new Random();
        double randomDouble = 60 + rand.nextDouble() * 180;
        setMass(randomDouble);
        }

    public void draw(Graphics g){
        g.setColor(new Color(254, 143, 143));
        g.fillOval((int)getX(), (int)getY(), (int)(getRadius() * 2), (int)(getRadius() * 2));
        
        }
  public void updatePosition() {
        setX(getX() + getVelocityX() * 0.4);
        setY(getY() + getVelocityY() * 0.4);

}
}

