package App;

import java.awt.event.*;

public class MouseMovement extends Panel implements MouseListener, MouseMotionListener {

    // Mouse Listener
    @Override
    public void mouseClicked(MouseEvent e) {
        // Invoked when the mouse button has been clicked (pressed and released) on a component
        System.out.println(String.format("Clicked at %d, %d", e.getX(), e.getY()));

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Invoked when a mouse button has been pressed on a component.
        // System.out.println("You pressed on the mouse.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Invoked when a mouse button has been released on a component. 
        System.out.println("You released the mouse.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Invoked when the mouse enters a component.
        System.out.println("You entered the window.");
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Invoked when the mouse exits a component.
        System.out.println("You exited the window.");
        
    }

    //MouseMotionListener
    @Override
    public void mouseDragged(MouseEvent e) {
        // Invoked when the mouse is dragged. 
        System.out.println("You are dragging the mouse!");

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // Invokes when the mouse is being moved.
        System.out.println("The mouse moved!");
    } 
}
