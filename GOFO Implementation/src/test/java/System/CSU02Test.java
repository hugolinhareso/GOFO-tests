package System;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.mockito.MockitoAnnotations;

import UI.SystemUI;

public class CSU02Test {

    private SystemUI sistema;
   
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private final PrintStream standardOut = System.out;
    private final InputStream originalSystemIn = System.in;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        System.setOut(new PrintStream(outputStreamCaptor));
        System.setIn(System.in);
    }

    @Test
    public void TesteSegundoCasoDeUso02() {
        String inputSimulado ="2\nThales\nLacerda\n1\nteste\nthalesdonoPlayground@privado.com\n40028922\nSP\nplayground owner\n123\n3\n3";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        sistema = new SystemUI(); 

        PlaygroundOwner playgroundOwner = new PlaygroundOwner();

        inputSimulado ="1000";
        inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        eWallet eWallet = new eWallet();

        exit.expectSystemExitWithStatus(0);
        sistema.accountMenu();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(originalSystemIn);
    }
}
