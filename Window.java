package candycrush;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 2476719703464559686L;
	/**
	 * 
	 *
	 */
	public Window(int width, int height, String title, Game game) {
        super(title);

        Dimension d = new Dimension(width, height);
        game.setPreferredSize(d);
        game.setMaximumSize(d);
        game.setMinimumSize(d);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().add(game);
        pack();
        setVisible(true);
        game.start();
    }
}

