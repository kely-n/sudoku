/**
 *
 *  Use is subject to license terms.
 *  the following codes were written for academic purposes and is not subject to copyright, however any improvements made to
 *  the code, the owner must be informed. whatsapp 0706197445
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package sudoku;
/**
 *the class {@code GameEngine} is the main coordinator that runs the sudoku application.
 *
 * @author kelli
 */
public class GameEngine{
    /**
     * on calling an object of this class, an object of the class {@code Cells} is called and a full sudoku combination
     * is created.
     */
  public GameEngine(){
     cells.initializeCell();
      putBlanksInCell();
  }
public Cells cells = new Cells();
    public  int[][] initializedCell =new int[9][9];

    /**
     * gets random positions from the sudoku possible combinations created and stores them in an array {@code initializedCell}
     *
     */
    public void putBlanksInCell(){

            for (int a = 0; a<=8; a++) {
                for (int count = 0; count <= 2; count++) {
                    int b = cells.getRandomNumber(9);
                    do {
                        if (cells.solution[a][b] == 0) {
                            b = cells.getRandomNumber(9);
                        }
                    } while (cells.solution[a][b] == 0);
                    initializedCell[a][b] = cells.solution[a][b];
                }
            }

        }

    /**
     *
     * @return the initialized cell, one with blanks
     */
    public int[][] getInitializedCell(){
        return initializedCell;
    }

    /**
     * checks if a number is used in the:
     * @param cellGroup a combinations of 9cells
     * @param row
     * @param num
     * @return true if used
     */
    public boolean checkIfUsed(int cellGroup, int row, int num){
        if(isUsedInColumn(cellGroup, row, num)){
            return true;
        }
        if(isUsedInRow(cellGroup, row, num)){
            return true;
        }
        if(isUsedInCellGroup(cellGroup, num)){
            return true;
        }

        return false;
    }

    /**
     *
     * @param cellGroup the initial cell group
     * @param row initial row
     * @param num number being checked
     * @return
     */
    private boolean isUsedInColumn(int cellGroup, int row, int num){  //------>confirms if number is used in the column
        if(cellGroup == 0 || cellGroup == 3 || cellGroup ==6){
            for(int i = 0; i<=6; i+=3){
                if(row == 0 || row ==3 || row==6){
                    for (int a =0 ; a<=6; a+=3){
                        if(initializedCell [i][a] == num){
                            return true;
                        }
                    }
                }else if(row == 1|| row == 4|| row ==7){
                    for (int a =1 ; a<=7; a+=3){
                        if(initializedCell [i][a] == num){
                            return true;
                        }
                    }
                }else{
                    for (int a =2 ; a<=8; a+=3){
                        if(initializedCell [i][a] == num){
                            return true;
                        }
                    }
                }
            }
        }else if(cellGroup==1 || cellGroup==4 || cellGroup==7){
            for(int i = 1; i<=7; i+=3){
                if(row == 0 || row ==3 || row==6){
                    for (int a =0 ; a<=6; a+=3){
                        if(initializedCell [i][a] == num){
                            return true;
                        }
                    }
                }else if(row == 1|| row == 4|| row ==7){
                    for (int a =1 ; a<=7; a+=3){
                        if(initializedCell [i][a] == num){
                            return true;
                        }
                    }
                }else{
                    for (int a =2 ; a<=8; a+=3){
                        if(initializedCell [i][a] == num){
                            return true;
                        }
                    }
                }
            }
        }else if(cellGroup==2 || cellGroup==5 || cellGroup==8){
            for(int i = 2; i<=8; i+=3){
                if(row == 0 || row ==3 || row==6){
                    for (int a =0 ; a<=6; a+=3){
                        if(initializedCell [i][a] == num){
                            return true;
                        }
                    }
                }else if(row == 1|| row == 4|| row ==7){
                    for (int a =1 ; a<=7; a+=3){
                        if(initializedCell [i][a] == num){
                            return true;
                        }
                    }
                }else{
                    for (int a =2 ; a<=8; a+=3){
                        if(initializedCell [i][a] == num){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    /**
     *
     * @param cellGroup the initial cell group
     * @param row initial row
     * @param num number being checked
     * @return
     */
    private boolean isUsedInRow(int cellGroup, int row, int num){//---------------------->> confirms if used in row
        //  System.out.println("checking row");
        if(cellGroup == 0 || cellGroup == 1 || cellGroup ==2){
            for(int i = 0; i<=2; i++){
                if(row == 0 || row ==1 || row==2){
                    for (int a =0 ; a<=2; a++){
                        if(initializedCell [i][a] == num){
                            return true;
                        }
                    }
                }else if(row == 3|| row == 4|| row ==5){
                    for (int a =3 ; a<=5; a++){
                        if(initializedCell [i][a] == num){
                            return true;
                        }
                    }
                }else{
                    for (int a =6 ; a<=8; a++){
                        if(initializedCell [i][a] == num){
                            return true;
                        }
                    }
                }
            }

        }else if(cellGroup==3 || cellGroup==4 || cellGroup==5){
            for(int i = 3; i<=5; i++){
                if(row == 0 || row ==1 || row==2){
                    for (int a =0 ; a<=2; a++){
                        if(initializedCell [i][a] == num){
                            return true;
                        }
                    }
                }else if(row == 3|| row == 4|| row ==5){
                    for (int a =3 ; a<=5; a++){
                        if(initializedCell [i][a] == num){
                            return true;
                        }
                    }
                }else{
                    for (int a =6 ; a<=8; a++){
                        if(initializedCell [i][a] == num){
                            return true;
                        }
                    }
                }
            }
        }else if(cellGroup==6 || cellGroup==7 || cellGroup==8){
            for(int i = 6; i<=8; i++){
                if(row == 0 || row ==1 || row==2){
                    for (int a =0 ; a<=2; a++){
                        if(initializedCell [i][a] == num){
                            return true;
                        }
                    }
                }else if(row == 3|| row == 4|| row ==5){
                    for (int a =3 ; a<=5; a++){
                        if(initializedCell [i][a] == num){
                            return true;
                        }
                    }
                }else{
                    for (int a =6 ; a<=8; a++){
                        if(initializedCell [i][a] == num){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    /**
     *
     * @param cellGroup the initial cell group
     * @param num number being checked
     * @return
     */
    private boolean isUsedInCellGroup(int cellGroup,  int num){
        for (int i = 0; i<=8; i++){
            if(initializedCell [cellGroup][i] == num){
                return true;
            }
        }
        return false;
    }
}
