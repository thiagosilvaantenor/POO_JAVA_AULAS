package edu.curso.aula_11.contato;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ContatoBoundary extends Application{
    private TextField txtNome = new TextField();
    private TextField txtEmail = new TextField();
    private TextField txtTelefone = new TextField();


    private Button btnMostrar = new Button("Mostrar");


    private ContatoControl control = new ContatoControl();
    
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        Scene scn = new Scene(pane, 800,600);

        GridPane paneGrid = new GridPane();
        paneGrid.add(new Label("Nome: "), 0, 0);
        paneGrid.add(txtNome, 1, 0);
        paneGrid.add(new Label("Email: "), 0, 1);
        paneGrid.add(txtEmail, 1, 1);
        paneGrid.add(new Label("Telefone: "), 0, 2);
        paneGrid.add(txtTelefone, 1, 2);
        paneGrid.add(btnMostrar, 0, 3);

        pane.setCenter(paneGrid);

        //Ao alterar o nome altera o titulo
        //Bindings.bindBidirectional(txtNome.textProperty(), stage.titleProperty());

        Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());

        btnMostrar.setOnAction(e -> {
            control.mostrar();
        });

        stage.setScene(scn);
        stage.setTitle("Gestão de Contatos");
        stage.show();
    }


    public static void main(String[] args) {
        Application.launch(ContatoBoundary.class,args);
    }
}
