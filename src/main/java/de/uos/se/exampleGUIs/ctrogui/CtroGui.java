/*
 * Copyright (c) 2016.
 * This code is part of a project that aims to detect GUI elements on a Java Swing UI.
 * Contact: fwilke@uos.de and jschleutker@uos.de
 */

package de.uos.se.exampleGUIs.ctrogui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This GUI has two buttons of which one causes an exception be raised when clicked. A click on the other button does not have any effect at all.
 * The fatal button is chosen randomly.
 *
 * @author Jan-Philipp Schleutker(jschleutker@uos.de)
 */
public class CtroGui
        extends JFrame
{

    private static final long serialVersionUID = - 45L;

    /**
     * Create the frame.
     */
    private CtroGui()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        setTitle("Choose the right one");

        JLabel lblAOrB = new JLabel("A or B?");
        lblAOrB.setToolTipText("Choose the right button...");
        lblAOrB.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblAOrB.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblAOrB, BorderLayout.NORTH);

        JButton btnA = new JButton("A");
        btnA.setFont(new Font("Tahoma", Font.PLAIN, 16));
        contentPane.add(btnA, BorderLayout.WEST);

        JButton btnB = new JButton("B");
        btnB.setFont(new Font("Tahoma", Font.PLAIN, 16));
        contentPane.add(btnB, BorderLayout.EAST);

        ThreadLocalRandom localRandom = ThreadLocalRandom.current();
        int i = localRandom.nextInt(0, 2);
        System.out.println(i);
        if (i % 2 == 0)
        {
            btnA.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    throw new IllegalArgumentException("That was wrong!");
                }
            });
        } else
        {
            btnB.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    throw new IllegalArgumentException("That was wrong!");
                }
            });
        }
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    CtroGui frame = new CtroGui();
                    frame.setVisible(true);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

}
