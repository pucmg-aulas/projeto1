[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-718a45dd9cf7e7f842a935f5ebbe5719a5e09af4491e668f4dbf3b35d5cca122.svg)](https://classroom.github.com/online_ide?assignment_repo_id=11600669&assignment_repo_type=AssignmentRepo)

# Laboratório de Programação Modular - Controle de Aluguéis de Equipamentos
Este é um sistema de gerenciamento de aluguel desenvolvido em Java. O sistema permite o registro e rastreamento de aluguéis de equipamentos para clientes, além de gerar relatórios mensais de faturamento. O projeto é organizado em classes que representam diferentes entidades e funcionalidades do sistema.

## Alunos integrantes da equipe

* Arthur Athayde de Queiroz
* Enrico Menicucci Gomes
* Lucas Ribeiro do Nascimento
* Luís Felipe Teixeira Dias
* Victor Reis Carlota

  ---
## Professor responsável 

* Danilo Boechat Seufitelli

---
## Funcionalidades
* Equipamento: A classe Equipamento representa os itens disponíveis para aluguel. Cada equipamento possui um código único, uma descrição e um valor de aluguel diário.
* Cliente: A classe Cliente representa os clientes que alugam os equipamentos. Cada cliente é identificado pelo seu nome.
* Aluguel: A classe Aluguel registra uma transação de aluguel. Cada aluguel está associado a um cliente, um equipamento, datas de início e término, e um valor total calculado com base no número de dias de 
  aluguel.
* GerenciadorAlugueis: A classe GerenciadorAlugueis controla o registro de aluguéis e fornece funcionalidades como calcular o faturamento mensal e consultar aluguéis de um cliente específico.
* Funções de Relatório: O projeto inclui funções para gerar relatórios. A função consultaCliente exibe os aluguéis de um cliente específico, enquanto a função relatorioMensal gera um relatório de 
  faturamento total para um mês e ano especificados.

