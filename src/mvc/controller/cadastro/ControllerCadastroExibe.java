package mvc.controller.cadastro;

import java.util.Map;
import mvc.model.cadastro.DaoCadastro;
import mvc.view.telas.sistema.ViewSistema;

/**
 * Exibe os dados cadastrados de um registro na view
 *
 * @author E-mail(salomao@taimber.com)
 * @version 1.0
 */
public class ControllerCadastroExibe {

    /**
     * Exibe os dados
     *
     * @param view View
     * @param id Id do cadastro
     */
    public static void exibir(ViewSistema view, Object id) {

        /* excessão */
        try {

            /* cadastro */
            DaoCadastro cadastro = new DaoCadastro();

            /* dados */
            Map dados = (Map) cadastro.getDadosCadastro((String) id).get(0);

            /* popula */
            view.jTcadastroNome.setText((String) dados.get("nome"));

        } catch (java.lang.IndexOutOfBoundsException ex) {

        }

    }

}
