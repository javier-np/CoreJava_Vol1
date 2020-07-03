package imageViewer;
import java.awt.*;
import java.io.*;
import javax.swing.*;

public class ImageViewer 
{
    public static void main(String... args)
    {
        EventQueue.invokeLater( () -> {
            var frame = new ImageViewerFrame();
            frame.setTitle("Image viewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ImageViewerFrame extends JFrame
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    public ImageViewerFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        //the label where the image will be displayed
        var label = new JLabel();
        add(label);
        
        //setting up the file chooser
        var chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        
        //setting up the menu bar
        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        var menu = new JMenu("File");
        menuBar.add(menu);
        
        var openItem = new JMenuItem("Open");
        menu.add(openItem);
        
        openItem.addActionListener(event -> {
        	int result = chooser.showOpenDialog(null);
        	
        	if(result == JFileChooser.APPROVE_OPTION)
        	{
        		String name = chooser.getSelectedFile().getPath();
        		label.setIcon(new ImageIcon(name));
        	}
        	
        });
        
        var exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(event -> {
        	System.exit(0);
        });
    }
}