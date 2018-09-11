import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{
    Handler handler;

    public KeyInput (Handler handler)
    {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_ESCAPE)
        {
            System.exit(1);
        }

    }

    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();

    }
}
