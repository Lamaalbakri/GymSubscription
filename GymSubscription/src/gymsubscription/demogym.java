package gymsubscription;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
  Programmer: Lama Albakri 
  Gym Subscription System
*/
public class demogym extends Application{
     @Override
    public void start(Stage stage) throws Exception {
         try {
            // Load the FXML file.
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("DemoGym.fxml")));

            // Display our window, using the scene graph.
            stage.setTitle("Gym Subscription System");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("FXML Loading Error");
            System.out.println(e.getMessage());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}