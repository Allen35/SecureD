package MainPackage;
import java.awt.*;
import javax.swing.*;

import com.formdev.flatlaf.FlatDarkLaf;


public class Main {
	
	private JFrame jframe = null;
	
	private void setUpLookAndFeel()
	{
		try {
		    UIManager.setLookAndFeel( new FlatDarkLaf() );
		} catch( Exception ex ) {
		    System.err.println( "Failed to initialize LaF" );
		}
	}
	private void setUpUI()
	{
        jframe = new JFrame("SecureD");
        
        jframe.getContentPane().setBackground(Color.BLACK);
        jframe.setResizable(true);

        GridLayout gridLayout = new GridLayout(0, 2);
        jframe.setLayout(gridLayout);
        gridLayout.layoutContainer(jframe);
        
        JPanel rightPanel = new JPanel();
        //RightSide rightSide = RightSide.RightSideInitializer(rightPanel);
        RightSide rightSide = new RightSide(rightPanel);
		        
		JPanel leftPanel = new JPanel();
		//LeftSide leftSide = LeftSide.LeftSideInitializer(leftPanel);
		LeftSide leftSide = new LeftSide(leftPanel);

        jframe.add(leftPanel);
        jframe.add(rightPanel);

        leftSide.setRightInstance(rightSide);

        jframe.setSize(1400, 700);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) throws Exception
	{	
		Main m = new Main();
		
		m.setUpLookAndFeel();
		m.setUpUI();
	}
}
