package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Contribuinte> list = new ArrayList<>();

		System.out.print("Digite o número de contribuintes: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Dados do contribuinte #" + i);
			System.out.print("Pessoa Física ou Pessoa Jurídica (f/j)? ");
			char ch = sc.next().charAt(0);

			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();

			System.out.print("Renda Anual: ");
			double rendaAnual = sc.nextDouble();

			if (ch == 'f') {
				System.out.print("Gastos com Saúde: ");
				double gastosSaude = sc.nextDouble();
				list.add(new PessoaFisica(nome, rendaAnual, gastosSaude));

			} else {
				System.out.print("Número de funcionários: ");
				int numFuncionario = sc.nextInt();
				list.add(new PessoaJuridica(nome, rendaAnual, numFuncionario));
			}
			System.out.println();
		}

		double somaImpostos = 0.0;

		System.out.println("\nCONTRIBUINTES:");

		for (Contribuinte contribuinte : list) {
			System.out.println(contribuinte);
			somaImpostos += contribuinte.imposto();
		}

		System.out.printf("\nIMPOSTO TOTAL: R$ %.2f", somaImpostos);

		sc.close();

	}

}
