import java.awt.*;
import javax.swing.*;


public class Main {
	
	public static void main(String[] args) throws Exception
	{	
        JFrame jframe = new JFrame();

        jframe.getContentPane().setBackground(Color.BLACK);
        jframe.setTitle("Title");
        jframe.setResizable(true);

        GridLayout gridLayout = new GridLayout(0, 2);
        jframe.setLayout(gridLayout);
        gridLayout.layoutContainer(jframe);
        
        JPanel leftPanel = new JPanel();
        LeftSide leftSide = LeftSide.LeftSideInitializer(leftPanel);
        jframe.add(leftPanel);
        
        JPanel rightPanel = new JPanel();
        RightSide rightSide = RightSide.RightSideInitializer(rightPanel);
        jframe.add(rightPanel);

        leftSide.getRightInstance(rightSide);

        jframe.setSize(1400, 700);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
