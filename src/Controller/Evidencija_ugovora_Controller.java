
package Controller;

import Main.Assignement_Prodaja_internet_paketa;
import Model.Internet_paketi;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class Evidencija_ugovora_Controller  implements Initializable{
    
    @FXML
    TableView table;
    @FXML
    TableColumn id;
    @FXML
    TableColumn firstName;
    @FXML
    TableColumn lastName;
    @FXML
    TableColumn brzina_protoka;
    @FXML
    TableColumn protok;
    @FXML
    TableColumn trajanje_ugovora;
    @FXML
    Button izbrisiPaket;
    
    Internet_paketi_Controller intContr ;
    ObservableList<Internet_paketi> data = intContr.getData();
   
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<Internet_paketi,String>("id"));
        firstName.setCellValueFactory(new PropertyValueFactory<Internet_paketi,String>("name"));
        lastName.setCellValueFactory(new PropertyValueFactory<Internet_paketi,String>("surname"));
        brzina_protoka.setCellValueFactory(new PropertyValueFactory<Internet_paketi,Integer>("brzina"));
        protok.setCellValueFactory(new PropertyValueFactory<Internet_paketi,Object>("protoci"));
        trajanje_ugovora.setCellValueFactory(new PropertyValueFactory<Internet_paketi,Object>("ugovor_god"));
        table.setItems(data);
        
        izbrisiPaket.setOnAction(e ->{
           Internet_paketi selected = (Internet_paketi)table.getSelectionModel().getSelectedItem();
            data.remove(selected);
        });
    }
    
    @FXML
    public void glavniMeni(ActionEvent event) throws IOException{
        Parent main = FXMLLoader.load(getClass().getResource("/View/main_package.fxml"));
        Scene home_page = Assignement_Prodaja_internet_paketa.parentWindow;
        Stage app_stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
        
        app_stage.setScene(home_page);
        app_stage.show();
        
    }
   
    
    
    
    

    
}
