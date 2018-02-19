package assignment1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

/**
 * FXML Controller class, controls Main
 *
 * @author ryanv
 */
public class MainController implements Initializable {
    
    @FXML
    Label labelSize;
    @FXML
    Slider sliderArraySize;
    @FXML
    Button resetBtn;
    
    @FXML
    public void arraySizeBar_ValueChanged(){ //changes the label to slider value
        labelSize.setText(Long.toString(Math.round(sliderArraySize.getValue())));
    }
    
    @FXML
    public void resetBtn_Click(){ //resets program to initial state
        sliderArraySize.setValue(1);
        labelSize.setText("1");
    }

    /**
     * Initializes the controller class.
     * @param url input address for server
     * @param rb any input resource bundles
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
