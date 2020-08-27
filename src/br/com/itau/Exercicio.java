package br.com.itau;

import java.util.List;
import java.util.Scanner;

import br.com.itau.modelo.Lancamento;
import br.com.itau.service.LancamentoService;

public class Exercicio {

	public static void main(String[] args) {
		List<Lancamento> lancamentos = new LancamentoService().listarLancamentos();

		Scanner sc = new Scanner(System.in);
		int opcao;
		
		do {
			System.out.println("\n1- Listar lançamentos ordenados por mês.");
			System.out.println("2- Lançamentos de uma mesma categoria de sua escolha.");
			System.out.println("3- Listar lançamentos de um mês da sua escolha.");
			System.out.println("4- Sair. \n");
			
			opcao = sc.nextInt();
			
			if(opcao == 1) {
				for (int j = 1; j <= 12; j++) {
					System.out.println("\nMês " + j);
					for (int i = 0; i < lancamentos.size(); i++) {
						if(lancamentos.get(i).getMes() == j) {
							System.out.println(lancamentos.get(i).toString());
						}
					}
				}
			}
			
			if(opcao == 2) {
				System.out.println("\nDigite a categoria: ");
				int categoria = sc.nextInt();
				System.out.println(" ");
				for (int i = 0; i < lancamentos.size(); i++) {
					if(lancamentos.get(i).getCategoria() == categoria) {
						System.out.println(lancamentos.get(i).toString());
					}
				}
			}
			
			if(opcao == 3) {
				System.out.println("\nDigite o mês: ");
				int mes = sc.nextInt();
				System.out.println(" ");
				double faturaMensal = 0;
				for (int i = 0; i < lancamentos.size(); i++) {
					if(lancamentos.get(i).getMes() == mes) {
						faturaMensal += Double.parseDouble(lancamentos.get(i).getValor().toString());
					}
				}
				System.out.println("Valor da fatura: R$" + String.format("%.2f", faturaMensal));
			}
		} while (opcao != 4);
	}

}
