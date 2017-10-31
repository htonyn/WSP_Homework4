package wsp_homework4;

import java.util.Vector;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class TextSource extends GridPane {
    private TextField tf;
    private Vector<WidgetListener> listeners;
    
    public TextSource() {
        tf = new TextField();
        add(tf, 0, 0);
        Button submit = new Button("Submit");
        add(submit, 1, 0);
        setHgrow(tf, Priority.ALWAYS);
        listeners = new Vector<WidgetListener>();
        submit.setOnAction(
            (event) -> {
                broadcastMessage();
            }
        );
    }
    
    public void broadcastMessage() {
        for (WidgetListener listener : listeners) {
            listener.readTextInput("TextSource: "+getMessage());
        }
    }
    
    public void addListener(WidgetListener listener) {
        listeners.add(listener);
    }
    
    public String getMessage() {
        return tf.getText();
    }
    
    public String getText() {
        return tf.getText();
    }
}
