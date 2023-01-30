package App;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; //The listener intereface for receiving keyboard events (keystrokes).

public class KeyHandler implements KeyListener {
    public boolean upPressed;
    public boolean downPressed;
    public boolean leftPressed;
    public boolean rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {
        //Not being used. 
    }

    /*
     * Tells the program what to do when a particular key has been pressed.  
     */
    @Override
    public void keyPressed(KeyEvent e) { 
        int code = e.getKeyCode();

        //W Key pressed.
        if (code == KeyEvent.VK_W) {
            upPressed = true;
        }

        //S Key pressed.
        if (code == KeyEvent.VK_S) {
            downPressed = true;
        }

        //A Key pressed.
        if (code == KeyEvent.VK_A) {
            leftPressed = true;
        }

        //D Key pressed.
        if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }
    }

    /*
     * Tells the program what to do when a particular key has been released. 
     */

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        //W Key released.
        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }

        //S Key released.
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }

        //A Key released.
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }

        //D Key released.
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }
}
