public class ValueCell extends RealCell{
   public String value,abbrev;
   private double value2;
   
   public ValueCell(String value){
      super(value);
      this.abbrev = Spreadsheet.spaceAdder(value);
      this.value2 = Double.parseDouble(value); 
   }
   
   public String abbreviatedCellText(){
      return abbrev.substring(0,10);
   }
      
   public String fullCellText(){
      return value2 +"";
   }
   
   public double getDoubleValue(){
      return value2;
   }
}