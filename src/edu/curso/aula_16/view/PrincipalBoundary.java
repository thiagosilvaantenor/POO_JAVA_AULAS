package edu.curso.aula_16.view;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PrincipalBoundary extends Application {

  private Map<String, Tela> telas = new HashMap<>();

  @Override
  public void start(Stage stage) throws Exception {

    BorderPane panePrincipal = new BorderPane();
    telas.put("contato", new ContatoBoundary());
    telas.put("endereco", new EnderecoBoundary());

    MenuBar menuBar = new MenuBar();

    Menu mnuCadastro = new Menu("Cadastro");

    MenuItem mnuContato = new MenuItem("Contato");
    MenuItem mnuEndereco = new MenuItem("Endereco");

    mnuCadastro.getItems().addAll(mnuContato, mnuEndereco);

    menuBar.getMenus().add(mnuCadastro);

    panePrincipal.setTop(menuBar);

    mnuContato.setOnAction(e -> panePrincipal.setCenter(telas.get("contato").render()));
    mnuEndereco.setOnAction(e -> panePrincipal.setCenter(telas.get("endereco").render()));

    Scene scn = new Scene(panePrincipal, 600, 400);
    stage.setScene(scn);
    stage.setTitle("Agenda de Contatos");
    stage.show();
  }

  public static void main(String[] args) {
    Application.launch(PrincipalBoundary.class, args);
  }

}
