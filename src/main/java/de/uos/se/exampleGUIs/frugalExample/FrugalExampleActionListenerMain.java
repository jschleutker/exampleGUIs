/*
 * Copyright (c) 2016.
 * This code is part of a project that aims to detect GUI elements on a Java Swing UI.
 * Contact: fwilke@uos.de and jschleutker@uos.de
 */

package de.uos.se.exampleGUIs.frugalExample;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by sem on 14.12.2015.
 * <p/>
 * This is a really short-coded example frame to be used for JUnit testing.
 *
 * @author Jan-Philipp Schleutker <jschleutker@uos.de>
 */
public class FrugalExampleActionListenerMain
        extends JFrame
{

    /**
     *
     */
    private static final long serialVersionUID = - 1216232003101559303L;

    /**
     * Create the frame.
     */
    private FrugalExampleActionListenerMain()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);
        contentPane.add(panel, BorderLayout.CENTER);

        JButton btnToggle = new JButton("toggle");
        btnToggle.addActionListener(e -> {
            if (panel.getBackground() == Color.GREEN)
            {
                panel.setBackground(Color.DARK_GRAY);
            } else
            {
                panel.setBackground(Color.GREEN);
            }
        });
        contentPane.add(btnToggle, BorderLayout.SOUTH);

    }

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            try
            {
                FrugalExampleActionListenerMain frame = new FrugalExampleActionListenerMain();
                frame.setVisible(true);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        });
    }

}
