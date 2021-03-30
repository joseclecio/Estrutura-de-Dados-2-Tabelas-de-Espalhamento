/**
 * 
 */
package br.edu.ifs.ed2.dados.hash.colisao;

import br.edu.ifs.ed2.dados.hash.Hash;
import br.edu.ifs.ed2.dados.hash.HashEncadeado;

/**
 * Classe que implementa a operação de tratamento de colisões na tabela.
 * 
 * @author Marlos Tacio Silva
 *
 */
public class ColisaoEncadeada<G> implements EstrategiaColisao<G> {

	/**
	 * 
	 */
	@Override
	public int obterIndice(int indiceInicial, Hash<G> tabela) {

		/*
		 * Inicialização do novo índice.
		 */
		int novoIndice = 0;

		/*
		 * Resolução da colisão e, consequentemente, cálculo do novo valor do índice.
		 */


		/*
		 * Retorno do novo índice.
		 */
		return indiceInicial;
	}

	@Override
	public int obterIndice(int indiceInicial, Hash<G> tabela, G conteudo) {

		/*
		 * Coerção da tabela para um hash encadeado.
		 */
		HashEncadeado<G> hash = (HashEncadeado<G>) tabela;

		int novoIndice = 0;

		/*
		 * Se a célula do índice em questão estiver vazia então a obtenção de índice
		 * será mal sucedida.
		 */

		if (hash.getTabela()[indiceInicial] == null){
			return -1;
		}

		/*
		 * Se o conteúdo a ser buscado não estiver na lista referente ao índice em
		 * questão então a obtenção de índice será mal sucedida.
		 */

		if (hash.getTabela()[indiceInicial].buscar(conteudo) == null){
			return -1;
		}

		/*
		 * Retorno do índice em que o conteúdo está alocado.
		 */
		return indiceInicial;
	}

}
