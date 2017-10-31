package wsp_homework4;

import java.util.Vector;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class SelectionSource extends GridPane {
    Vector<WidgetListener> listeners;
    ToggleGroup tga;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    RadioButton rb4;
    public SelectionSource(String one, String two, String three, String four) {
        listeners = new Vector<WidgetListener>();
        tga = new ToggleGroup();
        rb1 = new RadioButton(one);
        rb2 = new RadioButton(two);
        rb3 = new RadioButton(three);
        rb4 = new RadioButton(four);
        
        rb1.setToggleGroup(tga);
        rb1.setUserData(one);
        rb2.setToggleGroup(tga);
        rb2.setUserData(two);
        rb3.setToggleGroup(tga);
        rb3.setUserData(three);
        rb4.setToggleGroup(tga);
        rb4.setUserData(four);
        
        tga.selectToggle(rb1);
        
        add(rb1, 0, 0);
        add(rb2, 0, 1);
        add(rb3, 1, 0);
        add(rb4, 1, 1);
        
        Region r = new Region();
        add(r, 2, 0);
        setHgrow(r, Priority.ALWAYS);
        Button submit = new Button("Submit");
        add(submit, 3, 0, 1, 2);
        submit.setOnAction(
            (event) -> {
                sendRadioButton(getRadioName());
            }
        );
    }
    public void sendRadioButton(String toggle) {
        for (WidgetListener listener : listeners) {
            listener.readToggle(toggle);
        }
    }
    
    public void addListener(WidgetListener listener) {
        listeners.add(listener);
    }
    
    public String getRadioName() {
        return tga.getSelectedToggle().getUserData().toString();
    }
}
