public class FormulaCell extends RealCell{
   private Spreadsheet sheet;
   private String formula, abbrev;
   private double y;
   
   public FormulaCell(String value){
      super(value);
      this.formula = value;
      doFormula(formula);
      this.abbrev = Spreadsheet.spaceAdder(this.y + " ");
      
   }
   
   public String abbreviatedCellText(){
      return abbrev;
   }
      
   public String fullCellText(){
      return this.formula;
   }
   
   public void doFormula(String x){
      int formulaLength = 0;  
      if(x.contains(" ")){
         String[] formula = x.split(" ");
         formulaLength = 1 + (formula.length - 3);
         for(int i = 1; i <= formulaLength; i++){
            if( i <= 2 ){
               if(formula[i].contains("+")){
                  this.y = Double.parseDouble(formula[i - 1]) + Double.parseDouble(formula[i + 1]);
               }
               else if(formula[i].contains("-")){
                  this.y = Double.parseDouble(formula[i - 1]) - Double.parseDouble(formula[i + 1]);
               }
               else if(formula[i].contains("*")){
                  this.y = Double.parseDouble(formula[i - 1]) * Double.parseDouble(formula[i + 1]);
               }
               else if(formula[i].contains("/")){
                  this.y = Double.parseDouble(formula[i - 1]) / Double.parseDouble(formula[i + 1]);
               }
            }
            else{
               if(formula[i].contains("+")){
                  this.y = this.y + Double.parseDouble(formula[i + 1]);
               }
               else if(formula[i].contains("-")){
                  this.y = this.y - Double.parseDouble(formula[i + 1]);
               }
               else if(formula[i].contains("*")){
                  this.y = this.y * Double.parseDouble(formula[i + 1]);
               }
               else if(formula[i].contains("/")){
                  this.y = this.y / Double.parseDouble(formula[i + 1]);
               }
            }
         }
      }
   }
}