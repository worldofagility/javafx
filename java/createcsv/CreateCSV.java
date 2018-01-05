package createcsv;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import mycontrol.MyNumberField;

public class CreateCSV extends Application {

    private MyNumberField colName, colType, colLength, colDecimals, colRequire, colByte;
    private TextField txtCharHalf, txtCharFull, txtCharKana, txtCharNumber, txtCharDate, txtCharFlag, txtCharRequire;

    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        ColumnConstraints columnConstraints;
        for (int col = 0; col < 6; col++) {
            columnConstraints = new ColumnConstraints();
            columnConstraints.setHgrow(Priority.ALWAYS);
            root.getColumnConstraints().add(columnConstraints);
        }
        RowConstraints rowConstraints;
        for (int row = 0; row < 13; row++) {
            rowConstraints = new RowConstraints();
            rowConstraints.setVgrow(Priority.ALWAYS);
            root.getRowConstraints().add(rowConstraints);
        }

        colName = new MyNumberField(1, 0, 1, 10);
        colName.setDefaultValue(1);
        root.add(new Label("Column Name: "), 0, 0);
        root.add(colName, 1, 0, 2, 1);

        colType = new MyNumberField(2, 0, 1, 10);
        root.add(new Label("Column Type: "), 0, 1);
        root.add(colType, 1, 1, 2, 1);

        colLength = new MyNumberField(3, 0, 1, 10);
        root.add(new Label("Column Length: "), 0, 2);
        root.add(colLength, 1, 2, 2, 1);

        colDecimals = new MyNumberField(4, 0, 1, 10);
        root.add(new Label("Column Decimals: "), 0, 3);
        root.add(colDecimals, 1, 3, 2, 1);

        colRequire = new MyNumberField(5, 0, 1, 10);
        root.add(new Label("Column Require: "), 0, 4);
        root.add(colRequire, 1, 4, 2, 1);

        colByte = new MyNumberField(6, 0, 1, 10);
        root.add(new Label("Column 2 Byte: "), 0, 5);
        root.add(colByte, 1, 5, 2, 1);

        txtCharHalf = new TextField();
        root.add(new Label("1 Byte Character: "), 0, 6);
        root.add(txtCharHalf, 1, 6, 2, 1);

        txtCharFull = new TextField();
        root.add(new Label("2 Byte Character: "), 0, 7);
        root.add(txtCharFull, 1, 7, 2, 1);

        txtCharKana = new TextField();
        root.add(new Label("Kana Character: "), 0, 8);
        root.add(txtCharKana, 1, 8, 2, 1);

        txtCharNumber = new TextField();
        root.add(new Label("Number Character: "), 0, 9);
        root.add(txtCharNumber, 1, 9, 2, 1);

        txtCharDate = new TextField();
        root.add(new Label("Date Character: "), 0, 10);
        root.add(txtCharDate, 1, 10, 2, 1);

        txtCharFlag = new TextField();
        root.add(new Label("Flag Character: "), 0, 11);
        root.add(txtCharFlag, 1, 11, 2, 1);

        txtCharRequire = new TextField();
        root.add(new Label("Require Character: "), 0, 12);
        root.add(txtCharRequire, 1, 12, 2, 1);

        Button ok = new Button("Create CSV");
        ok.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        ok.setOnAction(onOkClick());
        root.add(ok, 4, 2, 2, 2);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Create CSV");
        primaryStage.show();
    }

    private EventHandler<ActionEvent> onOkClick() {
        return new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                txtCharFlag.requestFocus();
                txtCharFlag.positionCaret(2);
                Clipboard clipboard = Clipboard.getSystemClipboard();
            }
        };
    }

    public static void main(String[] args){
        launch(args);
    }
}
