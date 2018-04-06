public class SpreadsheetLocation implements Location {
   private int row, col;
   
   @Override
   public int getRow() {
      // TODO Auto-generated method stub
      return this.row;
   }

   @Override
   public int getCol() {
      // TODO Auto-generated method stub
      return this.col;
   }
   
   //
   public SpreadsheetLocation(String Cell) {
      char letter = Character.toLowerCase(Cell.charAt(0));
      int coloumn = ((int)letter) - 97, roow = (Integer.parseInt(Cell.substring(1)) - 1);
      this.col = coloumn;
      this.row = roow;
   }
}