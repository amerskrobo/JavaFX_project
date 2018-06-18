
package Main;



import java.net.URL;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Assignement_Prodaja_internet_paketa extends Application{
    
     private double dragOffsetX;
     private double dragOffsetY;
     
     public static Scene parentWindow;
     public static Stage parentWindowStage;
    public static void main(String[] args) {
        
       Application.launch(args);
      
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        parentWindowStage = primaryStage;
        
        URL fxmlURL = getClass().getResource("/View/main_package.fxml");
        GridPane root = FXMLLoader.<GridPane>load(fxmlURL);
        
        Scene scene = new Scene(root);
        parentWindow = scene;
      //  primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.getIcons().add(new Image("/Main/internet.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
        
        scene.setOnMousePressed(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                dragOffsetX = event.getScreenX()- primaryStage.getX();
                dragOffsetY = event.getScreenY()- primaryStage.getY();
            }
            
        });
        
        scene.setOnMouseDragged(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX()-dragOffsetX);
                primaryStage.setY(event.getScreenY()-dragOffsetY);
            }
            
        });
    }
    
}
