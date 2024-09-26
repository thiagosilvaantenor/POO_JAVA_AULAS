package eventos_javafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Interceptador implements EventHandler<MouseEvent>{
    private Stage stage;
    
    public void setStage(Stage stage){
        this.stage = stage;
    }
@Override
    public void handle(MouseEvent event) {
       System.out.println("Botão apertando ...");

       if (stage != null) {
        stage.setTitle("Botão foi apertado");
       }
    }

}
