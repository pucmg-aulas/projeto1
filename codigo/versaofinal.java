/*  ? Documentação:

    consultaCliente(Cliente cliente, List<Aluguel> alugueis)
    Retorna uma lista de aluguéis de um cliente específico.

    relatorioMensal(int mes, int ano, List<Aluguel> alugueis)
    Retorna o faturamento total de um mês e ano específicos.

    criarAluguel(Scanner scanner, List<Aluguel> alugueis)
    Cria um novo aluguel e adiciona na lista de aluguéis.

    Equipamento
    Classe que representa um equipamento.
    Possui os atributos código, descrição e valor diário.

    Cliente
    Classe que representa um cliente.
    Possui apenas o atributo nome.

    Aluguel
    Classe que representa um aluguel.
    Possui métodos estáticos para consultar aluguéis de um cliente específico e calcular o faturamento mensal.

    main(String[] args)
    Função principal do programa.

    O programa possui um menu com as seguintes opções:
    1 - Consultar aluguéis de cliente específico
    2 - Gerar relatório mensal
    3 - Criar aluguel
    4 - Sair

    A opção 1 pede o nome do cliente e retorna os aluguéis do cliente.
    A opção 2 pede o mês e ano e retorna o faturamento total do mês e ano.
    A opção 3 pede o nome do cliente, o equipamento, a data de início e a data de término do aluguel.
    A opção 4 sai do programa.

    O programa possui uma lista de aluguéis que é passada como parâmetro para os métodos.
    A lista de aluguéis é inicializada com dois aluguéis de exemplo.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class versaofinal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Equipamento equipamento1 = new Equipamento("E5134", "Escavadeira", 200.0);
        Equipamento equipamento2 = new Equipamento("B2549", "Betoneira", 150.0);

        Cliente cliente1 = new Cliente("Cliente A");
        Cliente cliente2 = new Cliente("Cliente B");

        List<Aluguel> alugueis = new ArrayList<>(); 

        int escolha = 0;

        while (escolha != 4) {
            System.out.println("\nEscolha uma opção:\n");
            System.out.println("1 - Consultar aluguéis de cliente específico");
            System.out.println("2 - Gerar relatório mensal");
            System.out.println("3 - Criar aluguel");
            System.out.println("4 - Sair\n");

            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    scanner.nextLine();
                    System.out.println("\nDigite o nome do cliente:");
                    String nomeClienteDesformatado = scanner.nextLine();
                    String nomeCliente = nomeClienteDesformatado.toUpperCase();
                    Cliente cliente = new Cliente(nomeCliente);
                    consultaCliente(cliente, alugueis);
                    break;
                case 2:
                    System.out.println("\nDigite o mês (1-12):");
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
        } 

        scanner.close();
    }

    public static void consultaCliente(Cliente cliente, List<Aluguel> alugueis) {
        List<Aluguel> alugueisCliente = Aluguel.consultarAlugueisCliente(cliente, alugueis);

        System.out.println("\nAluguéis do cliente " + cliente.getNome() + ":");
        for (Aluguel aluguel : alugueisCliente) {
            System.out.println("Equipamento: " + aluguel.getEquipamento().getDescricao()
                    + " | Data Início: " + aluguel.getDataInicio()
                    + " | Data Término: " + aluguel.getDataTermino()
                    + " | Valor Total: " + aluguel.getValorTotal());
        }

        if (alugueisCliente.size() == 0) {
            System.out.println("Nenhum aluguel encontrado.");
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

        System.out.println("Escolha um equipamento (E5134 - Escavadeira, B2549 - Betoneira):");
        String codigoEquipamento = scanner.nextLine();

        

        Equipamento equipamento;
        if (codigoEquipamento.equals("E5134")) {
            equipamento = new Equipamento("E5134", "Escavadeira", 200.0);
        } else if (codigoEquipamento.equals("B2549")) {
            equipamento = new Equipamento("B2549", "Betoneira", 150.0);
        } else {
            System.out.println("Equipamento inválido.");
            return;
        }

        for (Aluguel aluguel : alugueis) {
            if (aluguel.getEquipamento().getCodigo().equals(codigoEquipamento)) {
                System.out.println("Este equipamento já foi alugado.");
                return;
            }
        }

        System.out.println("Digite a data de início (YYYY-MM-DD):");
        String dataInicio = scanner.nextLine();
        System.out.println("Digite a data de término (YYYY-MM-DD):");
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
            this.nome = nome.toUpperCase();
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

                String[] dataInicio = aluguel.getDataInicio().split("-");
                String[] dataTermino = aluguel.getDataTermino().split("-");
                int mesInicio = Integer.parseInt(dataInicio[1]);
                int anoInicio = Integer.parseInt(dataInicio[0]);
                int mesTermino = Integer.parseInt(dataTermino[1]);
                int anoTermino = Integer.parseInt(dataTermino[0]);

                if (anoInicio == ano && anoTermino == ano) {
                    if (mesInicio == mes && mesTermino == mes) {
                        faturamentoTotal += aluguel.getValorTotal();
                    } else if (mesInicio == mes && mesTermino > mes) {
                        faturamentoTotal += aluguel.getValorTotal();
                    } else if (mesInicio < mes && mesTermino == mes) {
                        faturamentoTotal += aluguel.getValorTotal();
                    } else if (mesInicio < mes && mesTermino > mes) {
                        faturamentoTotal += aluguel.getValorTotal();
                    }
                } else if (anoInicio == ano && anoTermino > ano) {
                    if (mesInicio == mes) {
                        faturamentoTotal += aluguel.getValorTotal();
                    } else if (mesInicio < mes) {
                        faturamentoTotal += aluguel.getValorTotal();
                    }
                } else if (anoInicio < ano && anoTermino == ano) {
                    if (mesTermino == mes) {
                        faturamentoTotal += aluguel.getValorTotal();
                    } else if (mesTermino > mes) {
                        faturamentoTotal += aluguel.getValorTotal();
                    }
                } else if (anoInicio < ano && anoTermino > ano) {
                    faturamentoTotal += aluguel.getValorTotal();
                }
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
