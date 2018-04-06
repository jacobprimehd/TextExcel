public class RealCell implements Cell {
   private String value,abbrev;
   
   
   public RealCell(String value){
      this.value = value;
      this.abbrev = Spreadsheet.spaceAdder(value);
   }
   
   public String abbreviatedCellText(){
      return abbrev.substring(0,10);
   }
      
   public String fullCellText(){
      return value;
   }
}