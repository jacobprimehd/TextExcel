// Update this file with your own code.

public class Spreadsheet implements Grid {
   private static int rows = 20, col = 12;
   private Cell[][] data;
   private static Cell empty = new EmptyCell();
   
   public Spreadsheet() {
      this.data = new Cell[rows][col];
      clearAll();
   }
   
   
   //formulaCell fe = new FormulaCell(--,this) this is for later on checkpoints for formula Cell   
	@Override
	public String processCommand(String command) {
		String input = "", clear = command.toLowerCase();
      //formulaCell fe = new FormulaCell(--,this) this is for later on checkpoints for formula Cell
      if(command.length() > 0){
         if(command.contains("=")){
            String location = command.substring(0, command.indexOf("=")-1).toUpperCase();
            SpreadsheetLocation loc = new SpreadsheetLocation(location);
            if(command.contains("\"")){ // Gets the String with Chars
               String string = command.substring(command.indexOf("\"") + 1,command.length() - 1); 
               data[loc.getRow()][loc.getCol()] = new TextCell(string);
               return getGridText();
            }
            if(command.contains("%")){
               String string = command.substring(command.indexOf("=") + 2, command.length() - 1);
               data[loc.getRow()][loc.getCol()] = new PercentCell(string);
               return getGridText();
            }
            if(command.contains("(")){
               String string = command.substring(command.indexOf("("), command.length());
               data[loc.getRow()][loc.getCol()] = new FormulaCell(string);
               return getGridText();
            }
            else { // Gets the String but with numbers
               String string = command.substring(command.indexOf("=") + 2,command.length()); 
               data[loc.getRow()][loc.getCol()] = new ValueCell(string);
               return getGridText();
            }
         }
         else if(clear.contains("clear")){
            if(command.length() != 5){
               String location = command.substring(command.indexOf("r") + 2, command.length());
               SpreadsheetLocation loc = new SpreadsheetLocation(location);
               data[loc.getRow()][loc.getCol()] = empty;
               return getGridText();
            }
            else{
               clearAll(); 
               return getGridText();
            }  
         }
         else{
            SpreadsheetLocation loc = new SpreadsheetLocation(command);
            input = data[loc.getRow()][loc.getCol()].fullCellText();
         }
      }
      return input;
	}
   
   

	@Override
	public int getRows() {
		return data.length;
	}
   
   

	@Override
	public int getCols() {
		if ( data.length <= 0) {
		   return 0;
      }
      return data[0].length;
	}
   
   

	@Override
	public Cell getCell(Location loc) {
		if (loc.getRow() < 0 || loc.getRow() >= getRows() ||
			loc.getCol() < 0 || loc.getCol() >= getCols()) {
			return null;
		}
      return data[loc.getRow()][loc.getCol()];
	}
   
   

	@Override
	public String getGridText() {
      String cells = "   |A         |B         |C         |D         |E         |F         |G         |H         |I         |J         |K         |L         |\n";
		for(int row = 0; row < this.rows; row++){
         if(row < 9){
         cells += (row + 1) + "  |";
         }
         else{
         cells += (row + 1) + " |";
         }
         for(int col = 0; col < this.col; col++) {
            cells += data[row][col].abbreviatedCellText() + "|";
         }
         cells += "\n";
      }
		return cells;
	}
   
   
   public void clearAll() {
      for(int row = 0; row < this.rows; row++){
         for(int col = 0; col < this.col; col++) {
            data[row][col] = empty;
         }
      }
   }
   
   
   public static String spaceAdder(String x){
      int length = x.length();
      //x = x.substring( 1, x.length() - 1);
      if(length <= 10){
         for(int k = length; k < 10; k++){
            x += " ";
         }
      }
      return x;
   }

}