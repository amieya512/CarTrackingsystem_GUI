import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CustomerPanel {
    public static void show(Stage stage, Customer customer) {
        // Input Field
        TextField vinField = new TextField("Enter VIN to Buy");

        // Buttons
        Button viewCarsButton = new Button("View Available Cars");
        Button buyCarButton = new Button("Buy Car");
        Button backButton = new Button("Back to Main Menu");

        // View Available Cars Action
        viewCarsButton.setOnAction(e -> {
            StringBuilder cars = new StringBuilder();
            for (Car car : CarInventory.getInstance().getAvailableCars()) {
                cars.append(car.getDetails()).append("\n");
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION, cars.toString());
            alert.show();
        });

        // Buy Car Action
        buyCarButton.setOnAction(e -> {
            String vin = vinField.getText();
            boolean success = customer.buyCar(vin);

            Alert alert = success
                    ? new Alert(Alert.AlertType.INFORMATION, "Car purchased successfully!")
                    : new Alert(Alert.AlertType.ERROR, "Car not found!");
            alert.show();
        });

        // Back to Main Menu Action
        backButton.setOnAction(e -> {
            try {
                new Main().start(stage); // Reloads the main menu
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(vinField, viewCarsButton, buyCarButton, backButton);

        Scene scene = new Scene(layout, 400, 400);
        stage.setScene(scene);
        stage.show();
    }
}


