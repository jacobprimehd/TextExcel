public class EmptyCell implements Cell {
   //Variables
   private String abbrevlength ="          ", length = "";
   
   //Constructor 
   public EmptyCell(){
   }
   
   //Mutators
   public String fullCellText() {
      return this.length;
   }
   
   public String abbreviatedCellText() {
      return this.abbrevlength;
   }
   
}