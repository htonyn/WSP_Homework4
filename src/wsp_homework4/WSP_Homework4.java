package wsp_homework4;

import java.util.Vector;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class WSP_Homework4 extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 600, 600);
        TextSource ts = new TextSource();
        PointSource ps = new PointSource();
        SelectionSource ss = new SelectionSource("1", "2", "3", "4");
        SubmissionLog sl = new SubmissionLog();
        root.add(ts, 0, 0);
        root.setHgrow(ts, Priority.ALWAYS);
        root.add(ps, 0, 1);
        root.add(ss, 0, 2);
        
        root.add(sl, 0, 3);
        ts.addListener(sl);
        ps.addListener(sl);
        ss.addListener(sl);
        primaryStage.setTitle("Homework 4 - Hoan Nguyen");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
