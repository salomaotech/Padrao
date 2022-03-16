package mvc.controller.cadastro;

import javax.swing.JOptionPane;
import mvc.model.cadastro.BeanCadastro;
import mvc.model.cadastro.DaoCadastro;
import mvc.view.telas.sistema.ViewSistema;

/**
 * Pega os dados da view e grava no banco de dados
 *
 * @author E-mail(salomao@taimber.com)
 * @version 1.0
 */
public class ControllerCadastroGrava {

    /**
     * Grava os dados
     *
     * @param view View
     * @param id ID do cadastro
     */
    public static void gravar(ViewSistema view, Object id) {

        /* cadastro */
        BeanCadastro cadastro = new BeanCadastro();
        cadastro.setId(id);
        cadastro.setNome(view.jTcadastroNome.getText());

        /* cadastro */
        DaoCadastro cadastroDao = new DaoCadastro();

        /* validad dados */
        if (isDadosValidados(view)) {

            /* grava */
            if (cadastroDao.gravar(cadastro)) {

                /* Informa que o cadastro foi realizado */
                JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");

            }

        }

    }

    /* valida os dados */
    private static boolean isDadosValidados(ViewSistema view) {

        /* retorno */
        return true;

    }

}
