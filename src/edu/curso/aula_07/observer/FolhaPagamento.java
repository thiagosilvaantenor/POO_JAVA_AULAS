package observer;
public class FolhaPagamento implements Assinante {
    private double reservaSalarios = 0;

    public double getReservaSalarios() {
        return reservaSalarios;
    }

    public void setReservaSalarios(double reservaSalarios) {
        this.reservaSalarios = reservaSalarios;
    }

    @Override
    public void receberAviso(Funcionario f) {
        System.out.printf("Funcionario %s trocou as horas trabalhadas para %d%n"
        , f.getNome(), f.getHorasTrabalhadas());
    }

    
    
}