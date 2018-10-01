import java.awt.*;
import java.util.ArrayList;

public class Wall extends GameObject
{

    private double height;
    private double width;

    public Wall(float x, float y, double width, double height, ObjectID id) {
        super(x, y, id);
        this.height = height;
        this.width = width;
    }

    @Override
    public void tick(ArrayList<GameObject> objects) {

    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.GRAY);
        g.fillRect((int)x, (int)y, (int)width, (int)height);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, (int)width, (int)height);
    }
}
