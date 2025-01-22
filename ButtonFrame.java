// Change made in the p1 branch as part of the assignment

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ButtonListener implements ActionListener
{
    int count = 0;
    public void actionPerformed(ActionEvent e)
    {
        // Updated message in p1 branch
        System.out.println("Button clicked! Current count: " + count++ + 
                           " | Action: " + e.getActionCommand());
    }
}

class ButtonCloser extends WindowAdapter
{
    public void windowClosing(WindowEvent we)
    {
        System.out.println("Application exiting");
        System.exit(0);
    }
}

public class ButtonFrame extends JFrame
{
    public ButtonFrame()
    {
        JButton open = new JButton("Open");
        JButton close = new JButton("Close");
        JButton exit = new JButton("Exit"); // New button added in p1 branch

        ActionListener listener = new ButtonListener();

        open.addActionListener(listener);
        close.addActionListener(listener);
        exit.addActionListener(e -> {
            System.out.println("Exiting from Exit button.");
            System.exit(0);
        }); // Exit functionality added

        Container pane = getContentPane();
        pane.setLayout(new FlowLayout());
        pane.add(open);
        pane.add(close);
        pane.add(exit); // Add new button to the layout

        addWindowListener(new ButtonCloser());
        setSize(250, 150); // Adjusted size to fit the new button
        setVisible(true);
    }

    public static void main(String args[])
    {
        JFrame f = new ButtonFrame();
    }
}
