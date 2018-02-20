package assignment1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class, controls Main
 *
 * @author ryanv
 */
public class MainController implements Initializable {
    
    ObservableList<String> listItems = FXCollections.observableArrayList();
    
    @FXML
    Label labelSize;
    @FXML
    Slider sliderArraySize;
    @FXML
    Button resetBtn;
    @FXML
    ComboBox comboAlgorithms;
    
    @FXML
    public void arraySizeBar_ValueChanged(){ //changes the label to slider value
        labelSize.setText(Long.toString(Math.round(sliderArraySize.getValue())));
    }
    
    @FXML
    public void resetBtn_Click(){ //resets program to initial state
        sliderArraySize.setValue(1);
        labelSize.setText("1");
    }
    
    private void setSortStrategy(){
        listItems.addAll("MergeSort","SelectionSort");
        comboAlgorithms.setItems(listItems);
    }

    /**
     * Initializes the controller class.
     * @param url input address for server
     * @param rb any input resource bundles
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setSortStrategy();
    }   
    
}
