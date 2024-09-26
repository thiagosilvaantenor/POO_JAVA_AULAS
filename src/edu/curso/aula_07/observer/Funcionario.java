package observer;
import java.util.ArrayList;
import java.util.List;

public class Funcionario implements Publicadora{
    private String matricula = "";
    private String nome = "";
    private int horasTrabalhadas = 0;
    private double salarioBase;
    private List<Assinante> assinantes = new ArrayList<>();

    

    public Funcionario(String matricula, String nome, int horasTrabalhadas, double salarioBase) {
        this.matricula = matricula;
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.salarioBase = salarioBase;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
        publicar();
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    @Override
    public void adicionarAssinante(Assinante a) {
       assinantes.add(a);
    }

    @Override
    public void removerAssinante(Assinante a) {
        assinantes.remove(a);
    }

    @Override
    public void publicar() {
        for (Assinante a : assinantes) {
            a.receberAviso(this);
        }
    }
}