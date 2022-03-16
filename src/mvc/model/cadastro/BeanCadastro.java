package mvc.model.cadastro;

/**
 * Bean que representa um registro no banco de dados
 *
 * @author E-mail(salomao@taimber.com)
 * @version 1.0
 */
public class BeanCadastro {

    private Object id;
    private Object nome;

    public BeanCadastro() {

    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getNome() {
        return nome;
    }

    public void setNome(Object nome) {
        this.nome = nome;
    }

}
