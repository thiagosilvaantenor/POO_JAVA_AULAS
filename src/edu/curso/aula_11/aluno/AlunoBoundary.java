package edu.curso.aula_11.aluno;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class AlunoBoundary extends Application {
    private TextField txtNome = new TextField("");
    private TextField txtRa = new TextField("");
    private TextField txtIdade = new TextField("0");

    private AlunoControl control = new AlunoControl();
    
    private Button btnSalvar = new Button("Salvar");
    private Button btnPesquisar = new Button("Pesquisar");

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane panePrincipal = new BorderPane();
        GridPane pane = new GridPane();
        
        pane.add(new Label("Nome:"), 0, 0);
        pane.add(txtNome, 1, 0);
        pane.add(new Label("Ra:"), 0, 1);
        pane.add(txtRa, 1, 1);
        pane.add(new Label("Idade:"), 0, 2);
        pane.add(txtIdade, 1, 2);

        pane.add(btnSalvar, 0, 3);
        pane.add(btnPesquisar, 1, 3);

        btnSalvar.setOnAction(e -> {
            control.salvar();
            control.limpar();
        });

        btnPesquisar.setOnAction(e -> {
            control.pesquisar();
        });

        NumberStringConverter conversor = new NumberStringConverter();

        Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
        Bindings.bindBidirectional(txtRa.textProperty(), control.raProperty());
        Bindings.bindBidirectional(txtIdade.textProperty(), control.idadeProperty(),conversor);
        Scene cena = new Scene(panePrincipal, 800, 600);

        panePrincipal.setTop(pane);

        stage.setScene(cena);
        stage.setTitle("Gestão de Alunos");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(AlunoBoundary.class,args);
    }
}
