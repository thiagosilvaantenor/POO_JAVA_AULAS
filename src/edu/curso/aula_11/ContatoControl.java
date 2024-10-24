import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContatoControl {
    private ObservableList<Contato> lista = FXCollections.observableArrayList();
    private StringProperty nome = new SimpleStringProperty();
    private StringProperty email = new SimpleStringProperty();
    private StringProperty telefone = new SimpleStringProperty();
    private ObjectProperty<LocalDate> nascimento = new SimpleObjectProperty<>();
    private int contador = 0;

    public ContatoControl() {
        Contato c1 = new Contato();
        c1.setNome("Geralt de Rivia");
        c1.setEmail("Geralt@witcher.com");
        c1.setTelefone("(11) 1111-1111");
        lista.add(c1);
        
        Contato c2 = new Contato();
        c2.setNome("Ciri");
        c2.setEmail("Cirrila@witcher.com");
        c2.setTelefone("(11) 2222-1111");
        lista.add(c2);
    }
    
    public void gravar() {
        Contato c = new Contato();
        contador += 1;
        c.setId(contador);
        c.setNome(this.nome.get());
        c.setTelefone(this.telefone.get());
        c.setEmail(this.email.get());
        c.setDataNascimento(this.nascimento.get());
        lista.add(c);
    }

    public void pesquisarPorNome() {
        for (Contato c : lista) {
            if(c.getNome().toUpperCase().contains(nome.get().toUpperCase())) {
                nome.set(c.getNome());
                telefone.set(c.getTelefone());
                email.set(c.getEmail());
                nascimento.set(c.getDataNascimento());
            }
        }
    }

    public ObservableList<Contato> getLista(){
        return this.lista;
    }

    public StringProperty nomProperty() {
        return nome;
    }

    public StringProperty emailProperty() {
        return email;
    }

    public StringProperty telefoneProperty() {
        return telefone;
    }

    public ObjectProperty<LocalDate> nascimentoProperty() {
        return nascimento;
    }

    
}
