package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidade.Funcionario;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		//cria a lista vazia
		List<Funcionario> list = new ArrayList<>();
        
		//obtem os dados do funcionario id nome salario
		System.out.print("Digite a quantidade de funcionários que serão cadastrados? ");
		int n = sc.nextInt();
        
		//for (int i=1; i<=n; i++)
		for (int i = 0; i < n; i++) {
			System.out.println();
			//System.out.println("Employee #" + i + ": ");
			System.out.println("Funcionario #" + (i + 1) + ":");

			System.out.print("Id: ");
			int id = sc.nextInt();
			while (idExiste(list, id)) {
				System.out.print("Id já existe. Tente novamente: ");
				id = sc.nextInt();
			}

			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salario: ");
			double salario = sc.nextDouble();
			//Funcionario func = new Funcionario(id, nome, salario);
			//list.add(func);
			list.add(new Funcionario(id, nome, salario));
		}

		//
		System.out.println();
		System.out.print("Informe o ID do funcionário que terá aumento salarial: ");
		int id = sc.nextInt();
		Funcionario func = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (func == null) {
			System.out.println("Esse ID não existe!");
		} else {
			System.out.print("Entre com o percentual: ");
			double percentual = sc.nextDouble();
			func.aumentoSalario(percentual);
		}

		System.out.println();
		System.out.println("Lista de funcionários:");
		for (Funcionario obj : list) {
			System.out.println(obj);
		}

		sc.close();
	}

	public static boolean idExiste(List<Funcionario> list, int id) {
		Funcionario func = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return func != null;
	}

}
