// Save this as MineSweeper.java
// compile with this command
// javac MineSweeper.java
// then run with this command
// java MineSweeper

// We need this for random numbers.
import java.util.Random;

class Mine {
   int mWidth = 30; // width of the minefield
   int mHeight = 16; // height of the minefield
   int mMines = 99; // number of mines
   char[][] mMinefield; // 2-dimensional array of chars for our board

   public Mine() {
      System.out.println("Generating minefield...");
   
      mMinefield = new char[mHeight][mWidth];
   
      System.out.println("Clearing minefield...");
   
      clearMinefield();
   
      System.out.println("Placing mines...");
   
      placeMines();
      drawMinefield();
   
      System.out.println("Calculating hints...");
   
      calculateHints();
      drawMinefield();
   }

   public void placeMines() {
      int minesPlaced = 0;
      Random random = new Random(); // this generates random numbers for us
      while(minesPlaced < mMines) {
         int x = random.nextInt(mWidth); // a number between 0 and mWidth - 1
         int y = random.nextInt(mHeight);
         // make sure we don't place a mine on top of another
         if(mMinefield[y][x] != '*') {
            mMinefield[y][x] = '*';
            minesPlaced ++;
         }
      }
   }

   public void clearMinefield() {
      // Set every grid space to a space character.
      for(int y = 0; y < mHeight; y ++) {
         for(int x = 0; x < mWidth; x ++) {
            mMinefield[y][x] = ' ';
         }
      }
   }

   public void drawMinefield() {
      for(int y = 0; y < mHeight; y ++) {
         for(int x = 0; x < mWidth; x ++) {
            System.out.print(mMinefield[y][x]);
         }
         System.out.print("\n");
      }
   }

   public void calculateHints() {
      for(int y = 0; y < mHeight; y ++) {
         for(int x = 0; x < mWidth; x ++) {
            if(mMinefield[y][x] != '*') {
               mMinefield[y][x] = minesNear(y, x);
            }
         }
      }
   }

   public char minesNear(int y, int x) {
      int mines = 0;
      // check mines in all directions
      mines += mineAt(y - 1, x - 1);  // NW
      mines += mineAt(y - 1, x);      // N
      mines += mineAt(y - 1, x + 1);  // NE
      mines += mineAt(y, x - 1);      // W
      mines += mineAt(y, x + 1);      // E
      mines += mineAt(y + 1, x - 1);  // SW
      mines += mineAt(y + 1, x);      // S
      mines += mineAt(y + 1, x + 1);  // SE
      if(mines > 0) {
         // we're changing an int to a char
         // why?!
         // http://www.asciitable.com/
         // 48 is ASCII code for '0'
         return (char)(mines + 48);
      } else {
         return ' ';
      }
   }

   // returns 1 if there's a mine a y,x or 0 if there isn't
   public int mineAt(int y, int x) {
      // we need to check also that we're not out of array bounds as that would
      // be an error
      if(y >= 0 && y < mHeight && x >= 0 && x < mWidth && mMinefield[y][x] == '*') {
         return 1;
      } else {
         return 0;
      }
   }

   // this starts the command line application
   public static void main(String[] args) {
      Mine mineSweeper = new Mine();
   }
}