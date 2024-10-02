package edu.curso.aula_07;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TesteFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Pane panel = new Pane();
        Scene scn = new Scene(panel, 800, 600);
        stage.setScene(scn);
        stage.setTitle("Só sucesso");
        Label lblHello = new Label("Gambiarra o jeitinho brasileiro!");
        Button btnOk = new Button("OK");
        TextField txtNome = new TextField();
        btnOk.relocate(300.0, 400.0);
        panel.getChildren().add(lblHello);
        panel.getChildren().addAll(txtNome, btnOk);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
