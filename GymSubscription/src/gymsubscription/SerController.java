package gymsubscription;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/*
  Gym Subscription System
*/
public class SerController implements Initializable {
    @FXML
    private BorderPane BPAN1;
    @FXML
    private Pane P1;
    @FXML
    private Label L3;
    @FXML
    private ImageView image2;
    @FXML
    private Pane BPAN2;
    @FXML
    private Button B1;
    @FXML
    private Button B2;
    @FXML
    private Button B3;
    @FXML
    private Button B4;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    @FXML
    private void addAction(ActionEvent event) throws Exception {
         try {
             if(dataFromFile.d.getFileStype()!=null){
                   JOptionPane.showMessageDialog(null, "You already have a subscription ("+dataFromFile.d.getFileStype()+")", "Error", JOptionPane.ERROR_MESSAGE);
                    throw new Exception();
             }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("thesub.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }
    }
    @FXML
    private void displayAction(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dis_info.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }
    }
    @FXML
    private void exitAction(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DemoGym.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }
    }  
}