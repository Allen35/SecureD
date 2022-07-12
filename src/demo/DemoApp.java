// Copyright 2020 Kalkidan Betre Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package demo;

import customjframe.CustomJFrame;
import customjframe.WindowFrameType;
import theme.DarkTheme;
import theme.Theme;

import javax.swing.*;
import java.awt.*;


public class DemoApp {
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            try {
               UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
               e.printStackTrace();
            }

            final Theme darkTheme = new DarkTheme();
            CustomJFrame rootFrame = new CustomJFrame(darkTheme ,"Custom Decorated Window", WindowFrameType.NORMAL);

            JPanel rootPanel = new JPanel();
            //This creates one row and two equally divided columns
            GridLayout gridLayout = new GridLayout(1, 2);
            rootPanel.setLayout(gridLayout);
            gridLayout.layoutContainer(rootPanel);

            JPanel leftPanel = new JPanel();
            leftPanel.add(new Label("Left side"));
            rootPanel.add(leftPanel);

            JPanel rightPanel = new JPanel();
            rightPanel.add(new Label("Right side"));
            rootPanel.add(rightPanel);
            
            rootFrame.add(rootPanel);
            
            rootFrame.setMinimumSize(new Dimension(600, 400));
            rootFrame.setLocationRelativeTo(null);
            rootFrame.setVisible(true);

         }
      });
   }
}

