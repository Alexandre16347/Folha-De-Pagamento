package MaquinaHumano;

import java.util.Scanner;

import Classes_Importantes.Empregado;
import Classes_Importantes.Gratificacao;
import Classes_Importantes.TipoGratificacao;
import Listas.ListaDeFuncionario;
import Listas.ListaDeGratificacoes;

public class IU {

	private static Scanner ler;											//Criando os atributos de leitura do teclado

	/*
	 * "SubMenu Funcionario e Gratificacao"
	 * 
	 * + Recupera Dados 
	 * + Atualiza Dados 
	 * + Mostra Lista de Gratificacao 
	 * + Adiciona
	 * + Gratificacao 
	 * 		= Hora Extra 
	 * 		= Desemprenho
	 * + Remove Gratificacao // passa o indice da gratificacao 
	 * + Atualiza Gratificacao
	 * + Voltar
	 */
	
	//Menu Principal que ir� ser exibido;
	private static void menuPrincipal() {
		System.out.println("\n\n------ MENU DE PRINCIPAL ------\n");
		System.out.println("[1] Menu de empregados");
		System.out.println("[2] Folha de pagamento");
		System.out.println("[0] SAIR");
		System.out.print("\nDigite sua op��o: ");
	}

	//Menu de funcion�rio que ir� ser exibido;
	private static void menuDeFuncionario() {

		System.out.println("\n\n------ MENU DE EMPREGADO ------\n");
		System.out.println("[1] Recupera lista de empregados");
		System.out.println("[2] Acessar Empregado");
		System.out.println("[3] Cadastrar Novo Empregado");
		System.out.println("[0] Voltar ao menu anterior");

		System.out.print("\nDigite sua op��o: ");

	}

	//Sub menu de funcion�rio que ir� ser exibido;
	private static void subMenuDeFuncionario(Empregado e) {

		System.out.println("\n\n------ MENU DO EMPREGADO " + e.getNome() + " ------\n");
		System.out.println("[1] Recupera Dados");
		System.out.println("[2] Atualiza Dados");
		System.out.println("[3] Mostrar Lista de Gratificao");
		System.out.println("[4] Adicionar Gratificacao");
		System.out.println("[5] Excluir Gratificacao");
		System.out.println("[6] Excluir Empregado");
		System.out.println("[7] Atualizar Gratificacao");
		System.out.println("[0] Voltar ao menu anterior");

		System.out.print("\nDigite sua op��o: ");

	}

	//Menu de Gratifica��o que ir� ser exibido;
//	private static void menuDeGratificacao() {
//		System.out.println("------ MENU DE GRATIFICA��O ------");
//		System.out.println("[1] Cadastrar Nova Gratificacao");
//		System.out.println("[2] Atualiza Gratificao");
//		System.out.println("[3] Recupera Lista de um Empregado");
//		System.out.println("[3] Recupera Lista Completa");
//		System.out.println("[0] Voltar ao menu anterior\n");
//		System.out.print("Digite sua op��o: ");
//	}

	
	//Criando o menu d que ir� atualizar uma gratifica��o;
	private static void menuAtualizaGratificacao(TipoGratificacao tp) {

		//Condi��o para saber se a gratifica��o � por desmepenho ou por hora extra;
		if (tp == TipoGratificacao.Hora_extra) {
			System.out.println("\n\n------ MENU DE ATUALIZA��O ------\n");
			System.out.println("[1] Atualiza data trabalhada");
			System.out.println("[2] Atualiza hora trabalhada");
			System.out.println("[3] Atualiza data e hora trabalhada");
			System.out.println("[0] Voltar ao menu anterior");
			System.out.print("\nDigite sua op��o: ");
		} else {
			System.out.println("\n\n------ MENU DE ATUALIZA��O ------\n");
			System.out.println("[1] Atualiza data trabalhada");
			System.out.println("[0] Voltar ao menu anterior");
			System.out.print("\nDigite sua op��o: ");
		}

	}

	//Menu que atualiza funcion�rio que ir� ser exibido;
	private static void menuAtualizaFuncionario() {

		System.out.println("\n\n------ MENU DE ATUALIZA��O ------\n");
		System.out.println("[1] Atualiza nome e sal�rio");
		System.out.println("[2] Atualiza nome");
		System.out.println("[3] Atualiza sal�rio");
		System.out.println("[0] Voltar ao menu anterior");
		System.out.print("\nDigite sua op��o: ");
	}

