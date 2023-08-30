import java.util.ArrayList;
import java.util.List;

class Equipamento {
    private String codigo;
    private String descricao;
    private double valorDiario;

    public Equipamento(String codigo, String descricao, double valorDiario) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valorDiario = valorDiario;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValorDiario() {
        return valorDiario;
    }
}

class Cliente {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Aluguel {
    private static List<Aluguel> alugueis = new ArrayList<>();

    private Cliente cliente;
    private Equipamento equipamento;
    private String dataInicio;
    private String dataTermino;
    private double valorTotal;

    public Aluguel(Cliente cliente, Equipamento equipamento, String dataInicio, String dataTermino) {
        this.cliente = cliente;
        this.equipamento = equipamento;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        double numDias = 1.0; // Para calcular o número de dias de aluguel
        valorTotal = numDias * equipamento.getValorDiario();

        alugueis.add(this);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public static double calcularFaturamentoMensal(int mes, int ano) {
        double faturamentoTotal = 0.0;
        for (Aluguel aluguel : alugueis) {
            // Verificação do mês e ano especificados do aluguel
            // e somar o valor ao faturamentoTotal
        }
        return faturamentoTotal;
    }

    public static List<Aluguel> consultarAlugueisCliente(Cliente cliente) {
        List<Aluguel> alugueisCliente = new ArrayList<>();
        for (Aluguel aluguel : alugueis) {
            if (aluguel.getCliente().getNome().equals(cliente.getNome())) {
                alugueisCliente.add(aluguel);
            }
        }
        return alugueisCliente;
    }
}

public class projeto1_versaoinicial {
    public static void consultaCliente(Cliente cliente) {
        List<Aluguel> alugueisCliente = Aluguel.consultarAlugueisCliente(cliente);

        System.out.println("Aluguéis do cliente " + cliente.getNome() + ":");
        for (Aluguel aluguel : alugueisCliente) {
            System.out.println("Equipamento: " + aluguel.getEquipamento().getDescricao()
                    + " | Data Início: " + aluguel.getDataInicio()
                    + " | Data Término: " + aluguel.getDataTermino()
                    + " | Valor Total: " + aluguel.getValorTotal());
        }
    }

    public static void relatorioMensal(int mes, int ano) {
        double faturamentoMensal = Aluguel.calcularFaturamentoMensal(mes, ano);

        System.out.println("Relatório Mensal - " + mes + "/" + ano + ":");
        System.out.println("Faturamento Total: " + faturamentoMensal);
    }

    public static void main(String[] args) {
        Equipamento equipamento1 = new Equipamento("E1", "Escavadeira", 200.0);
        Equipamento equipamento2 = new Equipamento("E2", "Betoneira", 150.0);

        Cliente cliente1 = new Cliente("Cliente A");
        Cliente cliente2 = new Cliente("Cliente B");

        new Aluguel(cliente1, equipamento1, "2023-08-01", "2023-08-05");
        new Aluguel(cliente2, equipamento2, "2023-08-03", "2023-08-07");

        consultaCliente(cliente1);
        consultaCliente(cliente2);

        relatorioMensal(8, 2023);
    }
}
