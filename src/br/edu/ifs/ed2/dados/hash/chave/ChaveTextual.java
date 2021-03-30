/**
 * 
 */
package br.edu.ifs.ed2.dados.hash.chave;

/**
 * Classe que implementa uma operação de construção de chaves textuais a partir
 * do exemplo a seguir:
 * 
 * Conteúdo: Uva
 * 
 * 1º passo: transformação da palavra em letras minúscula e obtenção do código
 * ASCII de cada caractere
 * 
 * u: 117 v: 118 a: 97
 * 
 * 2º passo: produto entre o código de cada caractere e um número primo elevado
 * à posição inversa desse caractere
 * 
 * u: 117 * 31 ^ 2 = 112 437 
 * v: 118 * 31 ^ 1 = 3 658 
 * a: 97 * 31 ^ 0 = 97
 * 
 * 3º passo: somatório dos valores calculados
 * 
 * chave = 116 192
 * 
 * @author Marlos Tacio Silva
 *
 */
public class ChaveTextual implements EstrategiaChave<String> {

	/**
	 *
	 */
	@Override
	public int gerarChave(String conteudo) {

		/*
		 * Inicialização da chave.
		 */
		int chave = 0;

		/*
		 * Cálculo da chave.
		 */

		conteudo = conteudo.toLowerCase();

		for (int i=0;i<conteudo.length();i++){

			chave += conteudo.charAt(i)*(int) Math.pow(31,conteudo.length()-1-i);

		}

		/*
		 * Retorno da chave.
		 */
		return chave;
	}
}