	//Criando a interface de usu�rio principal;
	public static void IUPrincipal() {
		int op;
		ler = new Scanner(System.in);

		do {
			menuPrincipal();											//Chama o print do menu com suas opcoes 
			op = ler.nextInt();											//Le a 
			switch (op) {
			case 1:
				IUdeFuncionario();
				break;
			case 2:
				ListaDeGratificacoes.mostraFolhaDePagamento();
				break;
			case 0:
				System.out.println("Saindo .....");
				break;
			default:
				System.out.println("Opcao invalida, digite novamente.");
				break;
			}
		} while (op != 0);
	}

	//Criando a interface de usu�rio que ir� fazer as modifica��es poss�veis em um empregado;
	public static void IUdeFuncionario() {
		ler = new Scanner(System.in);
		int opf;

		do {
			menuDeFuncionario();
			opf = ler.nextInt();

			switch (opf) {

			case 1:

				ListaDeFuncionario.recuperaListaDeEmpregados();

				break;

			case 2:

				System.out.print("Digite o indice do empregado a ser acessado: ");
				int ep = ler.nextInt();
				IUSubFuncionario(ep);
				break;

			//op��o em caso de execu��o de um cadastro de empregado;
			case 3:
				String nome;
				String cargo = "";
				int f = 1;

				while (true) {
					System.out.println("------ MENU DE CADASTRO ------");
					System.out.println("[1] Funcionario");
					System.out.println("[2] Gerente");
					System.out.print("Cargo: ");
					int c = ler.nextInt();
					switch (c) {
					case 1:
						cargo = "Funcion�rio";
						f = 0;
						break;
					case 2:
						cargo = "Gerente";
						f = 0;
						break;
					default:
						System.out.println("Opcao invalida");
						break;
					}
					if (f == 0)		//condicional para sair do la�o infinito;
						break;
				}
				while (true) {
					
					//Bloco try catch para tratar a exce��o caso o usu�rio digite algo que n�o seja letras; 
					try {
						System.out.print("\nNome: ");
						nome = ler.next();
						for (int i = 0; i < nome.length(); i++) {
							Character caractere = nome.charAt(i);
							if (Character.isDigit(caractere)) {
								throw new Exception();
							}
						}
						ListaDeFuncionario.cadastraEmpregado(nome, cargo);
						System.out.println("\nEMPREGADO CADASTRADO");
						break;
					} catch (Exception e) {
						System.err.println(
								"\nErro!!\n Verifique se o nome esta correto (Sem numeros)\nVerifique se o cargo existe");
					}
				}

				break;

			case 0:
				break;
			default:
				System.out.println("Opcao invalida, digite novamente.");
				break;

			}
		} while (opf != 0);		//condi��o para sair do la�o infinito;
	}
	
	//Criando sub interface de usu�rio, na qual mostra as op��es poss�veis de um empregado;
	private static void IUSubFuncionario(int ep) {
		Empregado e = ListaDeFuncionario.recuperaEmpregado(ep);
		if (e != null) {

			ler = new Scanner(System.in);
			int ops;
			do {
				subMenuDeFuncionario(e);
				ops = ler.nextInt();

				switch (ops) {
				case 1:
					System.out.println(e);
					break;
				case 2:
					IUAtualizaFuncionario(e);
					break;

				case 3:
					ListaDeGratificacoes.mostraLista(ep);
					break;
					
				//Tela que adiciona uma gratifica��o a um empregado;
				case 4:
					int opg;
					boolean f = true;
					while (f) {
						System.out.println("[1] Hora Extra");
						System.out.println("[2] Desempenho");
						System.out.print("Opcao: ");
						opg = ler.nextInt();
						switch (opg) {
						case 1:
							System.out.println("------ MENU DE CADASTRO GRATIFICACAO ------");

							System.out.print("Quantidade de horas trabalhada: ");
							int hora = ler.nextInt();

							System.out.print("Data Trabalhada: ");
							String data = ler.next();

							if(ListaDeGratificacoes.adicionaGratificacao(ep, data, hora))
								System.out.println("GRATIFICACAO ADICIONADA");
							f = false;
							break;
							
						//Tela que ir� cadastrar uma gratifica��o a um empregado;
						case 2:
							System.out.println("------ MENU DE CADASTRO ------");

							System.out.print("Data Trabalhada: ");
							String data1 = ler.next();

							if(ListaDeGratificacoes.adicionaGratificacao(ep, data1))
								System.out.println("GRATIFICACAO ADICIONADA");
							f = false;
							break;
						default:
							System.out.println("Opcao invalida ...");
							break;
						}
					}
					break;
				case 5:

					System.out.print("Qual o indice da gratificacao: ");
					int opg1 = ler.nextInt();
					ListaDeGratificacoes.removeGratificacao(ep, opg1);

					break;
				case 6:
					ListaDeFuncionario.removeEmpregado(ep);
					ops = 0;
				case 0:
					break;
				case 7:
					System.out.print("Qual o indice da gratificacao: ");
					int opg2 = ler.nextInt();
					IUAtualizaGratificacao(ep, opg2);
					break;
				default:
					System.out.println("Opcao invalida, digite novamente.");
					break;
				}

			} while (ops != 0);		//Condi��o para sair do la�o infinito;
		}

	}

