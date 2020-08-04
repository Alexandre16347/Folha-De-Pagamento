package Teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;

import Classes_Importantes.*;
import Listas.*;

public class TesteFolhaDePagameto {
	@Test
	public void TesteAdcionaGerente() {

		assertTrue(ListaDeFuncionario.cadastraEmpregado("Jurema", "Gerente"));
		ListaDeFuncionario.removeEmpregado(0);
	}

	@Test
	public void TesteAdcionaInvalido() {

		assertFalse(ListaDeFuncionario.cadastraEmpregado("Felipe", "Motorista"));
	}

	@Test
	public void TesteAdcionaFuncionario() {

		assertTrue(ListaDeFuncionario.cadastraEmpregado("Jubiscreia", "Funcionário"));
		ListaDeFuncionario.removeEmpregado(0);
	}

	@Test
	public void TesteRecuperaEmpregado() {
		ListaDeFuncionario.cadastraEmpregado("Jucleidy", "Gerente");
		Empregado p = ListaDeFuncionario.recuperaEmpregado(0);

		assertTrue(p != null);
		ListaDeFuncionario.removeEmpregado(0);

	}

	@Test
	public void TesteRecuperaEmpregadoNome() {
		ListaDeFuncionario.cadastraEmpregado("Jucridy", "Gerente");
		Empregado p = ListaDeFuncionario.recuperaEmpregado(0);

		assertEquals(p.getNome(), "Jucridy");
		ListaDeFuncionario.removeEmpregado(0);

	}

	@Test
	public void TesteRecuperaEmpregadoSalario() {
		ListaDeFuncionario.cadastraEmpregado("Xerendy", "Gerente");
		Empregado p = ListaDeFuncionario.recuperaEmpregado(0);
		double resultado = p.getSalario();
		assertTrue(resultado == 4000.0);
		ListaDeFuncionario.removeEmpregado(0);

	}

	@Test
	public void TesteRecuperaEmpregadoCargo() {
		ListaDeFuncionario.cadastraEmpregado("Jubileia", "Gerente");
		Empregado p = ListaDeFuncionario.recuperaEmpregado(0);
		String resultado = p.getCargo();
		assertEquals(resultado, "Gerente");
		ListaDeFuncionario.removeEmpregado(0);

	}

	@Test
	public void TesteRemoveEmpregado() {
		ListaDeFuncionario.cadastraEmpregado("Jubileia", "Gerente");
		assertTrue(ListaDeFuncionario.removeEmpregado(0));

	}

	@Test
	public void TesteRemoveEmpregadoFalse() {
		assertFalse(ListaDeFuncionario.removeEmpregado(0));

	}

	@Test
	public void TesteRecuperaListaDeFuncionario() {
		ArrayList<Empregado> resultado = ListaDeFuncionario.getListaDeEmpregados();
		assertTrue(resultado != null);
	}

	@Test
	public void TesteRecuperaListaDeFuncionarioVazia() {
		ArrayList<Empregado> resultado = ListaDeFuncionario.getListaDeEmpregados();
		assertTrue(resultado.isEmpty());
	}

	@Test
	public void TesteAdicionaGratificacaoDesempenho() {
		ListaDeFuncionario.cadastraEmpregado("Jubiscreyton", "Gerente");
		boolean resultado = ListaDeGratificacoes.adicionaGratificacao(0, "10/02");
		assertTrue(resultado);
		ListaDeFuncionario.removeEmpregado(0);
	}

	@Test
	public void TesteAdicionaGratificacaoHoraExtra() {
		ListaDeFuncionario.cadastraEmpregado("Jubiscreyton", "Funcionário");
		boolean resultado = ListaDeGratificacoes.adicionaGratificacao(0, "10/02", 10);
		assertTrue(resultado);
		ListaDeFuncionario.removeEmpregado(0);
	}

	@Test
	public void TesteRemoveGratificacaoDesempenho() {
		ListaDeFuncionario.cadastraEmpregado("Jubiscreyton", "Gerente");
		ListaDeGratificacoes.adicionaGratificacao(0, "10/02");
		boolean resultado = ListaDeGratificacoes.removeGratificacao(0, 0);
		assertTrue(resultado);
		ListaDeFuncionario.removeEmpregado(0);
	}

	@Test
	public void TesteRemoveGratificacaoHoraExtra() {
		ListaDeFuncionario.cadastraEmpregado("Jubiscreyton", "Gerente");
		ListaDeGratificacoes.adicionaGratificacao(0, "10/02", 10);
		boolean resultado = ListaDeGratificacoes.removeGratificacao(0, 0);
		assertTrue(resultado);
		ListaDeFuncionario.removeEmpregado(0);
	}

	@Test
	public void TesteRecuperaListaDeGratificacoes() {
		ListaDeFuncionario.cadastraEmpregado("Jubiscreyton", "Gerente");
		ListaDeGratificacoes.adicionaGratificacao(0, "25/11");
		ListaDeGratificacoes.adicionaGratificacao(0, "10/02", 10);
		Map<Empregado, Vencimento> resultado = ListaDeGratificacoes.getListaDeGratificacoes();
		assertTrue(resultado != null);
		ListaDeFuncionario.removeEmpregado(0);
	}

	@Test
	public void TesteAdcionaVencimento() {

		Vencimento v = new Vencimento();
		boolean resultado = v.adicionaNaLista(new Desempenho(2500, "10/06"));
		assertTrue(resultado);
	}

	@Test
	public void TesteRemoveVencimento() {

		Vencimento w = new Vencimento();
		w.adicionaNaLista(new Desempenho(2500, "10/06"));
		w.removeDaLista(0);
		ArrayList<Gratificacao> resultado = w.getLista();
		assertTrue(resultado.isEmpty());

	}

	@Test
	public void TesteModificaVencimento() {

		Vencimento w = new Vencimento();
		w.adicionaNaLista(new Desempenho(2500, "15/09"));
		w.recuperaDaLista(0).setDataTrabalhada("10/06");
		Datas d = w.recuperaDaLista(0).getDataTrabalhada();
		assertEquals(d.toString(),"10/6");

	}

}