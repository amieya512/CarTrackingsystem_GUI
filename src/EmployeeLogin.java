import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmployeeLogin {
    public static void show(Stage stage) {
        // Input Fields
        TextField nameField = new TextField("Enter your name");
        TextField idField = new TextField("Enter your 5-digit ID");

        // Login Button
        Button loginButton = new Button("Login");
        Button backButton = new Button("Back to Main Menu");

        // Login Action
        loginButton.setOnAction(e -> {
            String name = nameField.getText();
            String id = idField.getText();

            // Validate 5-digit ID
            if (id.matches("\\d{5}")) {
                Employee employee = new Employee(id, name);
                EmployeePanel.show(stage, employee); // Navigate to Employee Panel
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid ID. Please enter a 5-digit number.");
                alert.show();
            }
        });

        // Back Button Action
        backButton.setOnAction(e -> {
            try {
                new Main().start(stage); // Navigate back to Main Menu
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(nameField, idField, loginButton, backButton);

        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
        stage.show();
    }
}
