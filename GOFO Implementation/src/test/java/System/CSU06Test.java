package System;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.MockitoAnnotations;

import UI.SystemUI;

public class CSU06Test {

    @Rule
    public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    private SystemUI sistema;
    private Playground playground;
    private Administrator administrator;
    private PlaygroundOwner playgroundOwner;
    
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private final PrintStream standardOut = System.out;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testeSextoCasoDeUso06() {
        sistema = new SystemUI();
        administrator = new Administrator();
        playground = new Playground();
        playgroundOwner = new PlaygroundOwner();

        systemIn.provideLines("SP");
        playground.setLocation();
        playground.setName("HappyPlayground");
        systemIn.provideLines("available");
        playground.setStatus();
        
        administrator.Approved.add(playground);
        // ################ Setando o owner ###################
        playgroundOwner.setFName("Lili");
        playgroundOwner.setEmail("lili@gmail.com");
        playgroundOwner.setPassword("teste");
        playgroundOwner.setLocation("SBC");
        playgroundOwner.setPhone(40028922);
        playgroundOwner.addPlayground(playground);
        sistema.theOwners.add(playgroundOwner);
        exit.expectSystemExitWithStatus(0);
        systemIn.provideLines("2", "Thales", "Lacerda","1", "teste", "thalesdonoPlayground@privado.com", "40028922", "SP", "player", "20000", "123", 
        "1", "thalesdonoPlayground@privado.com", "teste", "10", "HappyPlayground", "11", "SP", 
        "12", "3"); //verificou o que o player precisava para localizar os playgrounds
        sistema.accountMenu();

    }
    
}
