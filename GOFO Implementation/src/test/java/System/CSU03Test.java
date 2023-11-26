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
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.MockitoAnnotations;

import UI.SystemUI;

public class CSU03Test {

    private final InputStream originalSystemIn = System.in;

    @Rule
    public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    private SystemUI sistema;
    private Playground playground;
    private PlaygroundOwner playgroundOwner;
    private eWallet eWallet;

    @Before
    public void setUp() {
        System.setIn(System.in);
    }

    @Test
    public void testeTerceiroCasoDeUso03() {
        sistema = new SystemUI();
        eWallet = new eWallet();
        playground = new Playground();
        playgroundOwner = new PlaygroundOwner();
        playground.setName("HappyPlayground");
        eWallet.setBalance(10000);
        playgroundOwner.setBalance(eWallet);
        playgroundOwner.setFName("Thales");
        playgroundOwner.setLName("Lacerda");
        playgroundOwner.setPassword("teste");
        playgroundOwner.setID(1);
        playgroundOwner.setRule("playground owner");
        playgroundOwner.setPhone(40028922);
        playgroundOwner.setEmail("thalesplaygrounddono@privado.com");
        playgroundOwner.setLocation("BRASILSPSBC");
        playgroundOwner.addPlayground(playground);
        sistema.theOwners.add(playgroundOwner);
        exit.expectSystemExitWithStatus(0); 
        systemIn.provideLines("2","Thales","Lacerda","1","teste","thalesPlayground@privado.com", "40028922", "SP", "player", "500", "25", "1", "thalesPlayground@privado.com", "teste", "5", "HappyPlayground", "5", "1", "friday", "2", "12", "3");
        sistema.accountMenu();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(originalSystemIn);
    }
}
