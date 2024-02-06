package gymsubscription;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/* 
  Gym Subscription System
*/
public class addSub extends Application{
     @Override
    public void start(Stage stage) throws Exception {
         try {
            // Load the FXML file.
            Parent parent = FXMLLoader.load(getClass().getResource("thesub.fxml"));
            // Build the scene graph.
            Scene scene = new Scene(parent);
            // Display our window, using the scene graph.
            stage.setTitle("Gym Subscription System");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("FXML Loading Error");
        } 
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}