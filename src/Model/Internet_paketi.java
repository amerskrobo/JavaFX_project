
package Model;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Internet_paketi {
  
  public static  int[] brzine = {2,5,10,20,50,100};
  public static  Object[] protok =  {1,5,10,100,"FLAT"};
  public static enum Ugovor{Jedna,Dvije};
  
  
  private final IntegerProperty brzina = new SimpleIntegerProperty(this,"brzina",2);
  private final ObjectProperty protoci = new SimpleObjectProperty(this,"protoci",1);
  private final ObjectProperty<Ugovor> ugovor_god = new SimpleObjectProperty(this,"ugovor_god",Ugovor.Jedna);
  private final IntegerProperty id = new SimpleIntegerProperty(this,"ID",0);
  
  private final StringProperty name = new SimpleStringProperty(this,"Name","");
  private final StringProperty surname = new SimpleStringProperty(this,"Surname","");
  private final StringProperty address = new SimpleStringProperty(this,"Address","");
  
  public Internet_paketi(){
      
  }
  
  public Internet_paketi(int id){
      this.id.set(id);
  }
  
  public Internet_paketi(int brzina,int protoci, Ugovor ugovor, int id, String name, String surname, String address){
      this.brzina.set(brzina);
      this.protoci.set(protoci);
      this.ugovor_god.set(ugovor);
      this.id.set(id);
      this.name.set(name);
      this.surname.set(surname);
      this.address.set(address);
  }
  
  public Internet_paketi(int id,String name){
      this.id.set(id);
      this.name.set(name);
  }
  public void setSurname(String surname){
      this.surname.set(surname);
  }
  public String getSurname(){
      return surname.get();
  }
  public StringProperty surnameProperty(){
      return surname;
  }
  public void setName(String name){
      this.name.set(name);
  }
  public String getName(){
      return name.get();
  }
  public StringProperty nameProperty(){
      return name;
  }
  public void setProtoci(Object protoci){
      this.protoci.set(protoci);
  }
  public Object getProtoci(){
     return protoci.get();
  }
  public ObjectProperty protociProperty(){
      return protoci;
  }
  public void setSpeed(int brzina){
      this.brzina.set(brzina);
  }
  public int getSpeed(){
      return brzina.get();
  }
  public IntegerProperty brzinaProperty(){
      return brzina;
  }
  
  public void setID(int id){
      this.id.set(id);
  }
  public int getID(){
      return id.get();
  }
  public IntegerProperty idProperty(){
      return id;
  }
  
  public void setUgovor(Ugovor ugovor){
      this.ugovor_god.set(ugovor);
  }
  public Ugovor getUgovor(){
     return ugovor_god.get();
  }
  public ObjectProperty ugovor_godProperty(){
      return ugovor_god;
  }
  
  private final ObjectProperty<ArrayList<String>> errorList= new SimpleObjectProperty<>(this,"errorList",new ArrayList<>());
  public ObjectProperty<ArrayList<String>> errorsProperty(){
    return errorList;
}
  public boolean isValid(){
      boolean isValid = true;
       if(name.get()!=null &&  name.get().equals("")){
           errorList.getValue().add("First name cannot be empty!");
           isValid = false;
       }
       if( surname.get()!=null && surname.get().equals("")){
           errorList.getValue().add("Last name cannot be empty");
           isValid = false;
       }
       
      return isValid;
  }
  
  
}
