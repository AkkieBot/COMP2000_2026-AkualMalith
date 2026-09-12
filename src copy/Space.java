import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Space extends JPanel {
    List<Body> CelestialBodies = new ArrayList<>();

    private final Timer timer;

    public Space() {
        timer = new Timer(16, event -> {
            updateUniverse();
            repaint();
        });
        timer.setInitialDelay(0);
        spawnBodies(70);
        timer.start();
    }

    void updateUniverse() {
        updatePhysics();
    }
    public void updatePhysics() {
        for (int i = 0; i < CelestialBodies.size(); i++) {
            for (int j = i + 1; j < CelestialBodies.size(); j++) {
                Body a = CelestialBodies.get(i);
                Body b = CelestialBodies.get(j);
                applyGravity(a, b);
            }
        }

        for (Body body : CelestialBodies) {
            body.updatePosition();

            body.setVelocityX(body.getVelocityX() * 0.999);
            body.setVelocityY(body.getVelocityY() * 0.999);
        }
    }

    private void applyGravity(Body a, Body b) {
        double dx = b.getX() - a.getX();
        double dy = b.getY() - a.getY();
        double d2 = dx * dx + dy * dy;

        if (d2 < 1e-10) {
            return;
        }

        double d = Math.sqrt(d2);
        double G = 0.03;
        double softening = 5.0;
        double force = G * a.getMass() * b.getMass() / (d2 + softening);

        double fx = force * dx / d;
        double fy = force * dy / d;

        a.applyForce(fx, fy);
        b.applyForce(-fx, -fy);
    }

    private void spawnBodies(int count) {
    Random rand = new Random();
    int width = 800;  
    int height = 600;

    for (int i = 0; i < count; i++) {
        Body body;

        double typeChance = rand.nextDouble();

        if (typeChance < 0.6) {
            body = new Star();
        } else if (typeChance < 0.85) {
            body = new DwarfStar();
        } else if (typeChance < 0.98) {
            body = new GiantStar();
        } else {
            body = new BlackHole();
        }

        // Random position
        body.setX(rand.nextDouble() * width);
        body.setY(rand.nextDouble() * height);

        // Random velocity for motion
        body.setVelocityX(rand.nextDouble() * 0.5 - 0.25);
        body.setVelocityY(rand.nextDouble() * 0.5 - 0.25);
        // Random mass and radius (handled by subclass)
        if (body instanceof Star) ((Star) body).setMass();
        if (body instanceof Star) ((Star) body).setRadius();

        CelestialBodies.add(body);
    }
}


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Body b : CelestialBodies) {
            b.draw(g);
        }
    }
}
