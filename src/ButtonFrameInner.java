import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
  This version demonstrates the use of inner classes for handling
  events in ButtonFrameInner. Updated in the p2 branch.
*/

public class ButtonFrameInner extends JFrame
{
    public ButtonFrameInner()
    {
        JButton open = new JButton("Open");
        JButton close = new JButton("Close");
        JButton exit = new JButton("Exit"); // Added new Exit button
        ActionListener listener = new ButtonListener();

        open.addActionListener(listener);
        close.addActionListener(listener);
        exit.addActionListener(e -> {
            System.out.println("Exit button clicked. Application closing.");
            System.exit(0);
        }); // Exit button functionality

        Container pane = getContentPane();
        pane.setLayout(new FlowLayout());
        pane.add(open);
        pane.add(close);
        pane.add(exit); // Added Exit button to the layout

        addWindowListener(new ButtonCloser());
        setSize(300, 150); // Increased size to accommodate the new button
        setVisible(true);
    }

    public static void main(String args[])
    {
        JFrame f = new ButtonFrameInner();
    }

    private class ButtonListener implements ActionListener
    {
        int count = 0;

        public void actionPerformed(ActionEvent e)
        {
            // Modified output message
            System.out.println("Button clicked (" + count++ + "): " + e.getActionCommand());
        }
    }

    private class ButtonCloser extends WindowAdapter
    {
        public void windowClosing(WindowEvent we)
        {
            System.out.println("Application exiting through window close.");
            System.exit(0);
        }
    }
}
