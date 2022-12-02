import org.apache.http.HttpStatus;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;

public class TestingClientAPI {

    private static final String SERVICO_CLIENTE =
            "https://tester-global-cliente-api.herokuapp.com/";
    private static final String RECURSO_CLIENTE = "/cliente";
    private static final String APAGA_TODOS_CLIENTES = "/apagaTodos";
    private static final String LISTA_CLIENTES_VAZIA = "{}";


    @Test
    @DisplayName("Quando eu requisitar a lista de clientes" +
            " sem adicionar clientes antes, entao" +
            " ela deve estar vazia")
    public void quandoSolicitarListaVazia_EntaoListaVazia()
    {
        apagaTodosClientesServidor();
    }


    private void apagaTodosClientesServidor()
    {
        when().
                delete(SERVICO_CLIENTE+RECURSO_CLIENTE+APAGA_TODOS_CLIENTES).
        then().
                statusCode(HttpStatus.SC_OK).
                assertThat().body(new IsEqual(LISTA_CLIENTES_VAZIA));
    }

}
