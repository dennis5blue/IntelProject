package Client_gui;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/**
 * A Java class to demonstrate how to load an image from disk with the
 * ImageIO class. Also shows how to display the image by creating an
 * ImageIcon, placing that icon an a JLabel, and placing that label on
 * a JFrame.
 * 
 * @author alvin alexander, devdaily.com
 */
public class ImageDemo
{
  public ImageDemo() throws Exception
  {
	  editorFrame = new JFrame("Image Demo");
  }
  
  public void Image(final String filename) throws Exception
  {
	  BufferedImage image = null;
    		try
    		{
    			image = ImageIO.read(new File(filename));
    		}
    		catch (Exception e)
    		{
    			e.printStackTrace();
    			System.exit(1);
    		}
    		ImageIcon imageIcon = new ImageIcon(image);
    		JLabel jLabel = new JLabel();
    		jLabel.setIcon(imageIcon);
    		editorFrame.getContentPane().add(jLabel, BorderLayout.CENTER);

    		editorFrame.pack();
    		editorFrame.setLocationRelativeTo(null);
    		editorFrame.setVisible(true);
  }
  
  public void exit()
  {
	  if (editorFrame.isVisible())
	  {
		  editorFrame.dispose();
		  editorFrame = new JFrame("Image Demo");
	  }
  }
  public JFrame editorFrame;
}