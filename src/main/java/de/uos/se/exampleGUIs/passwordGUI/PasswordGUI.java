/*
 * Copyright (c) 2016.
 * This code is part of a project that aims to detect GUI elements on a Java Swing UI.
 * Contact: fwilke@uos.de and jschleutker@uos.de
 */

package de.uos.se.exampleGUIs.passwordGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * A GUI which consists of a password field, button and label. The text typed in the password field will be shown on the label upon a mouse click on the button or if enter was pressed.
 *
 * @author Jan-Philipp Schleutker (jschleutker@uos.de)
 */

public class PasswordGUI
      extends JFrame {
   private static final long serialVersionUID = 8375595066259798834L;
   private final JPasswordField passwordField;

   /**
    * Create the frame.
    */
   private PasswordGUI() {
      setTitle("Show my password");
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      setBounds(100, 100, 482, 153);
      JPanel contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);

      passwordField = new JPasswordField();
      passwordField.setBounds(10, 11, 250, 30);
      contentPane.add(passwordField);

      JButton btnNewButton = new JButton("Show Me!");
      btnNewButton.setBounds(273, 11, 159, 30);
      contentPane.add(btnNewButton);

      JLabel lblNewLabel = new JLabel("");
      lblNewLabel.setBounds(10, 52, 250, 30);
      contentPane.add(lblNewLabel);

      btnNewButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            lblNewLabel.setText(new String(passwordField.getPassword()));
            passwordField.setText("");
         }
      });
      JButton btnPopup = new JButton("Show Me as Popup!");
      btnPopup.setBounds(273, 53, 159, 30);
      contentPane.add(btnPopup);
      btnPopup.addActionListener(e -> {
         int i = JOptionPane.showConfirmDialog(contentPane, "Password: "+String.valueOf(passwordField.getPassword()));
         if(i==JOptionPane.OK_OPTION)
            System.out.println("Clicked OK on popup");
      });

      btnNewButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            lblNewLabel.setText(new String(passwordField.getPassword()));
            passwordField.setText("");
         }
      });
      passwordField.addKeyListener(new KeyAdapter() {
         @Override
         public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
               lblNewLabel.setText(new String(passwordField.getPassword()));
               passwordField.setText("");
            }
         }
      });
   }

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(() -> {
         try {
            PasswordGUI frame = new PasswordGUI();
            frame.setVisible(true);
         } catch (Exception e) {
            e.printStackTrace();
         }
      });
   }
}

