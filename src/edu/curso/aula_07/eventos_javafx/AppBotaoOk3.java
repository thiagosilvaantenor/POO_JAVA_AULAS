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

public class AppBotaoOk3 extends Application implements EventHandler<ActionEvent>{

    private Stage stage;
    private int vermelho = 0;
    private int azul = 0;

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        this.stage = stage;
        Pane painelCor = new Pane();

        BackgroundFill backgroundFill = new BackgroundFill(Color.rgb(0, 0, 0),
         new CornerRadii(10), new Insets(10));

        painelCor.setBackground(new Background(backgroundFill));

        Button btnVermelho = new Button("Aumentar Vermelho");
        btnVermelho.setOnAction(e -> {
        this.vermelho += 10;
        if (this.vermelho >= 255) {
            this.vermelho = 255;
        }
        BackgroundFill backgroundFill2 = new BackgroundFill(Color.rgb(0, 0, 0),
        new CornerRadii(10), new Insets(10));
        painelCor.setBackground(new Background(backgroundFill));});

        Button btnAzul = new Button("Aumentar azul");
        //Button btnOk = new Button("Ok");
        //pane.setBottom(btnOk);
        pane.setTop(btnVermelho);
        pane.setBottom(btnAzul);

        //Interceptador inter = new Interceptador();

        //EventHandler<ActionEvent> eventHand = new EventHandler<ActionEvent>() {
        //    @Override
        //    public void handle(ActionEvent e) {
        //        stage.setTitle("Botão apertado parte (3)");
        //    }
       // };
        //btnOk.addEventHandler(ActionEvent.ANY, (ActionEvent e) -> {
        //    stage.setTitle("Botão foi apertado parte(5)");
        //});
        //btnOk.addEventHandler(ActionEvent.ANY, (e) -> 
        //   stage.setTitle("Botão foi apertado parte(5)")
        //);

        //inter.setStage(stage);
        pane.requestFocus();


        Scene scn = new Scene(pane, 800, 600);
        stage.setScene(scn);
        stage.setTitle("Teste Botão");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch( args);
    }

    @Override
    public void handle(ActionEvent event) {
        stage.setTitle("Botão foi apertado");
    }

}

