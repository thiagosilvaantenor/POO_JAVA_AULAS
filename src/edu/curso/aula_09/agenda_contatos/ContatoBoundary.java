package edu.curso.aula_09.agenda_contatos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class ContatoBoundary extends Application{

    //Campo de texto
    private TextField txtNome = new TextField();
    private TextField txtTelefone = new TextField();
    private TextField txtEmail = new TextField();
    private ContatoControl control = new ContatoControl();

    @Override
    public void start(Stage stage) throws Exception {
        //Panes
        GridPane gPane = new GridPane();
        //Restriçao de colunas
        //Para labels
        ColumnConstraints colLabels = new ColumnConstraints();
        colLabels.setPercentWidth(30);
        //Para o TextField
        ColumnConstraints colText = new ColumnConstraints();
        colText.setPercentWidth(70);
        gPane.getColumnConstraints().addAll(colLabels,colText);
        
        //Restrição de linhas
        RowConstraints linhaConstraints = new RowConstraints();
        linhaConstraints.setPercentHeight(25.0);

        gPane.getRowConstraints().addAll(linhaConstraints,linhaConstraints,
                        linhaConstraints,linhaConstraints);
        //Scenes
        Scene scn = new Scene(gPane, 600, 300);
        


        //Posicionamento
        gPane.add(new Label("Nome: "), 0, 0);
        gPane.add(txtNome, 1 , 0);
        gPane.add(new Label("Telefone: "), 0, 1);
        gPane.add(txtTelefone, 1 , 1);
        gPane.add(new Label("Email: "), 0, 2);
        gPane.add(txtEmail, 1 , 2);

        //Botões
        Button btnGravar = new Button("Gravar");
        btnGravar.setOnAction(e -> {
            control.gravar(boundaryToEntity());
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Agenda de Contatos");
            alert.setHeaderText("Informativo");
            alert.setContentText("Contato foi salvo com sucesso");
            alert.show();
        });
        Button btnPesquisar = new Button("Pesquisar");
        btnPesquisar.setOnAction(e -> {
            Contato c = control.pesquisar(txtNome.getText());
            if (c != null) {
                entityToBoundary(c);
            }
        });

        gPane.add(btnGravar, 0, 3);
        gPane.add(btnPesquisar, 1, 3);
        
        stage.setScene(scn);
        stage.setTitle("Agenda de contatos");
        stage.show();
    }

    public Contato boundaryToEntity() {
        Contato c = new Contato();
        c.setNome(txtNome.getText());
        c.setTelefone(txtTelefone.getText());
        c.setEmail(txtEmail.getText());
        return c;
    }

    public void entityToBoundary(Contato c) {
        if(c != null){
            txtNome.setText(c.getNome());
            txtTelefone.setText(c.getTelefone());
            txtEmail.setText(c.getEmail());
        }
    }
}
