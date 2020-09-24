import EjemploSemaforos.Comprobacion;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class ComprobacionConTest {

    public ComprobacionConTest() {
    }
    @BeforeAll
    public static void setUpClass() {
    }
    @AfterAll
    public static void tearDownClass() {
    }
    @BeforeEach
    public void setUp() {
    }
    @AfterEach
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void compruebaMensajeFarolas_isOk_Test() {
        //1. Inicialización del entorno
       String mensaje = "{farolaNumero:1, valor:10}";

        //2. Ejecución del código
        boolean resultado= Comprobacion.compruebaMensajeFarolas(mensaje);

        //3. Comprobación de resultados
        Assertions.assertTrue(resultado);

    }
    @Test
    public void compruebaMensajeFarolas_isNotOk_Test() {
        //1. Inicialización del entorno
        String mensaje = "{farolaNumero:1t, valor:10}";

        //2. Ejecución del código
        boolean resultado= Comprobacion.compruebaMensajeFarolas(mensaje);

        //3. Comprobación de resultados
        boolean expected= false;
        Assertions.assertFalse(resultado);

    }
}
