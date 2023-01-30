package App;

import javax.swing.JFrame;

public class GUI extends JFrame {
    Panel panel;

    /*
     * Creates the Graphical User Interface.
     */
    GUI() {
        panel = new Panel();

        this.setTitle("OOP Assignment");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(panel);
        this.pack();
        this.setVisible(true);

        panel.startGameThread();
    }
}
