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

import java.util.Random;
/**
 *  the class {@code Cells} contains all operations in finding possible combinations of all sudoku cells
 * @author kelli
 */
public class Cells {
    //solution contains single number in each cell, toned down from the possibilities;

     int[][] solution = new int[9][9];

    /**
     * initializes the cell randomly
     */
    void initializeCell(){

        initialize(1);
        initialize(5);
        initialize(2);
        initialize(8);
        initialize(3);
        initialize(7);
        initialize(4);
        initialize(6);
        initialize(9);
    }

int count = 1;

    /**
     * finds appropriate spaces to put the number
     * @param num
     */
    public void initialize(int num){
        int cellGroup = 0;
       while(cellGroup <= 8){
            int row = getRandomNumber(9);
             if(solution[cellGroup][row]!=0){   // happens only when cell is not empty

                     do{ /*if(count <= 4) {
                         row = getRandomNumber(9);
                     }else */{
                         if (row == 8) {
                             row = 0;
                         } else {
                             row += 1;
                         }
                     }
                        // System.out.println("checking empty cell");
                         count++;
                     }while(solution[cellGroup][row]!=0);

             }

             if(isUsedInRow(cellGroup, row, num)){
                 do{
                  //   System.out.println("checking row " + row);
                     if(row == 6|| row == 7||row ==8) {
                         switch (row) {
                             case 6:
                                 row = 0;
                                 break;
                             case 7:
                                 row = 1;
                                 break;
                             case 8:
                                 row = 2;
                                 break;
                         }
                     }else{
                         row+=3;
                     }

                 }while(isUsedInRow(cellGroup, row, num));
             }

             if(isUsedInColumn(cellGroup, row, num)){
                 do{
                  //   System.out.println("checking column");
                     if(row == 2|| row == 5||row ==8) {
                         switch (row) {
                             case 2:
                                 row = 0;
                                 break;
                             case 5:
                                 row = 3;
                                 break;
                             case 8:
                                 row = 6;
                                 break;
                         }
                     }else{
                         row++;
                     }
                 }while(isUsedInColumn(cellGroup, row, num));
             }
             //   System.out.println("setting " +num);
             
            if(solution[cellGroup][row]== 0){ solution[cellGroup][row] = num;}


            cellGroup++;
            }//close cellgroup for loop



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
                        if(solution [i][a] == num){
                            return true;
                        }
                    }
                }else if(row == 1|| row == 4|| row ==7){
                    for (int a =1 ; a<=7; a+=3){
                        if(solution [i][a] == num){
                            return true;
                        }
                    }
                }else{
                    for (int a =2 ; a<=8; a+=3){
                        if(solution [i][a] == num){
                            return true;
                        }
                    }
                }
            }
        }else if(cellGroup==1 || cellGroup==4 || cellGroup==7){
            for(int i = 1; i<=7; i+=3){
                if(row == 0 || row ==3 || row==6){
                    for (int a =0 ; a<=6; a+=3){
                        if(solution [i][a] == num){
                            return true;
                        }
                    }
                }else if(row == 1|| row == 4|| row ==7){
                    for (int a =1 ; a<=7; a+=3){
                        if(solution [i][a] == num){
                            return true;
                        }
                    }
                }else{
                    for (int a =2 ; a<=8; a+=3){
                           if(solution [i][a] == num){
                                return true;
                            }
                    }
                }
            }
        }else if(cellGroup==2 || cellGroup==5 || cellGroup==8){
            for(int i = 2; i<=8; i+=3){
                if(row == 0 || row ==3 || row==6){
                    for (int a =0 ; a<=6; a+=3){
                        if(solution [i][a] == num){
                            return true;
                        }
                    }
                }else if(row == 1|| row == 4|| row ==7){
                    for (int a =1 ; a<=7; a+=3){
                        if(solution [i][a] == num){
                            return true;
                        }
                    }
                }else{
                    for (int a =2 ; a<=8; a+=3){
                        if(solution [i][a] == num){
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
                        if(solution [i][a] == num){
                            return true;
                        }
                    }
                }else if(row == 3|| row == 4|| row ==5){
                    for (int a =3 ; a<=5; a++){
                        if(solution [i][a] == num){
                            return true;
                        }
                    }
                }else{
                    for (int a =6 ; a<=8; a++){
                        if(solution [i][a] == num){
                            return true;
                        }
                    }
                }
            }

        }else if(cellGroup==3 || cellGroup==4 || cellGroup==5){
            for(int i = 3; i<=5; i++){
                if(row == 0 || row ==1 || row==2){
                    for (int a =0 ; a<=2; a++){
                        if(solution [i][a] == num){
                            return true;
                        }
                    }
                }else if(row == 3|| row == 4|| row ==5){
                    for (int a =3 ; a<=5; a++){
                        if(solution [i][a] == num){
                            return true;
                        }
                    }
                }else{
                    for (int a =6 ; a<=8; a++){
                        if(solution [i][a] == num){
                            return true;
                        }
                    }
                }
            }
        }else if(cellGroup==6 || cellGroup==7 || cellGroup==8){
            for(int i = 6; i<=8; i++){
                if(row == 0 || row ==1 || row==2){
                    for (int a =0 ; a<=2; a++){
                        if(solution [i][a] == num){
                            return true;
                        }
                    }
                }else if(row == 3|| row == 4|| row ==5){
                    for (int a =3 ; a<=5; a++){
                        if(solution [i][a] == num){
                            return true;
                        }
                    }
                }else{
                    for (int a =6 ; a<=8; a++){
                        if(solution [i][a] == num){
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
            if(solution [cellGroup][i] == num){
                return true;
            }
        }
        return false;
    }

    /**
     * finds a random number between 0 and
     * @param bound
     * @return the random number
     */
    public int getRandomNumber( int bound){
        Random random = new Random();
        return random.nextInt(bound);

    }



}
