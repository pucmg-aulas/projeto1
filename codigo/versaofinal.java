import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class versaofinal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Equipamento equipamento1 = new Equipamento("E1", "Escavadeira", 200.0);
        Equipamento equipamento2 = new Equipamento("E2", "Betoneira", 150.0);

        Cliente cliente1 = new Cliente("Cliente A");
        Cliente cliente2 = new Cliente("Cliente B");

        List<Aluguel> alugueis = new ArrayList<>(); 

        int escolha;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Consultar aluguéis do cliente");
            System.out.println("2. Gerar relatório mensal");
            System.out.println("3. Criar aluguel");
            System.out.println("4. Sair");

            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Digite o nome do cliente:");
                    String nomeCliente = scanner.nextLine();
                    Cliente cliente = new Cliente(nomeCliente);
                    consultaCliente(cliente, alugueis);
                    break;
                case 2:
                    System.out.println("Digite o mês (1-12):");
                    int mes = scanner.nextInt();
                    System.out.println("Digite o ano:");
                    int ano = scanner.nextInt();
                    relatorioMensal(mes, ano, alugueis);
                    break;
                case 3:
                    criarAluguel(scanner, alugueis);
                    break;
                case 4:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 4);

        scanner.close();
    }

    public static void consultaCliente(Cliente cliente, List<Aluguel> alugueis) {
        List<Aluguel> alugueisCliente = Aluguel.consultarAlugueisCliente(cliente, alugueis);

        System.out.println("Aluguéis do cliente " + cliente.getNome() + ":");
        for (Aluguel aluguel : alugueisCliente) {
            System.out.println("Equipamento: " + aluguel.getEquipamento().getDescricao()
                    + " | Data Início: " + aluguel.getDataInicio()
                    + " | Data Término: " + aluguel.getDataTermino()
                    + " | Valor Total: " + aluguel.getValorTotal());
        }
    }

    public static void relatorioMensal(int mes, int ano, List<Aluguel> alugueis) {
        double faturamentoMensal = Aluguel.calcularFaturamentoMensal(mes, ano, alugueis);

        System.out.println("Relatório Mensal - " + mes + "/" + ano + ":");
        System.out.println("Faturamento Total: " + faturamentoMensal);
    }

    public static void criarAluguel(Scanner scanner, List<Aluguel> alugueis) {
        System.out.println("Digite o nome do cliente:");
        scanner.nextLine();
        String nomeCliente = scanner.nextLine();
        Cliente cliente = new Cliente(nomeCliente);

        System.out.println("Escolha um equipamento (E1 - Escavadeira, E2 - Betoneira):");
        String codigoEquipamento = scanner.nextLine();

        Equipamento equipamento;
        if (codigoEquipamento.equals("E1")) {
            equipamento = new Equipamento("E1", "Escavadeira", 200.0);
        } else if (codigoEquipamento.equals("E2")) {
            equipamento = new Equipamento("E2", "Betoneira", 150.0);
        } else {
            System.out.println("Equipamento inválido.");
            return;
        }

        System.out.println("Digite a data de início (yyyy-MM-dd):");
        String dataInicio = scanner.nextLine();
        System.out.println("Digite a data de término (yyyy-MM-dd):");
        String dataTermino = scanner.nextLine();

        Aluguel aluguel = new Aluguel(cliente, equipamento, dataInicio, dataTermino);
        alugueis.add(aluguel);

        System.out.println("Aluguel criado com sucesso.");
    }

    static class Equipamento {
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

    static class Cliente {
        private String nome;

        public Cliente(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }
    }

    static class Aluguel {
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
            double numDias = 1.0;
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

        public static double calcularFaturamentoMensal(int mes, int ano, List<Aluguel> alugueis) {
            double faturamentoTotal = 0.0;
            for (Aluguel aluguel : alugueis) {
                // Verificação do mês e ano especificados do aluguel
                // e somar o valor ao faturamentoTotal
            }
            return faturamentoTotal;
        }

        public static List<Aluguel> consultarAlugueisCliente(Cliente cliente, List<Aluguel> alugueis) {
            List<Aluguel> alugueisCliente = new ArrayList<>();
            for (Aluguel aluguel : alugueis) {
                if (aluguel.getCliente().getNome().equals(cliente.getNome())) {
                    alugueisCliente.add(aluguel);
                }
            }
            return alugueisCliente;
        }
    }
}
