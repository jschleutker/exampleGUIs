/*
 * Copyright (c) 2016.
 * This code is part of a project that aims to detect GUI elements on a Java Swing UI.
 * Contact: fwilke@uos.de and jschleutker@uos.de
 */

package de.uos.se.exampleGUIs.frugalExample;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by sem on 14.12.2015.
 * <p/>
 * This is a really short-coded example frame to be used for JUnit testing.
 *
 * @author Jan-Philipp Schleutker <jschleutker@uos.de>
 */
public class FrugalExampleMain
        extends JFrame
{

    /**
     *
     */
    private static final long serialVersionUID = - 1216232003101559303L;

    /**
     * Create the frame.
     */
    private FrugalExampleMain()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        contentPane.add(panel, BorderLayout.CENTER);

        JButton btnToggle = new JButton("toggle");
        btnToggle.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (panel.getBackground() == Color.BLACK)
                {
                    panel.setBackground(Color.WHITE);
                } else
                {
                    panel.setBackground(Color.BLACK);
                }
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
                FrugalExampleMain frame = new FrugalExampleMain();
                frame.setVisible(true);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        });
    }

}
