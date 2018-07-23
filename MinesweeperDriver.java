//Torbert, e-mail: mr@torbert.com, website: www.mr.torbert.com
//version 7.14.2003
import javax.swing.JFrame;
import javax.swing.JPanel;
public class MinesweeperDriver
{
   public static void main(String[] args)
   {
      setLayout(new BorderLayout());
      
      JFrame frame = new JFrame("Final Project: Minesweeper!");
      JPanel panel = new JPanel();
      frame.setSize(1600, 1600);
      frame.setLocation(0, 0);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      JPanel panel = new JPanel();
      add(panel);
      panel.setLayout( new GridLayout(10,10));
      
      JLabel menu = new Jlabel("Menu");
      add(menu, BorderLayout.NORTH);
      
      JButton beginner = new JButton("Beginner");
      panel.add(beginner, GridLayout(0, 5));
      
      
      
      
      frame.setContentPane(new Minesweeper());
      frame.setVisible(true);
   }
}
