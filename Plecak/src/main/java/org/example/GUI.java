package org.example;
import javax.swing.*;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkOrangeIJTheme;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new FlatArcDarkOrangeIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }


        JFrame frame = new JFrame("Problem Plecakowy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new GridBagLayout());


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;


        JLabel label = new JLabel("Items:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(label, gbc);

        JTextField textField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        frame.add(textField, gbc);

        JLabel seedLabel = new JLabel("Seed:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(seedLabel, gbc);

        JSlider slider = new JSlider(0, 100);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(slider, gbc);

        JLabel capacityLabel = new JLabel("Capacity:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(capacityLabel, gbc);

        JTextField textField2 = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        frame.add(textField2, gbc);

        JButton button = new JButton("Solve");
        gbc.gridx = 1;
        gbc.gridy = 3;
        frame.add(button, gbc);


        slider.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int value = slider.getValue();
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    slider.setValue(value - 1);
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    slider.setValue(value + 1);
                }
            }
        });


        JTextArea largeTextArea = new JTextArea(10, 20);
        largeTextArea.setLineWrap(true);
        largeTextArea.setWrapStyleWord(true);
        largeTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        frame.add(new JScrollPane(largeTextArea), gbc);

        JTextArea smallTextArea = new JTextArea(5, 20);
        smallTextArea.setLineWrap(true);
        smallTextArea.setWrapStyleWord(true);
        smallTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        frame.add(new JScrollPane(smallTextArea), gbc);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int n = Integer.parseInt(textField.getText());
                    int seed = slider.getValue();
                    int cap = Integer.parseInt(textField2.getText());

                    if (n > 0 && seed > 0 && cap > 0) {
                        Problem problem = new Problem(n, seed, 1, 10);
                        largeTextArea.setText(problem.toString());
                        smallTextArea.setText(problem.Solve(cap).toString());
                    } else {
                        JOptionPane.showMessageDialog(frame, "Please enter positive values for all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        
        frame.setVisible(true);
    }
}
