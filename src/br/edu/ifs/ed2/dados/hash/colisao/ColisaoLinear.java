/**
 *
 */
package br.edu.ifs.ed2.dados.hash.colisao;

import br.edu.ifs.ed2.dados.hash.Hash;
import br.edu.ifs.ed2.dados.hash.HashAberto;

/**
 * Classe que implementa a técnica linear de tratamento de colisões.
 *
 * @author Marlos Tacio Silva
 *
 */
public class ColisaoLinear<G> implements EstrategiaColisao<G> {

    /**
     *
     */
    @Override
    public int obterIndice(int indiceInicial, Hash<G> tabela) {

        /*
         * Coerção da tabela para um hash aberto.
         */
        HashAberto<G> hash = (HashAberto<G>) tabela;

        /*
         * Inicialização do novo índice.
         */
        int novoIndice = (indiceInicial + 1) % hash.getTamanho();

        /*
         * Aplicação da técnica de endereçamento linear para a busca de uma célula livre
         * a partir do índice inicial.
         */

        if (hash.getEstado()[indiceInicial] == null || hash.getEstado()[indiceInicial].equals("R")) {
            return indiceInicial;
        }

        for (int i = 0; i < tabela.getTamanho(); i++) {

            if (hash.getEstado()[novoIndice] == null || !hash.getEstado()[novoIndice].equals("O")) {
                return novoIndice;
            }

            novoIndice = (novoIndice + 1) % hash.getTamanho();
        }

        /*
         * Indicação de resolução de colisão mal sucedida.
         */
        return -1;
    }

    /**
     *
     */
    @Override
    public int obterIndice(int indiceInicial, Hash<G> tabela, G conteudo) {

        /*
         * Coerção da tabela para um hash aberto.
         */
        HashAberto<G> hash = (HashAberto<G>) tabela;

        /*
         * Inicialização do índice.
         */
        int novoIndice = (indiceInicial + 1) % hash.getTamanho();

        /*
         * Aplicação da técnica de endereçamento linear para a busca de um conteúdo a
         * partir do índice inicial.
         */
        if (hash.getTabela()[indiceInicial] == conteudo) {
            return indiceInicial;
        }

        for (int i = 0; i < tabela.getTamanho(); i++) {
            if (hash.getTabela()[novoIndice] == conteudo ) {
                return novoIndice;
            }

            novoIndice = (novoIndice + 1) % hash.getTamanho();
        }
        /*
         * Indicação de resolução de colisão mal sucedida.
         */
        return -1;
    }
}
