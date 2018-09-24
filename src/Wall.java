import java.awt.*;
import java.util.ArrayList;

public class Wall extends GameObject
{

    private double height;
    private double width;

    public Wall(float x, float y, ObjectID id) {
        super(x, y, id);
    }

    @Override
    public void tick(ArrayList<GameObject> objects) {

    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
