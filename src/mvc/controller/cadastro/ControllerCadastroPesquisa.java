package mvc.controller.cadastro;

import br.com.taimber.persistencia.sql.SqlCompletaQuery;
import br.com.taimber.swings.MudaCorLinhaJtable;
import br.com.taimber.swings.Paginador;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import mvc.model.cadastro.DaoCadastro;
import mvc.view.telas.sistema.ViewSistema;
import sistema.model.BancoFactory;
import sistema.model.PesquisaRegistro;

/**
 * Pesquisa os dados e apresenta os resultados na view
 *
 * @author E-mail(salomao@taimber.com)
 * @version 1.0
 */
public class ControllerCadastroPesquisa {

    /**
     * Exibe os dados
     *
     * @param view View
     */
    public static void pesquisar(ViewSistema view) {

        /* entidades */
        Map entidadesPesquisa = new LinkedHashMap();
        entidadesPesquisa.put("nome", view.jTcadastroPesquisaNome.getText());

        /* completa query */
        SqlCompletaQuery completaQuery = new SqlCompletaQuery(entidadesPesquisa, view.jCcadastroPaginador.getSelectedItem(), new DaoCadastro().getTabela(), false);

        /* colunas a serem pesquisadas */
        List colunasTabela = new ArrayList();
        colunasTabela.add("id");
        colunasTabela.add("nome");

        /* dados */
        List dados = new PesquisaRegistro().executar(new DaoCadastro().getTabela(), completaQuery, colunasTabela, null, "order by nome asc");

        /* default model */
        DefaultTableModel model = (DefaultTableModel) view.jTcadastroLista.getModel();
        model.setNumRows(0);

        /* contador */
        int contador = 0;

        /* list com cores */
        List cores = new ArrayList();

        /* listando os dados */
        for (Object linha : dados) {

            /* map de dados */
            Map dadosMap = (Map) linha;

            /* objeto linha */
            Object[] linhaJtable = new Object[]{
                dadosMap.get("id"),
                dadosMap.get("nome")

            };

            /* insere a linha */
            model.insertRow(contador, linhaJtable);

            /* atualiza o contador */
            contador++;

        }

        /* muda a cor da jtable */
        MudaCorLinhaJtable.mudar(view.jTcadastroLista, cores);

        /* paginador */
        Paginador paginador = new Paginador(view.jCcadastroPaginador, new DaoCadastro().getTabela(), completaQuery.completar(false, null, null));
        paginador.popular(new BancoFactory(true).getBanco());

    }

}
