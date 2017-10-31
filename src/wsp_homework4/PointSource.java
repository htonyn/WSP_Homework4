package wsp_homework4;

import java.util.Vector;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class PointSource extends GridPane {
    Vector<WidgetListener> listeners;
    Slider x, y, z;
    public PointSource() {
        listeners = new Vector<WidgetListener>();
        x = new Slider(0, 10, 0);
        y = new Slider(0, 10, 0);
        z = new Slider(0, 10, 0);
        
        add(x, 1, 0);
        setHgrow(x, Priority.ALWAYS);
        add(y, 1, 1);
        setHgrow(y, Priority.ALWAYS);
        add(z, 1, 2);
        setHgrow(z, Priority.ALWAYS);
        
        Label a = new Label("0");
        add(a, 0, 0);
        x.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue arg0, Object arg1, Object arg2) {
                a.textProperty().setValue(String.valueOf((int) x.getValue()));
            }
        });
        
        Label b = new Label("0");
        add(b, 0, 1);
        y.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue arg0, Object arg1, Object arg2) {
                b.textProperty().setValue(String.valueOf((int) y.getValue()));
            }
        });
        
        Label c = new Label("0");
        add(c, 0, 2);
        z.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue arg0, Object arg1, Object arg2) {
                c.textProperty().setValue(String.valueOf((int) z.getValue()));
            }
        });
        
        Button submit = new Button("Submit");
        add(submit, 2, 0, 1, 3);
        submit.setOnAction(
            (event) -> {
                submitPoint();
            }
        );
    }
    public void submitPoint() {
        for (WidgetListener listener : listeners) {
            listener.readPoint((int) x.getValue(), (int) y.getValue(), (int) z.getValue());
        }
    }
    public void addListener(WidgetListener listener) {
        listeners.add(listener);
    }
}
