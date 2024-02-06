package gymsubscription;

import java.io.File;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/*
  Gym Subscription System
*/
public class DemoGymController implements Initializable {
    @FXML
    private AnchorPane Frame;
    @FXML
    private FlowPane flow;
    @FXML
    private Pane panel1;
    @FXML
    private Label Label1;
    @FXML
    private Pane panel2;
    @FXML
    private Label nameLabel;
    @FXML
    private TextField text1;
    @FXML
    private TextField text2;
    @FXML
    private Label idLabel;
    @FXML
    private Button enterLabel;
    @FXML
    private Button createButton;

    private dataFromFile u;
    private File f ;
    private String fID;
    /**
     * Initializes the controller class.
     */
    @Override          
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void enterAction(ActionEvent event) throws Exception {
        dataFromFile  u = new dataFromFile();
        
        u.validation(text2.getText());
        u.fill();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ser.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        
        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }
    }
    @FXML
    private void createAction(ActionEvent event) {
        
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("create.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }
    }
}