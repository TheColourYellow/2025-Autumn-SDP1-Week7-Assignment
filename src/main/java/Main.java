import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main extends Application {

    private TextField inputField = new TextField();
    private Label resultLabel = new Label();
    private ComboBox degreeChoiceIni = new ComboBox();
    private ComboBox degreeChoiceFin = new ComboBox();
    private double fahrenheit;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        inputField.setPromptText("Enter Celsius");

        Button convertButton = new Button("Convert");
        convertButton.setOnAction(e -> convertTemperature());

        degreeChoiceIni.getItems().addAll("Fahrenheit", "Celsius", "Kelvin");
        degreeChoiceFin.getItems().addAll("Fahrenheit", "Celsius");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(degreeChoiceIni, degreeChoiceFin);

        VBox root = new VBox(10, inputField, convertButton, resultLabel, hBox);
        Scene scene = new Scene(root, 300, 200);

        stage.setTitle("Celsius to Fahrenheit");
        stage.setScene(scene);
        stage.show();
    }

    private void convertTemperature() {
        try {
            double celsius = Double.parseDouble(inputField.getText());
            fahrenheit = (celsius * 9 / 5) + 32;
            resultLabel.setText(String.format("Fahrenheit: %.2f", fahrenheit));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input!");
        }
    }
    public double fahrenheitToCelsius(double fahrenheit) {
        double fahrenheitVal = (fahrenheit - 32) * ((double) 5 / 9);
        BigDecimal fahrenheitSanitised = new BigDecimal(fahrenheitVal).setScale(2, RoundingMode.DOWN);
        return fahrenheitSanitised.doubleValue();
    }
    public double celsiusToFahrenheit(double celsius) {
        double celsiusVal = (celsius * 9 / 5) + 32;
        BigDecimal celsiusSanitised = new BigDecimal(celsiusVal).setScale(2, RoundingMode.DOWN);
        return celsiusSanitised.doubleValue();
    }
    public double kelvinToCelsius(double kelvin) {
        double celsiusVal = kelvin - 273.15;
        BigDecimal celsiusSanitised =  new BigDecimal(celsiusVal).setScale(2, RoundingMode.DOWN);
        return celsiusSanitised.doubleValue();
    }
}