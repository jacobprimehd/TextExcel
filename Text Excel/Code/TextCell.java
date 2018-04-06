public class TextCell implements Cell {
   private String value, abbreviate;
   
   
   public TextCell(String value){
      this.value = value;
      this.abbreviate = Spreadsheet.spaceAdder(value);
   }
   public String abbreviatedCellText() {
      String abbreviated = abbreviate.substring(0,10);
      return abbreviated;
   }
   
   public String fullCellText() {
      return "\"" + this.value + "\"";
   }
}