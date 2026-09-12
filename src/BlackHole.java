import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class BlackHole extends Body {

    private double eventHorizonRadius;

    public BlackHole() {
        eventHorizonRadius = 30;
    }

    public void draw(Graphics g){
        g.setColor(new Color(50, 17, 6 ));
        g.fillOval((int)getX(), (int)getY(), 12, 12);
        g.setColor(new Color(110, 35, 13));
        g.fillOval((int)getX(), (int)getY(), 8, 8);
        }

    public void setMass(){
        Random rand = new Random();
        double randomDouble = 500 + rand.nextDouble() * 1500;
        setMass(randomDouble);
        }
    public void applyForce(double fx, double fy) {
        setVelocityX(getVelocityX() + fx * 0.01);
        setVelocityY(getVelocityY() + fy * 0.01);
    }

    public boolean shouldAbsorb(Body other) {
    double dx = getX() - other.getX();
    double dy = getY() - other.getY();
    return Math.sqrt(dx * dx + dy * dy) < eventHorizonRadius;
}
}

