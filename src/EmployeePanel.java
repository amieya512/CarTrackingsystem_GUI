import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmployeePanel {
    public static void show(Stage stage, Employee employee) {
        // Input Fields
        TextField makeField = new TextField("Make");
        TextField modelField = new TextField("Model");
        TextField yearField = new TextField("Year");
        TextField priceField = new TextField("Price");
        TextField vinField = new TextField("VIN");

        // Buttons
        Button addCarButton = new Button("Add Car");
        Button markSoldButton = new Button("Mark Car as Sold");
        Button backButton = new Button("Back to Main Menu");

        // Add Car
        addCarButton.setOnAction(e -> {
            String make = makeField.getText();
            String model = modelField.getText();
            int year = Integer.parseInt(yearField.getText());
            double price = Double.parseDouble(priceField.getText());
            String vin = vinField.getText();

            employee.addCar(new Car(make, model, year, price, vin));

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Car added successfully!");
            alert.show();
        });

        // Mark Car as Sold
        markSoldButton.setOnAction(e -> {
            String vin = vinField.getText();
            boolean success = employee.markCarAsSold(vin);

            Alert alert = success
                    ? new Alert(Alert.AlertType.INFORMATION, "Car marked as sold!")
                    : new Alert(Alert.AlertType.ERROR, "Car not found!");
            alert.show();
        });

        // Back to Main Menu
        backButton.setOnAction(e -> {
            try {
                new Main().start(stage); // Reloads the main menu
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(makeField, modelField, yearField, priceField, vinField, addCarButton, markSoldButton, backButton);

        Scene scene = new Scene(layout, 400, 400);
        stage.setScene(scene);
        stage.show();
    }
}

