package MainPackage;
import java.awt.*;
import javax.swing.*;


public class Main {
	
	private static JFrame jframe = null;
	
	private static void setUpUI()
	{
        jframe = new JFrame("SecureD");
        
        jframe.getContentPane().setBackground(Color.BLACK);
        jframe.setResizable(true);

        GridLayout gridLayout = new GridLayout(0, 2);
        jframe.setLayout(gridLayout);
        gridLayout.layoutContainer(jframe);
                
        JPanel leftPanel = new JPanel();
        //LeftSide leftSide = LeftSide.LeftSideInitializer(leftPanel);
        LeftSide leftSide = new LeftSide(leftPanel);
        jframe.add(leftPanel);
        
        JPanel rightPanel = new JPanel();
        //RightSide rightSide = RightSide.RightSideInitializer(rightPanel);
        RightSide rightSide = new RightSide(rightPanel);
        jframe.add(rightPanel);

        leftSide.getRightInstance(rightSide);

        jframe.setSize(1400, 700);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) throws Exception
	{	
		setUpUI();
        //ErrorPopUp.Instance.setMainFrame(jframe);
	}
}
