package edu.curso.aula_15.view;
import java.time.LocalDate;

import edu.curso.aula_15.control.ContatoControl;
import edu.curso.aula_15.model.Contato;
import edu.curso.aula_15.model.ContatoException;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

public class ContatoBoundary extends Application { 
    private Label lblId = new Label("");
    private TextField txtNome = new TextField("");
    private TextField txtTelefone = new TextField("");
    private TextField txtEmail = new TextField("");
    private DatePicker dateNascimento = new DatePicker(LocalDate.now());

    private TableView<Contato> tableView = new TableView<>();

    private ContatoControl control;

    @Override
    public void start(Stage stage) { 
        BorderPane panePrincipal = new BorderPane();

        try { 
            control = new ContatoControl();
        } catch (ContatoException e) { 
            alert(AlertType.ERROR, "Ao ao inicializar o sistema");
        }

        GridPane paneForm = new GridPane();
        paneForm.add(new Label("Id: "), 0, 0);
        paneForm.add(lblId, 1, 0);
        paneForm.add(new Label("Nome: "), 0, 1);
        paneForm.add(txtNome, 1, 1);
        paneForm.add(new Label("Telefone: "), 0, 2);
        paneForm.add(txtTelefone, 1, 2);
        paneForm.add(new Label("Email: "), 0, 3);
        paneForm.add(txtEmail, 1, 3);
        paneForm.add(new Label("Nascimento: "), 0, 4);
        paneForm.add(dateNascimento, 1, 4);

        Button btnGravar = new Button("Gravar");
        btnGravar.setOnAction( e -> {
            try { 
                control.gravar();
                tableView.refresh();
            } catch (ContatoException err) { 
                alert(AlertType.ERROR, "Erro ao gravar");
            }  
        });
        Button btnPesquisar = new Button("Pesquisar");
        btnPesquisar.setOnAction( e -> { 
            try { 
                control.pesquisarPorNome(); 
            } catch (ContatoException err) { 
                alert(AlertType.ERROR, "Erro ao pesquisar");
            }   
        });

        Button btnLimpar = new Button("*");
        btnLimpar.setOnAction( e -> control.limparTudo() );

        paneForm.add(btnGravar, 0, 5);
        paneForm.add(btnPesquisar, 1, 5);
        paneForm.add(btnLimpar, 2, 0);

        generateColumns();
        vincularPropriedes();

        panePrincipal.setTop( paneForm );
        panePrincipal.setCenter(tableView);

        Scene scn = new Scene( panePrincipal, 600, 400);
        stage.setScene(scn);
        stage.setTitle("Agenda de Contato");
        stage.show();
        try { 
        control.pesquisarTodos();
        } catch(ContatoException e) { 
            alert(AlertType.ERROR, "Erro ao pesquisar todos");
        }
    }

    public void alert(AlertType tipo, String msg) { 
        Alert alertWindow = new Alert(tipo);
        alertWindow.setHeaderText("Alerta");
        alertWindow.setContentText(msg);
        alertWindow.showAndWait();
    }

    public void generateColumns() { 
        TableColumn<Contato, Integer> col1 = new TableColumn<>("Id");
        col1.setCellValueFactory(new PropertyValueFactory<Contato, Integer>("id"));

        TableColumn<Contato, String> col2 = new TableColumn<>("Nome");
        col2.setCellValueFactory(new PropertyValueFactory<Contato, String>("nome"));

        TableColumn<Contato, String> col3 = new TableColumn<>("Email");
        col3.setCellValueFactory(new PropertyValueFactory<Contato, String>("email"));

        TableColumn<Contato, String> col4 = new TableColumn<>("Telefone");
        col4.setCellValueFactory(new PropertyValueFactory<Contato, String>("telefone"));

        TableColumn<Contato, LocalDate> col5 = new TableColumn<>("Nascimento");
        col5.setCellValueFactory(new PropertyValueFactory<Contato, LocalDate>("nascimento"));


        // Criar o fabricante da Celula
        Callback<TableColumn<Contato, Void>, TableCell<Contato, Void>> callback = 
            new  Callback<>() {
                @Override
                public TableCell<Contato, Void> call(TableColumn<Contato, Void> param) {
                    TableCell<Contato, Void> tc = new TableCell<>() { 
                        final Button btnExcluir = new Button("Apagar");
                        {
                            btnExcluir.setOnAction( 
                                e -> { 
                                    try { 
                                        Contato c = tableView.getItems().get( getIndex() );
                                        control.excluir( c ); 
                                    } catch (ContatoException err) { 
                                        alert(AlertType.ERROR, "Erro ao excluir");
                                    }  
                                }
                            );
                        }
                        public void updateItem(Void item, boolean empty) { 
                            super.updateItem(item, empty);
                            if (empty) { 
                                setGraphic( null );
                            } else { 
                                setGraphic( btnExcluir );
                            }
                        }
                    };
                    return tc;
                } 
        };

        TableColumn<Contato, Void> col6 = new TableColumn<>("Ações");
        col6.setCellFactory( callback );

        tableView.getColumns().addAll(col1, col2, col3, col4, col5, col6);
        tableView.setItems( control.getLista() );

        tableView.getSelectionModel().selectedItemProperty()
        .addListener( (obs, antigo, novo) -> { 
            System.out.println( "Selecionado o contato ==> " + novo);
            control.entidadeParaTela( novo );
        });
    }

    public void vincularPropriedes() { 
        Bindings.bindBidirectional(lblId.textProperty(), control.idProperty(), 
                    (StringConverter) new IntegerStringConverter());
        Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
        Bindings.bindBidirectional(txtEmail.textProperty(), control.emailProperty());
        Bindings.bindBidirectional(txtTelefone.textProperty(), control.telefoneProperty());
        Bindings.bindBidirectional(dateNascimento.valueProperty(), control.nascimentoProperty());
    }

    public static void main(String[] args) {
        Application.launch(ContatoBoundary.class, args);
    }
}