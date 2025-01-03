import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Car Tracking System");

        // Create default users
        Customer customer = new Customer("CUST001", "John Doe");

        // Main Menu Buttons
        Button employeeButton = new Button("Employee Panel");
        Button customerButton = new Button("Customer Panel");

        // Button Actions
        employeeButton.setOnAction(e -> EmployeeLogin.show(primaryStage));
        customerButton.setOnAction(e -> CustomerPanel.show(primaryStage, customer));

        // Layout for Main Menu
        VBox mainLayout = new VBox(10);
        mainLayout.getChildren().addAll(employeeButton, customerButton);

        Scene mainScene = new Scene(mainLayout, 300, 200);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

