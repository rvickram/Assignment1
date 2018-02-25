package assignment1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.concurrent.ThreadLocalRandom;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class, controls Main
 *
 * @author ryanv
 */
public class MainController implements Initializable {
    
    //holds items to go in combo box
    ObservableList<String> listItems = FXCollections.observableArrayList();
    Model heightsArray = new Model();
    SortingStrategy selection;
    
    
    @FXML
    AnchorPane recDisplay;
    @FXML
    Label labelSize;
    @FXML
    Slider sliderArraySize;
    @FXML
    Button resetBtn;
    @FXML
    ComboBox comboAlgorithms;
    
    @FXML
    public void arraySizeBar_ValueChanged(){ //updates array and slider label
        //update the label:
        labelSize.setText(Long.toString(Math.round(sliderArraySize.getValue())));
        
        //updates the array size
        heightsArray.setArraySize(recDisplay.heightProperty().getValue().intValue(), (int)sliderArraySize.getValue());
        drawRectangles();
    }
    
    @FXML
    public void sortBtn_Click(){
        try{
            if(comboAlgorithms.getValue().toString() == "SelectionSort"){
                selection = new SelectionSort();
                selection.Sort(heightsArray.getUnsortedList());
                drawRectangles();
            }
            else if(comboAlgorithms.getValue().toString() == "MergeSort"){
                selection = new MergeSort();
                selection.Sort(heightsArray.getUnsortedList());
                drawRectangles();
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "You have not selected a sorting option!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    @FXML
    public void resetBtn_Click(){ //resets program to initial state
        sliderArraySize.setValue(1);
        labelSize.setText("1");
        heightsArray.setArraySize(recDisplay.heightProperty().getValue().intValue(), (int)sliderArraySize.getValue());
        recDisplay.getChildren().clear();
    }
    
    private void drawRectangles(){
        //clear pane:
        recDisplay.getChildren().clear();
        
        //loop sets coords of each rectangle, and draws them:
        for(int i = 0; i < (int)sliderArraySize.getValue(); i++){
            //sets width, and x/y coords of new rectangle object:
            double width = (recDisplay.widthProperty().getValue()/sliderArraySize.getValue());
            double height = (heightsArray.getUnsortedList()[i]);
            
            double x = width*i;
            double y = recDisplay.heightProperty().getValue() - height;
            
            Rectangle rec = new Rectangle();
            rec.setX(x);
            rec.setY(y);
            rec.setWidth(width);
            rec.setHeight(height);
            rec.setFill(Color.RED);
            
            recDisplay.getChildren().add(rec);
        }
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