	//Tela que faz as a��es poss�veis na gratifica��o de um funcion�rio;
	private static void IUAtualizaGratificacao(int ep, int opg2) {
		Gratificacao g = ListaDeGratificacoes.recuperaGratificacao(ep, opg2);

		//Condi��o para testar se a lista de gratifica��es n�o � nula;
		if (g != null) {
			TipoGratificacao tp = g.getTipo();
			ler = new Scanner(System.in);
			int opg;

			do {

				menuAtualizaGratificacao(tp);

				opg = ler.nextInt();

				//Tela para cadastrar uma gratifica��o por desempenho ou por hora_extra;
				switch (tp) {
				case Desempenho:
					switch (opg) {
					case 1:
						System.out.print("Digite a nova data: ");
						String data = ler.next();
						if(ListaDeGratificacoes.recuperaGratificacao(ep, opg2).setDataTrabalhada(data))
							System.out.println("ATUALIZADA COM SUCESSO");
						break;
					case 0:
						break;
					default:
						System.out.println("Opcao Invalida");
						break;
					}
					break;
				case Hora_extra:
					switch (opg) {
					case 1:
						System.out.print("Digite a nova data: ");
						String data = ler.next();
						ListaDeGratificacoes.recuperaGratificacao(ep, opg2).setDataTrabalhada(data);
						System.out.println("ATUALIZADA COM SUCESSO");
						break;
					case 2:
						System.out.print("Digite a nova hora trabalhada: ");
						int hora = ler.nextInt();
						ListaDeGratificacoes.recuperaGratificacao(ep, opg2)
								.calculaGratificacao(ListaDeFuncionario.recuperaEmpregado(ep).getSalario(), hora);
						System.out.println("ATUALIZADA COM SUCESSO");
						break;
					case 3:
						System.out.print("Digite a nova data: ");
						String data1 = ler.next();
						ListaDeGratificacoes.recuperaGratificacao(ep, opg2).setDataTrabalhada(data1);
						System.out.println("Digite a nova hora trabalhada: ");
						int hora1 = ler.nextInt();
						ListaDeGratificacoes.recuperaGratificacao(ep, opg2)
								.calculaGratificacao(ListaDeFuncionario.recuperaEmpregado(ep).getSalario(), hora1);
						System.out.println("ATUALIZADA COM SUCESSO");
						break;
					case 0:
						break;
					default:
						System.out.println("Opcao Invalida");
						break;
					}
					break;
				}

			} while (opg != 0);		//Condi��o para sair do la�o infinito;
		}

	}

	//Interface de usu�rio que atualiza um funcion�rio;
	private static void IUAtualizaFuncionario(Empregado e) {
		int opsf;
		do {
			menuAtualizaFuncionario();
			opsf = ler.nextInt();
			switch (opsf) {

			case 1:
				System.out.print("Novo Nome: ");
				String nome = ler.next();
				e.setNome(nome);
				System.out.print("Novo Salario: ");
				Double salario = ler.nextDouble();
				e.setSalario(salario);
				break;
			case 2:
				System.out.print("Novo Nome: ");
				String nome1 = ler.next();
				e.setNome(nome1);
				break;
			case 3:
				System.out.print("Novo Salario: ");
				Double salario1 = ler.nextDouble();
				e.setSalario(salario1);
				break;
			case 0:
				break;
			default:
				System.out.println("Opcao invalida");
				break;
			}
		} while (opsf != 0);		//Condi��o de sa�da do la�o infinito;

	}
}
