package stu_109504501.A11_109504501;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class GameController implements EventHandler<KeyEvent> {
    int rowIndex = 0;
    int columnIndex = 0;
    int rowIndex2 = 0;
    int columnIndex2 = 0;

    @FXML
    GridPane game;
    @FXML
    Pane snake_head;
    @FXML
    Pane snake_tail;
    @FXML
    Label label;
    @FXML
    Button button_back;

    @FXML
    public void onBackPressed(){
        HelloApplication.currentStage.setScene(HelloApplication.menuScene);
    }

    int count = 0;
    int no = 0;
    @Override
    public void handle(KeyEvent e){
        label.setText("");
        if(e.getCode() == KeyCode.SPACE){
            rowIndex = 0;
            columnIndex = 0;
            rowIndex2 = 0;
            columnIndex2 = 0;
            count = 0;
            no = 0;
        }
        else if(rowIndex == 4 && columnIndex == 4){
            label.setText("移動到出口了！！！");
        }
        else if(e.getCode() == KeyCode.DOWN){

            // if the first move is DOWN
            if(count == 0){
                rowIndex2 = 0;
                count++;
                rowIndex++;
            }
            else if(rowIndex == 4){
                no++;
                if(no > 0){
                    label.setText("你輸了！！！");
                    rowIndex = 4;
                    rowIndex2 = 3;
                }
            }
            else if(rowIndex > rowIndex2){
                rowIndex2++;
                rowIndex++;
            }
            else if(columnIndex > columnIndex2){
                columnIndex2++;
                rowIndex++;
            }
            else if(columnIndex < columnIndex2){
                columnIndex2--;
                rowIndex++;
            }

            if(rowIndex == 4 && columnIndex == 4){
                label.setText("移動到出口了！！！");
            }
        }
        else if(e.getCode() == KeyCode.UP){

            if(columnIndex == columnIndex2 && rowIndex < rowIndex2){
                rowIndex2--;
                rowIndex--;
            }
            else if(rowIndex == 0){
                no++;
                if(no > 0){
                    label.setText("你輸了！！！");
                    rowIndex = 0;
                    rowIndex2 = 1;
                }
            }
            else if(columnIndex < columnIndex2){
                columnIndex2--;
                rowIndex--;
            }
            else if(columnIndex > columnIndex2){
                columnIndex2++;
                rowIndex--;
            }

        }
        else if(e.getCode() == KeyCode.RIGHT){

            if(count == 0){
                columnIndex2 = 0;
                count++;
                columnIndex++;
            }
            else if(columnIndex == 4){
                no++;
                if(no > 0){
                    label.setText("你輸了！！！");
                    columnIndex = 4;
                    columnIndex2 = 3;
                }
            }
            else if(rowIndex == rowIndex2 && columnIndex > columnIndex2){
                columnIndex2++;
                columnIndex++;
            }
            else if(rowIndex > rowIndex2) {
                rowIndex2++;
                columnIndex++;
            }
            else if(rowIndex < rowIndex2){
                rowIndex2--;
                columnIndex++;
            }

            if(rowIndex == 4 && columnIndex == 4){
                label.setText("移動到出口了！！！");
            }
        }
        else if(e.getCode() == KeyCode.LEFT){

            if(rowIndex == rowIndex2 && columnIndex < columnIndex2){
                columnIndex2--;
                columnIndex--;
            }
            else if(columnIndex == 0){
                no++;
                if(no > 0){
                    label.setText("你輸了！！！");
                    columnIndex = 0;
                    columnIndex2 = 1;
                }
            }
            else {
                rowIndex2++;
                columnIndex--;
            }
        }

        walkToNewPosition();
    }

    private void walkToNewPosition(){

        int maxRowIndex = game.getRowCount() - 1;
        int maxColumnIndex = game.getColumnCount() - 1;

        if(rowIndex < 0){
            rowIndex = 0;
            label.setText("你輸了！！！");
        }
        if(columnIndex < 0){
            columnIndex = 0;
            label.setText("你輸了！！！");
        }
        if(rowIndex > maxRowIndex){
            rowIndex = 4;
            label.setText("你輸了！！！");
        }
        if(columnIndex > maxColumnIndex){
            columnIndex = 4;
            label.setText("你輸了！！！");
        }

        GridPane.setRowIndex(snake_head,rowIndex);
        GridPane.setColumnIndex(snake_head, columnIndex);
        GridPane.setRowIndex(snake_tail,rowIndex2);
        GridPane.setColumnIndex(snake_tail, columnIndex2);
    }
}
