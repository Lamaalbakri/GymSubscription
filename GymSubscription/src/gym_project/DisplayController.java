package gym_project;

import gymsubscription.dataFromFile;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

/*
  Programmer: Lama Albakri
  Gym Subscription System
*/
public class DisplayController implements Initializable {
    @FXML
    private AnchorPane gym;
    @FXML
    private RowConstraints grid;
    @FXML
    private Label name;
    @FXML
    private Label nameLabel;
    @FXML
    private Label id;
    @FXML
    private Label idLabel;
    @FXML
    private Label phone;
    @FXML
    private Label phoneLabel;
    @FXML
    private Label membership;
    @FXML
    private Label typeLabel;
    @FXML
    private Label classesLabel;
    @FXML
    private Label gender;
    @FXML
    private Label genderLabel;
    @FXML
    private Label price;
    @FXML
    private Label priceLabel;
    @FXML
    private Label classes;
    @FXML
    private Pane panel1;
    @FXML
    private Button exitButton1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setDATA();
    }
    public void setDATA(){
        idLabel.setText(dataFromFile.d.getFileID());
        nameLabel.setText(dataFromFile.d.getFilename());
        phoneLabel.setText(dataFromFile.d.getFileNum());
        genderLabel.setText(dataFromFile.d.getFileGen());
        typeLabel.setText(dataFromFile.d.getFileStype());
        classesLabel.setText(dataFromFile.d.getFileClasses());
        priceLabel.setText(dataFromFile.d.getFilePrice());
    }
    @FXML
    private void exitAction(ActionEvent event)
    {
        System.exit(0);
    }
}