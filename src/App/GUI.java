package App;

import javax.swing.JFrame;

public class GUI extends JFrame {
    Panel panel;

    GUI() {
        panel = new Panel();

        this.setTitle("Slugbury: Animal Edition");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(panel);
        this.pack();
        this.setVisible(true);

        panel.startGameThread();
    }
}
