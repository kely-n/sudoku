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

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * the main javaFx file of the sudoku program
 * @author kelli
 */

public class Sudoku extends Application implements EventHandler<ActionEvent> {

    String howToPlay = "\n  \n ABOUT: \n--> \tSudoku is a game of numbers, make sure each 9 cell group has a number from 1 to 9 " +
            "without repeating a number. \n-->>\tSame to each row and column. Any repeated number is highlighted red" +
            "\n \n CONTROLS:\n--> \tleft click once to add 1 to a cell twice to add 2, thrice to add 3 and so on\n" +
            "--> \tright click to delete number in a cell\n" +
            "--> \tselect New Game to get started\n" +
            "\n \nfor any contributions or improvements whatsapp 0706197445" +
            "\n \nGOOD LUCK PLAYER!"
            ;
    VBox menu = new VBox();
    VBox mainSudokuBoX = new VBox();
    Label intro = new Label(howToPlay);
    VBox sudoku_box = new VBox();
    Button refresh = new Button("New Game");
    Button resume = new Button ("Resume");
    Button help = new Button("how to play");
    Button copyright = new Button("Copyright");
    Button exit = new Button("exit");
    int count = 0;
    @Override
    public void start(Stage primaryStage)  {


        Group root = new Group();
        Scene mainPage = new Scene(root);


        VBox mainBox = new VBox();
        HBox subMain = new HBox();




        menu.getChildren().addAll(refresh,  help, exit);
        exit.getStyleClass().add("exit");
        exit.setOnAction(this);
        exit.setPrefSize(250, 80);
        copyright.setPrefSize(250, 80);
        help.setPrefSize(250, 80);
        help.getStyleClass().add("menuButton");
        help.setOnAction(this);
        refresh.setPrefSize(250, 80);
        refresh.getStyleClass().add("menuButton");
        refresh.setOnAction(this);
        resume.setPrefSize(250, 80);
        resume.getStyleClass().add("menuButton");
        resume.setOnAction(this);

        //-------------------------------------------------------------------------------------------------->> setting up the sudoku box



         //------------------------------------------------------------------------------------------------->> setting up sudoku box ends here

        //________________________________TITLE___________________________________________

        Label title = new Label("SUDOKU");
               title.getStyleClass().add("title");
        mainBox.getChildren().add(title);

        intro.setMaxWidth(500);
        intro.setWrapText(true);
        intro.getStyleClass().add("paragraphs");
        //____________________________TITLE ENDS HERE______________________________________
        //applying css stylesheet to the program
      /* Application.setUserAgentStylesheet(getClass()
                .getResource("stylesheet.css")
                .toExternalForm());*/


    //setting up the main sudoku box
      sudoku_box.getStyleClass().add("sudoku_box");
        sudoku_box.getChildren().add(intro);
        mainPage.getStylesheets().add(getClass()
        .getResource("stylesheet.css")
        .toExternalForm());
        //--------->> displaying the window
        subMain.getChildren().addAll(menu, sudoku_box);
        mainBox.getChildren().add(subMain);
        mainBox.setPrefSize(900,800);
        mainBox.getStyleClass().add("root");
        root.getChildren().add(mainBox);
        primaryStage.setTitle("Sudoku");
        primaryStage.setScene(mainPage);

        primaryStage.setResizable(false);
        primaryStage.setWidth(900);
        primaryStage.setHeight(800);
        primaryStage.show();

    }
    @Override
    public void handle(ActionEvent event) {
        if (event.getSource()==refresh)
        {
            sudoku_box.getChildren().clear();
            setupTable();
            menu.getChildren().clear();
            menu.getChildren().addAll(refresh,  help, exit);
        }if (event.getSource()==exit)
        {
            System.exit(0);
        }
        if (event.getSource()==help)
        {
            sudoku_box.getChildren().clear();
            sudoku_box.getChildren().add(intro);
            if(count != 0) {
                menu.getChildren().clear();
                menu.getChildren().addAll(resume, refresh, help, exit);
            }
        }
        if (event.getSource()==resume)
        {
            sudoku_box.getChildren().clear();
            sudoku_box.getChildren().add(mainSudokuBoX);
            menu.getChildren().clear();
            menu.getChildren().addAll(refresh,  help, exit);
        }
    }

    int num;
    private void setupTable(){
        GameEngine gameEngine = new GameEngine();
        Sudoku gameFace = new Sudoku();
        count++;
        mainSudokuBoX.getChildren().clear();
        int cellGroup = 0; int cell = 0;

        for (int a = 0; a <=2; a++){                              //------------->> main row loop, creates 3 main horizantal rows in the sudoku box
            HBox main_row  = new HBox();
            for (int b = 0; b<=2; b++){
                VBox main_cell_group = new VBox();              //-------->> main cell group loop, creates 3 main  vertical columns in each main row

                for(int c = 0; c<=2; c++){                      //----------->>mini row group, creates 3 horizontal cell groups of 3 in each main cell group
                    HBox hbox = new HBox();
                    for(int d = 0; d <= 2; d++){      //-------->>    cell loop, creates 3 cell buttons in each hbox. this is the final loop
                        int number = gameEngine.getInitializedCell()[cellGroup][cell];
                        if(number != 0) {
                            Button button = new Button(String.valueOf(number));
                            button.getStyleClass().add("finalButtonKeys");
                            button.setPrefSize(60, 60);

                            hbox.getChildren().add(button);
                            cell+=1;
                        }
                        else {
                            Button button = new Button(" ");
                            button.setOnAction(this);
                            button.getStyleClass().add("buttonKeys");
                            button.setPrefSize(60, 60);
                            button.setUserData(cell);
                            hbox.setUserData(cellGroup);
                            hbox.getChildren().add(button);
                            cell+=1;
                            button.setOnMouseClicked(event -> {
                                if(event.getButton()== MouseButton.PRIMARY){
                                    String text = button.getText();
                                    if(text.equals("1") || text.equals("2") || text.equals("3") ||
                                            text.equals("4") || text.equals("5") || text.equals("6") ||
                                            text.equals("7") || text.equals("8") ) {
                                        num = Integer.valueOf(text)+1;

                                    }else {
                                        num = 1;
                                    }
                                    if(gameEngine.checkIfUsed((Integer) hbox.getUserData(), (Integer)button.getUserData(), num)){
                                       // System.out.println((Integer) hbox.getUserData()+" "+ (Integer)button.getUserData()+" "+ num);
                                        button.setStyle("-fx-text-fill: red");
                                    }else
                                    {
                                        button.setStyle("-fx-text-fill: white");
                                        gameEngine.initializedCell[(Integer) hbox.getUserData()][(Integer) button.getUserData()] = num;
                                    }
                                    button.setText(String.valueOf(num));
                                }if(event.getButton()==MouseButton.SECONDARY){
                                    button.setText(" ");
                                    gameEngine.initializedCell[(Integer) hbox.getUserData()][(Integer) button.getUserData()] = 0;
                                }
                            });
                        }


                    }
                    main_cell_group.getChildren().add(hbox);
                    main_cell_group.getStyleClass().add("cellGroup");
                    if(gameFace.cellGroupIsFull(c)){
                        cellGroup+=1;
                        cell = 0;
                    }
                }
                main_row.getChildren().add(main_cell_group);
            }
            mainSudokuBoX.getChildren().add(main_row);
        }
        sudoku_box.getChildren().add(mainSudokuBoX);
    }
    public static void main(String[] args) {

        launch(args);
    }
         private boolean cellGroupIsFull(int i){ if (i==2) {return true;} return false; }    //checks if cellgroup is full;


}
