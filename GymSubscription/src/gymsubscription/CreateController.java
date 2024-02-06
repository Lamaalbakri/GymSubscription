package gymsubscription;

import java.io.FileWriter;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/* 
  Gym Subscription System
*/
public class CreateController implements Initializable {

    @FXML
    private AnchorPane frame1;
    @FXML
    private BorderPane Blayout1;
    @FXML
    private Pane bPan2;
    @FXML
    private Label label1;
    @FXML
    private Label lab;
    @FXML
    private TextField t1;
    @FXML
    private Label label2;
    @FXML
    private TextField t2;
    @FXML
    private Label label3;
    @FXML
    private TextField t3;
    @FXML
    private Button B1;
    @FXML
    private Label gender;
    @FXML
    private RadioButton male;
    @FXML
    private ToggleGroup g;
    @FXML
    private RadioButton female;
   
    private info user;
    private  String name;
    private  String ID;
    private  String number;
    private  String gen;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void creatAction(ActionEvent event) throws Exception{
        inputValidation();
        dataFromFile  u = new dataFromFile();
        u.check(t2.getText());
        
        if(u.gethave_account()){
            JOptionPane.showMessageDialog(null, "this ID already has an account, you have to login", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
        u.setFilename(t1.getText());
        u.setFileID(t2.getText()); 
        u.setFileNum(t3.getText());
        if(male.isSelected()){
            u.setFileGen("Male");  
        }
        else{
            u.setFileGen("Female");  
        }
       
        writeToFile(u.getFileID(),u.getFilename(),u.getFileNum(),u.getFileGen());
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ser.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        
        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }
        u.sethave_sub(true);
        u.fill();
    }
    private void inputValidation() throws Exception{
        if (!validateName()) {
            //only letters
            JOptionPane.showMessageDialog(null, "Invalid Name !", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
        if (!validateID()) {
            //only numbers
            JOptionPane.showMessageDialog(null, "Invalid ID !", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
        if (!validateMobile()) {
            //only numbers
            JOptionPane.showMessageDialog(null, "Invalid Mobile number !", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
        if (!male.isSelected() && !female.isSelected()) {
            JOptionPane.showMessageDialog(null, "Select the gender!", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
    }
     private boolean validateName(){
         //for name
        return t1.getText().matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
    }
    private boolean validateID() {
        //for id
        return t2.getText().matches("\\d{10}");
    }
     private boolean validateMobile() {
         //for number
        return t3.getText().matches("(05)[0-9]{8}");
    }  
    public void writeToFile(String ID, String name, String number, String gender) throws IOException{
    try{
    FileWriter writer = new FileWriter("account.txt", true);
    writer.write("*"+ ID +"\n"+"Name:"+name+"\n"+"Phone number:"+number+"\n"+"Gender:"+gender+"\n");
    writer.close();
    JOptionPane.showMessageDialog(null, "data inserted successfuly");   
    }catch(Exception e){
    
        JOptionPane.showMessageDialog(null, "something went wrong"); 
    }
   }
}