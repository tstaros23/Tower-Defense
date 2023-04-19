package checkpoint3;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PhotonTorpedo extends GameObject {
    private Control control;
    private GameState state;
    private Point source;
    private Point target;
    private Path path;
    private double pathPercentage;
    private GameObject enemy;

    public PhotonTorpedo (Control control, GameState state, Point source, Point target, GameObject enemy)
    {
        this.control = control;
        this.state = state;
        this.source = source;
        this.target = target;
        this.enemy = enemy;
        this.pathPercentage = 0.0;

        path = new Path();
        path.add(source.x, source.y);
        path.add(target.x, target.y);
    }

    @Override
    public void update(double timeElapsed) {
        pathPercentage += 0.07;

        Point loc = path.convertToCoordinates(pathPercentage);
        // check what it is doing with photon debugger
        double distance = loc.distance(target);

        if (pathPercentage >= 1.00)
        {
            enemy.hasExpired = true;
            hasExpired = true;
        }

    }

    @Override
    public void draw(Graphics g) {
        BufferedImage photonTorpedo = control.getImage("photon.png");
        Point loc = path.convertToCoordinates(pathPercentage);
        g.drawImage(photonTorpedo, loc.x, loc.y, null);
    }
}
