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

/**
 * FXML Controller class, controls Main
 *
 * @author ryanv
 */
public class MainController implements Initializable {
    
    ObservableList<String> listItems = FXCollections.observableArrayList();
    Model heightsArray;
    
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
        System.out.println("Height is: " + recDisplay.heightProperty().getValue().intValue());
        //update the array:
        //INSERT SETARRAYSIZE
        
        //CALL DRAWFUNCTION
        
    }
    
    @FXML
    public void sortBtn_Click(){
        
        heightsArray.setArraySize(329, (int)sliderArraySize.getValue());
        drawRectangles();
    }
    
    @FXML
    public void resetBtn_Click(){ //resets program to initial state
        sliderArraySize.setValue(1);
        labelSize.setText("1");
    }
    
    private void drawRectangles(){
        //clear pane:
        recDisplay.getChildren().clear();
        
        
        //temporary array filled with random ints
        int[] array = heightsArray.getUnsortedList();
        for(int i = 0; i < (int)sliderArraySize.getValue(); i++){
            //loads array with random integers
            array[i] = ThreadLocalRandom.current().nextInt(1, recDisplay.heightProperty().getValue().intValue());
            
            /*
            //draws rectangle based on height:
            double width = (recDisplay.widthProperty().getValue()/sliderArraySize.getValue());
            double height = (array[i]/sliderArraySize.getValue())*recDisplay.heightProperty().getValue();
            */
            double width = (recDisplay.widthProperty().getValue()/sliderArraySize.getValue());
            double height = (array[i]);
            
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
