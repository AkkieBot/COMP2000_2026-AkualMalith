import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class DwarfStar extends Star {

        public void setMass(){
        Random rand = new Random();
        double randomDouble = rand.nextDouble() * 3;
        setMass(randomDouble);
        }

 public void draw(Graphics g){
         g.setColor(new Color(173, 225, 221));
         g.fillOval((int)getX(), (int)getY(), (int)(getRadius() * 0.7), (int)(getRadius() * 0.7));
    }
 public void updatePosition() {
        setX(getX() + getVelocityX() * 1.3);
        setY(getY() + getVelocityY() * 1.3);
}
    }

