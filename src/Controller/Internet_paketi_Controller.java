
package Controller;



import Model.Internet_paketi;
import Model.Internet_paketi.Ugovor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class Internet_paketi_Controller {
    
    @FXML
    private ChoiceBox<int[]> brzina;
    
    @FXML
    private ChoiceBox<Object[]> protok;
    @FXML
    private ToggleButton jedna;
    @FXML 
    private ToggleButton dvije;
    @FXML
    private ToggleGroup ugovor;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    
  
    private double dragOffsetX;
    private double dragOffsetY;
    
    private Internet_paketi intPaketi;
    private final ObservableList brzine = FXCollections.observableArrayList();
    private static ObservableList<Internet_paketi> data = FXCollections.observableArrayList();
    
    public Internet_paketi_Controller(){
        
    }
    
    @FXML
    private void initialize(){
  
        intPaketi = new Internet_paketi();
        
        for(int i=0;i<intPaketi.brzine.length;i++){
        brzine.addAll(intPaketi.brzine[i]);
        }
        
        brzina.getItems().addAll(brzine);
        brzina.getSelectionModel().select(0);
        
        brzine.clear();
        
        for(int i=0;i<intPaketi.protok.length;i++){
            brzine.addAll(intPaketi.protok[i]);
            }
        protok.getItems().addAll(brzine);
        protok.getSelectionModel().select(0);
        brzine.clear();
        
        jedna.setText(Ugovor.Jedna.toString());
        jedna.setSelected(true);
        
        dvije.setText(Ugovor.Dvije.toString());
        
       // name.textProperty().bindBidirectional(intPaketi.nameProperty());
       // surname.textProperty().bindBidirectional(intPaketi.surnameProperty());
        
          
        
        brzina.getSelectionModel().selectedItemProperty().addListener(new ChangeListener(){

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                intPaketi.setSpeed((int)newValue);
            }
            
        });
        
        protok.getSelectionModel().selectedItemProperty().addListener(new ChangeListener(){

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
               intPaketi.setProtoci(newValue);
            }
            
        });
        
        ugovor.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){

            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
               if(newValue!=null){
                   ToggleButton selected = (ToggleButton)newValue;
                   switch(selected.getId()){
                       case "jedna":
                           intPaketi.setUgovor(Ugovor.Jedna);
                           break;
                       case "dvije":
                           intPaketi.setUgovor(Ugovor.Dvije);
                           break;
                   }
               }
                
            }
            
        });
        
        
    }
    
    @FXML
    public void kupiPaket(){
        intPaketi.setName(name.textProperty().get());
        intPaketi.setSurname(surname.textProperty().get());
        if(intPaketi.isValid()){
        Random rand = new Random();
        intPaketi.idProperty().set(rand.nextInt(1000)+1);
        data.add(intPaketi);
        Alert alert1 = new Alert(AlertType.CONFIRMATION);
        alert1.setTitle("Succesfully bought");
        alert1.setContentText("Zahvaljujemo se na kupljenom paketu ! ");
        alert1.setHeaderText(null);
        
       
        alert1.show();
        
        intPaketi = new Internet_paketi();
        name.clear();
        surname.clear();
        
        }else{
            StringBuilder msg = new StringBuilder();
            ArrayList<String> errList = intPaketi.errorsProperty().get();
            for(String err:errList){
                msg.append(err+ "\n");
            }
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Person can't be saved");
            alert.setHeaderText(null);
            alert.setContentText(msg.toString());
            alert.showAndWait();
            errList.clear();
        }
        
       
        
        
    }
    @FXML
    public void evidencijaUgovora(ActionEvent event) throws IOException{
         
        Parent main = FXMLLoader.load(getClass().getResource("/View/Evidencija.fxml"));
        Scene home_page = new Scene(main);
        Stage app_stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
        
        app_stage.setScene(home_page);
        app_stage.show();
        
        home_page.setOnMousePressed(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                dragOffsetX = event.getScreenX()- app_stage.getX();
                dragOffsetY = event.getScreenY()- app_stage.getY();
            }
            
        });
        
        home_page.setOnMouseDragged(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                app_stage.setX(event.getScreenX()-dragOffsetX);
                app_stage.setY(event.getScreenY()-dragOffsetY);
            }
            
        });
    }
    
   
    
    public static ObservableList getData(){
        return data;
    }

   
   

    
    
}
