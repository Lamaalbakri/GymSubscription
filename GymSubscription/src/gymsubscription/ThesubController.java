package gymsubscription;
import static gymsubscription.dataFromFile.d;
import java.io.BufferedWriter;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/*
  Gym Subscription System
*/

public class ThesubController implements Initializable {

    @FXML
    private AnchorPane frame;
    @FXML
    private FlowPane Flay;
    @FXML
    private Label L1;
    @FXML
    private Label L2;
    @FXML
    private Pane P1;
    @FXML
    private RadioButton RB1;
    @FXML
    private RadioButton RB2;
    @FXML
    private RadioButton RB3;
    @FXML
    private Label L3;
    @FXML
    private Label L4;
    @FXML
    private ChoiceBox<String> MIN;
    @FXML
    private Button B1;
    private BufferedWriter writer;

    private info user;
    private String Price = "";
    private String ID;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        MIN.getItems().addAll("Boxing",
                "Zompa",
                "Swimming",
                "Power lift",
                "Private trainer");
    }
    @FXML
    private void doneAction(ActionEvent event) throws IOException {
        String sub = null, classes = null;
        if (dataFromFile.d.getsub_account()) {
            writer = new BufferedWriter(new FileWriter("account.txt", true));

            if (RB1.isSelected() == true) {
                if (MIN.getValue() == null || MIN.getValue().equals("")) {
                    Price = "500";
                    writer.write("Subscription Type:" + "3 months" + "\n" + "Classes:" + MIN.getValue() + "\n" + "Price:" + Price + "\n");
                    writer.close();
                   d.setFileStype("3 months");
                   d.setFileClasses(MIN.getValue());
                   d.setFilePrice(Price);
                    
                    JOptionPane.showMessageDialog(null, "data inserted successfuly");
                } else {
                    Price = "550";
                    writer.write("Subscription Type:" + "3 months" + "\n" + "Classes:" + MIN.getValue() + "\n" + "Price:" + Price + "\n");
                    writer.close();
                   d.setFileStype("3 months");
                   d.setFileClasses(MIN.getValue());
                   d.setFilePrice(Price);
                    JOptionPane.showMessageDialog(null, "data inserted successfuly");
                }
            } else if (RB2.isSelected() == true) {
                if (MIN.getValue() == null || MIN.getValue().equals("")) {
                    Price = "1000";
                    writer.write("Subscription Type:" + "6 months" + "\n" + "Classes:" + MIN.getValue() + "\n" + "Price:" + Price + "\n");
                    writer.close();
                      d.setFileStype("6 months");
                   d.setFileClasses(MIN.getValue());
                   d.setFilePrice(Price);
                    JOptionPane.showMessageDialog(null, "data inserted successfuly");
                } else {
                    Price = "1050";
                    writer.write("Subscription Type:" + "6 months" + "\n" + "Classes:" + MIN.getValue() + "\n" + "Price:" + Price + "\n");
                    writer.close();
                      d.setFileStype("6 months");
                   d.setFileClasses(MIN.getValue());
                   d.setFilePrice(Price);
                    JOptionPane.showMessageDialog(null, "data inserted successfuly");
                }
            } else if (RB3.isSelected() == true) {
                if (MIN.getValue() == null || MIN.getValue().equals("")) {
                    Price = "1500";
                    writer.write("Subscription Type:" + "12 months" + "\n" + "Classes:" + MIN.getValue() + "\n" + "Price:" + Price + "\n");
                    writer.close();
                      d.setFileStype("12 months");
                   d.setFileClasses(MIN.getValue());
                   d.setFilePrice(Price);
                    JOptionPane.showMessageDialog(null, "data inserted successfuly");
                } else {
                    Price = "1550";
                    writer.write("Subscription Type:" + "12 months" + "\n" + "Classes:" + MIN.getValue() + "\n" + "Price:" + Price + "\n");
                    writer.close();
                      d.setFileStype("12 months");
                   d.setFileClasses(MIN.getValue());
                   d.setFilePrice(Price);
                    JOptionPane.showMessageDialog(null, "data inserted successfuly");
                }
            }
        } else {
            if (RB1.isSelected() == true) {
                if (MIN.getValue() == null || MIN.getValue().equals("")) {
                    Price = "500";
                    sub = "3 months";
                    classes = MIN.getValue();
                } else {
                    Price = "550";
                    sub = "3 months";
                    classes = MIN.getValue();
                }
            } else if (RB2.isSelected() == true) {
                if (MIN.getValue() == null || MIN.getValue().equals("")) {
                    Price = "1000";
                    sub = "6 months";
                    classes = MIN.getValue();
                } else {
                    Price = "1050";
                    sub = "6 months";
                    classes = MIN.getValue();
                }
            } else if (RB3.isSelected() == true) {
                if (MIN.getValue() == null || MIN.getValue().equals("")) {
                    Price = "1500";
                    sub = "12 months";
                    classes = MIN.getValue();
                } else {
                    Price = "1550";
                    sub = "12 months";
                    classes = MIN.getValue();
                }
            }
            dataFromFile.d.editSub(sub, classes, Price);
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ser.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);

        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }
    }
}