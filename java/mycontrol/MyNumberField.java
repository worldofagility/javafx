package mycontrol;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class MyNumberField extends TextField {

    DoubleProperty value;
    public final void setValue(double val) {
        if (value == null)
            value = new SimpleDoubleProperty();
        if (val > getMaxValue() || val < getMinValue())
            val = getMinValue();
        value.set(val);
        if (!getText().equals(val)) {
            if (getDecimalPlaces() == 0)
                setText(String.valueOf((int) val));
            else
                setText(String.valueOf(val));
        }
    }
    public final double getValue() { return value == null ? 0 : value.get(); }
    DoubleProperty defaultValue;
    public final void setDefaultValue(double val) {
        if (defaultValue == null)
            defaultValue = new SimpleDoubleProperty();
        defaultValue.set(val);
        setValue(val);
    }
    public final double getDefaultValue() { return defaultValue == null ? 0 : defaultValue.get(); }
    DoubleProperty maxValue;
    public final void setMaxValue(double val) {
        if (maxValue == null)
            maxValue = new SimpleDoubleProperty();
        maxValue.set(val);
    }
    public final double getMaxValue() { return maxValue == null ? 0 : maxValue.get(); }
    DoubleProperty minValue;
    public final void setMinValue(double val) {
        if (minValue == null)
            minValue = new SimpleDoubleProperty();
        minValue.set(val);
    }
    public final double getMinValue() { return minValue == null ? 0 : minValue.get(); }
    IntegerProperty decimalPlaces;
    public final void setDecimalPlaces(int val) {
        if (decimalPlaces == null)
            decimalPlaces = new SimpleIntegerProperty();
        decimalPlaces.set(val); }
    public final int getDecimalPlaces() { return decimalPlaces == null ? 0 : decimalPlaces.get(); }

    public MyNumberField() {
        this(0, 2, new Double(-99999999999.99), new Double(99999999999.99));
    }

    public MyNumberField(double defaultValue, int decimalPlaces, double minValue, double maxValue) {
        super();
        setDecimalPlaces(decimalPlaces);
        setMaxValue(maxValue);
        setMinValue(minValue);
        setDefaultValue(defaultValue);
        setAlignment(Pos.CENTER_RIGHT);
        textProperty().addListener(onTextChanged());
        addEventFilter(KeyEvent.KEY_PRESSED, onKeyPressed());
        addEventFilter(KeyEvent.KEY_TYPED, onKeyTyped());
    }

    private ChangeListener<String> onTextChanged() {
        return new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                if (!oldValue.equals(newValue)) {
                    double val = 0;
                    try {
                        val = Double.parseDouble(newValue);
                        if (val > getMaxValue() || val < getMinValue()) {
                            val = Double.parseDouble(oldValue);
                        }
                    } catch (Exception ex) {}
                    setValue(val);
                }
            }
        };
    }

    private EventHandler<KeyEvent> onKeyPressed() {
        return new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {

            }
        };
    }

    private EventHandler<KeyEvent> onKeyTyped() {
        return new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if (!event.getCharacter().matches("[0-9]"))
                    event.consume();
            }
        };
    }
}
