package eventos_javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AppBotaoOk3 extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane pane = new BorderPane();
        Button btnOk = new Button("Ok");
        pane.setBottom(btnOk);

        EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setTitle("Botao apertado parte (3)");
            }
        };

        btnOk.addEventHandler(ActionEvent.ANY, eventHandler);

        Scene scn = new Scene(pane, 800, 600);
        stage.setScene(scn);
        stage.setTitle("Teste de Botão");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(AppBotaoOk3.class, args);
    }

}
