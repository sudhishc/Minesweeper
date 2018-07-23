import javax.swing.*;
import java.awt.*;
public class MinesweeperPanel extends JPanel
{
   public void paintComponent (Graphics g)
   {
      ImageIcon i = new ImageIcon("mine.jpg");
      g.drawImage(i.getImage(), 0,0,1600,1600, null);
      g.setColor(Color.BLUE);
   
      g.setFont(new Font("Serif", Font.BOLD, 50));
      g.setColor(new Color(255,255,255));
      g.drawString("Minesweeper!", 400, 400);
   }
}