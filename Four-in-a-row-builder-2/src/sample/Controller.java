package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable{
    Point[][]  grid;
    int player = 1;

    @FXML
    Button button0,button1,button2,button3,button4,button5,button6;
    @FXML
    Label playerTurn;
    @FXML
    Canvas canvasID;
    @FXML
    GraphicsContext gc;


    public void initiateGame(){
        gc = canvasID.getGraphicsContext2D();
        grid = new Point[7][6];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                grid[i][j] = new Point(i,j,0);
            }
        }
    }


    public void addPieceToRow(int columnNumber) {

        for (int i = 5; i >= 0; i--) {
            if (grid[columnNumber][i].colorValue == 0) {
                grid[columnNumber][i].colorValue = player;

                break;

            }

        }


        if (player == 1) {
            player = 2;
            playerTurn.setText("Player 2");
            playerTurn.setTextFill(Color.RED);
        } else if (player == 2) {
            player = 1;
            playerTurn.setText("Player 1");
            playerTurn.setTextFill(Color.BLUE);

        }
        checkWin();
    }


        public void pressentBoard() {       //kun til at vise i console
            for (int i = 0; i < 6; i++) {   // hvis bord på den rigtigt måde
                for (int j = 0; j < 7; j++) {
                    System.out.print(grid[j][i].colorValue);

                }
                System.out.println();
            }
                System.out.println("Turn: Player " + player);
            System.out.println();
        }

    public void checkWin(){
        int redsInARow = 0;
        int bluesInARow = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if(grid[i][j].colorValue == 1){
                    bluesInARow++;
                    redsInARow = 0;
                } else if(grid[i][j].colorValue == 2){
                    redsInARow++;
                    bluesInARow = 0;
                }
                if(redsInARow == 4 || bluesInARow == 4){
                    System.out.println("Player"+player+" Lose try again!");
                    playerTurn.setText("Player "+player+" Lose try again!");

                }
            }

        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if(grid[j][i].colorValue == 1){
                    bluesInARow++;
                    redsInARow = 0;
                } else if(grid[j][i].colorValue == 2){
                    redsInARow++;
                    bluesInARow = 0;
                }
                if(redsInARow == 4 || bluesInARow == 4){
                    System.out.println("Player"+player+" Lose try again!");
                    playerTurn.setText("Player "+player+" Lose try again!");

                }
            }

        }

    }

    public void drawBoard(){
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if(grid[i][j].colorValue == 0) {
                    gc.setFill(Color.GREY);
                    gc.fillOval(i*80,j*80,60,60);
                }
                if(grid[i][j].colorValue == 1) {
                    gc.setFill(Color.BLUE);
                    gc.fillOval(i*80,j*80,60,60);
                }
                if(grid[i][j].colorValue == 2) {
                    gc.setFill(Color.RED);
                    gc.fillOval(i*80,j*80,60,60);
                }
            }
        }
    }
    public void resetGame(){
        grid = new Point[7][6];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                grid[i][j] = new Point(i,j,0);

                if(grid[i][j].colorValue == 0) {
                    gc.setFill(Color.GREY);
                    gc.fillOval(i*80,j*80,60,60);
                }
                playerTurn.setText("Player" +player);

            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initiateGame();
        drawBoard();
        pressentBoard();

    }

    public void actB6(ActionEvent actionEvent) {
        addPieceToRow(6);
        pressentBoard();
        drawBoard();
    }
    public void actB5(ActionEvent actionEvent) {
        addPieceToRow(5);
        pressentBoard();
        drawBoard();
    }
    public void actB4(ActionEvent actionEvent) {
        addPieceToRow(4);
        pressentBoard();
        drawBoard();
    }
    public void actB3(ActionEvent actionEvent) {
        addPieceToRow(3);
        pressentBoard();
        drawBoard();
    }
    public void actB2(ActionEvent actionEvent) {
        addPieceToRow(2);
        pressentBoard();
        drawBoard();
    }
    public void actB1(ActionEvent actionEvent) {
        addPieceToRow(1);
        pressentBoard();
        drawBoard();
    }
    public void actB0(ActionEvent actionEvent) {
        addPieceToRow(0);
        pressentBoard();
        drawBoard();
    }

}
