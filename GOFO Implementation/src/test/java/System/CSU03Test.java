package System;

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

public class CSU03Test {

    private SystemUI sistema;
   
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private final InputStream originalSystemIn = System.in;
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        System.setIn(System.in);
    }

    @Test
    public void testeTerceiroCasoDeUso03() {
        //faço o cadastro novamente para depois logar e testar o Caso de uso.
        String inputSimulado ="2\nThales\nLacerda\n1\nteste\nthalesdonoPlayground@privado.com\n40028922\nSP\nplayer\n123\n"+ 
        "1\nthalesdonoPlayground@privado.com\nteste\n5\nHappyPlayground\n3\nfriday\n1\n12\n3\n";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        sistema = new SystemUI(); 

        Playground playground = new Playground();
        playground.setName("HappyPlayground");
        playground.setOwner("Happy Inc");

        eWallet eWallet = new eWallet();
        eWallet.setBalance(40028922);

        PlaygroundOwner playgroundOwner = new PlaygroundOwner();
        playgroundOwner.setBalance(eWallet);
        playgroundOwner.setFName("Thales");
        playgroundOwner.setLName("Lacerda");
        playgroundOwner.setPassword("teste");
        playgroundOwner.setID(2);
        playgroundOwner.setRule("playground owner");
        playgroundOwner.setPhone(40028922);
        playgroundOwner.setEmail("thalestestesoftware@privado.com");
        playgroundOwner.setLocation("SP");
        playgroundOwner.addPlayground(playground);
        sistema.theOwners.add(playgroundOwner);

        inputSimulado ="500";
        inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        Player player = new Player();

        exit.expectSystemExitWithStatus(0);
        sistema.accountMenu();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(originalSystemIn);
    }
}
