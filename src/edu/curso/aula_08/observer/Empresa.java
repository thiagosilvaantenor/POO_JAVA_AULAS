package observer;
public class Empresa {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario("001", "Joao", 100, 1800.0);
        
        Funcionario f2 = new Funcionario("002", "Maria", 80, 1900.0);
        
        FolhaPagamento fp = new FolhaPagamento();
        f1.adicionarAssinante(fp);
        f2.adicionarAssinante(fp);

        f1.setHorasTrabalhadas(130);
        f2.setHorasTrabalhadas(120);
        

    }
}
