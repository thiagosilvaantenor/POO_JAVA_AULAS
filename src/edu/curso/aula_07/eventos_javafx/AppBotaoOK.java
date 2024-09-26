package eventos_javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AppBotaoOK extends Application implements EventHandler<ActionEvent>{

    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        this.stage = stage;
        Button btnOk = new Button("Teste botão");
        pane.setBottom(btnOk);

        //Interceptador inter = new Interceptador();

        btnOk.addEventHandler(ActionEvent.ANY, this);
        
        //inter.setStage(stage);
        pane.requestFocus();


        Scene scn = new Scene(pane, 800, 600);
        stage.setScene(scn);
        stage.setTitle("Teste Botão");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(AppBotaoOK.class, args);
    }

    @Override
    public void handle(ActionEvent event) {
        stage.setTitle("Botão foi apertado");
    }

}
