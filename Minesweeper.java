	//Name______________________________ Date_____________
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Minesweeper extends JPanel
{
   private JButton[][] board;
   private JButton easy,medium,hard;
   private int[][] matrix;
   private JLabel label;
   private JButton reset;
   public Minesweeper()
   {
      setLayout(new BorderLayout());
   
    
      
      JPanel north = new JPanel();
      north.setLayout(new FlowLayout());
      add(north, BorderLayout.NORTH);
      label = new JLabel("Welcome to Minesweeper!");
      north.add(label);
      JPanel center = new JPanel();
      center.setLayout(new GridLayout(10,10));
      add(center, BorderLayout.CENTER);
      
      board = new JButton[20][20];
      matrix = new int[20][20];
      for(int r = 0; r < 20; r++)
         for(int c = 0; c < 20; c++)
         {
            board[r][c] = new JButton();
            board[r][c].setBackground(Color.blue);
            board[r][c].addActionListener( new Handler1(r, c) );
            center.add(board[r][c]);
         }
      
      reset = new JButton("Reset");
      reset.addActionListener( new Handler2() );
      reset.setEnabled(false);
      add(reset, BorderLayout.SOUTH);
      
      placeBombs();
   }
   private void placeBombs()
   {
      {
        
           
         for (int x = 0; x < 20; x++)
         {
            int r = (int)(Math.random() * 19);
            int c = (int)(Math.random() * 19);
            matrix[r][c] = 1;
         }
         
      
      }
   }
   public void paintComponent (Graphics g)
   {
      ImageIcon i = new ImageIcon("mine.jpg");
      g.drawImage(i.getImage(), 0,0,1600,1600, null);
      g.setColor(Color.BLUE);
   
      g.setFont(new Font("Serif", Font.BOLD, 50));
      g.setColor(new Color(255,255,255));
      g.drawString("Minesweeper!", 400, 400);
   }
   private class Handler1 implements ActionListener
   {
      private int myRow, myCol;
      public Handler1(int r, int c)
      {
         myRow = r;
         myCol = c;
      }
      public void actionPerformed(ActionEvent e)
      {
      
         if(matrix[myRow][myCol]==1)
         {
            label.setText("You Lose!");
            
            board[myRow][myCol].setBackground(Color.red);
            board[myRow][myCol].setEnabled(false);
           
         }
         else
         {
          
           
            board[myRow][myCol].setBackground(Color.white);
         
         }
         
      
                     
      }
   }
   private class Handler2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         
         
         placeBombs();
         for(int r = 0; r < 10; r++)
            for(int c = 0; c < 10; c++)
            {
            
               board[r][c].setBackground(Color.blue);
            
            }
      
      }
   }
}
