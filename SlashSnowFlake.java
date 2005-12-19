/*
 * $Id: SlashSnowFlake.java,v 1.3 2005/12/19 09:14:06 dds Exp $
 */
package gr.aueb.xmascard;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * A class that animates a slash on a canvas.
 *
 * @author Giorgos Gousios, Diomidis Spinellis
 */
public class SlashSnowFlake extends SnowFlake {

    /**
     * Create a snowflake represented by a slash.
     *
     * @param panel
     *            The panel to draw the object onto
     */
    public SlashSnowFlake(JPanel panel) {
        displayChar = '/';

	bounds = panel.getBounds();
        canvas = (Graphics2D)panel.getGraphics();
        /* Choose a random starting point */
        coordX = (int) (bounds.width * Math.random()) + bounds.x;
        coordY = 0;
    }

    /**
     * Display the slash on the drawing canvas. The slash alternates between
     * forward slash and backslash depending on the current 'y' coordinate.
     */
    public void draw() {

        /* / on even lines, \ on odd lines */
        displayChar = ((coordY % 2) == 0) ? '/' : '\\';

        /* Move by 0 to 10 pixels down*/
        coordY += (int) (Math.random() * 10);

        /* Go back to the top when hitting the bottom*/
        if (coordY >= bounds.width + bounds.y)
            coordY = 0;

        canvas.setColor(new Color(255, 255, 255));
        canvas.drawString((new Character(displayChar)).toString(), coordX,
                coordY);
    }

}
