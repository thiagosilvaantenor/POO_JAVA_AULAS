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

public class AppBotaoOk4 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        Button btnOk = new Button("Ok");
        pane.setBottom(btnOk);

        // btnOk.addEventHandler(ActionEvent.ANY, new EventHandler<>()){
        // @Override
        // public void handle(ActionEvent e) {
        // stage.setTitle("Botão foi apertado parte(4)");
        // }
        // });

        // btnOk.addEventHandler(ActionEvent.ANY, (e) ->
        // stage.setTitle("Botão foi apertado parte(5)")
        // );

        btnOk.addEventHandler(ActionEvent.ANY, (e) -> stage.setTitle("Botão foi apertado parte(6)"));

        Scene scn = new Scene(pane, 800, 600);
        stage.setScene(scn);
        stage.setTitle("Teste de Botão");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(AppBotaoOk4.class, args);
    }

}
