import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Star extends Body{
     private int radius;
    
       // Functions 
        public void setMass(){
        Random rand = new Random();
        double randomDouble = 10 + rand.nextDouble() * 30;
        setMass(randomDouble);
        }

        public void setRadius(){
            Random rand = new Random();
            radius = 5 + rand.nextInt(16);
        }

        public int getRadius(){
            return radius;
        }

    public  void updatePosition(){
        setX(getX() + getVelocityX() * 1.2);
        setY(getY() + getVelocityY() * 1.2);
    }

    public void draw(Graphics g){
        g.setColor(new Color(246, 205, 152));
        g.fillOval((int)getX(), (int)getY(), radius, radius);
     }
    }