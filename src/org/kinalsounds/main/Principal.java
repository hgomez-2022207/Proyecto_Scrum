package org.kinalsounds.main;

import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.kinalsounds.controller.MenuPrincipalController;

public class Principal extends Application {
    
    private final String PAQUETE_VISTA = "/org/kinalsounds/view/";
    private Stage escenarioPrincipal;
    private Scene escena;
    
    @Override
    public void start(Stage escenarioPrincipal) throws Exception {
        
        this.escenarioPrincipal = escenarioPrincipal;
        this.escenarioPrincipal.setTitle("Kinal Sounds");
        
        escenarioPrincipal.getIcons().add(new Image("/org/kinalSounds/image/LogoPrincipal"));
        menuPrincipal();
        escenarioPrincipal.show();      
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void menuPrincipal(){
        
        try{
            
            MenuPrincipalController menu = (MenuPrincipalController)cambiarEscena("MenuPrincipalView.fxml",600,400);
            menu.setEscenarioPrincipal(this);
        
        }catch(Exception e){
        
            e.printStackTrace();
            
        }
    
    }
    
    public Initializable cambiarEscena(String fxml,int ancho,int alto) throws IOException{
        
        Initializable resultado = null;
        FXMLLoader cargadorFXML = new FXMLLoader();
        InputStream archivo = Principal.class.getResourceAsStream(PAQUETE_VISTA+fxml);
        cargadorFXML.setBuilderFactory(new JavaFXBuilderFactory());
        cargadorFXML.setLocation(Principal.class.getResource(PAQUETE_VISTA+fxml));
        escena = new Scene((AnchorPane)cargadorFXML.load(archivo),ancho,alto);
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.sizeToScene();
        resultado = (Initializable)cargadorFXML.getController();
        return resultado;
    
    }
    

    
}
