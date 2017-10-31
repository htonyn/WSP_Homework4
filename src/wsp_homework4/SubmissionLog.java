package wsp_homework4;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class SubmissionLog extends GridPane implements WidgetListener {
    ScrollPane scrolling;
    TextArea log;
    public SubmissionLog() {
        scrolling = new ScrollPane();
        add(new Label("Log"), 0, 0);
        add(scrolling, 0, 1);
        log = new TextArea();
        setHgrow(log, Priority.ALWAYS);
        scrolling.setContent(log);
        log.setEditable(false);
    }
    
    @Override
    public void readTextInput(String input) {
        logSubmission("Text: "+input);
    }

    @Override
    public void readPoint(int x, int y, int z) {
        logSubmission("Point: ("+x+", "+y+", "+z+")");
    }

    @Override
    public void readToggle(String radioName) {
        logSubmission("Toggle: "+radioName);
    }
    
    public void logSubmission(String input) {
        log.appendText(input+"\n");
    }
}
