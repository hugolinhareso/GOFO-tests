package System;

import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.MockitoAnnotations;

import UI.SystemUI;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class CSU04Test {


    @Rule
    public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    private SystemUI sistema;
    private Playground playground;
    private Administrator administrator;
    
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
    public void testeQuartoCasoDeUso04() {
        sistema = new SystemUI();
        administrator = new Administrator();
        playground = new Playground();
        
        systemIn.provideLines("SP");
        playground.setLocation();
        playground.setName("HappyPlayground");
        systemIn.provideLines("500");
        playground.setPrice();
        systemIn.provideLines("available");
        playground.setStatus();
        systemIn.provideLines("0","10");
        playground.setBooking();
        systemIn.provideLines("yes");
        administrator.Requested.add(playground);
        administrator.approvePlayground();
        exit.expectSystemExitWithStatus(0);
        systemIn.provideLines("2", "Thales", "Lacerda","1", "123456", "thalesdonoPlayground@privado.com", "40028922", 
        "SP", "player", "500", "123", "1", "thalesdonoPlayground@privado.com", "123456", "10", "HappyPlayground", "3", "2", 
        "HappyPlayground", "6", "8", "friday", "4", "1", "thalesdonoPlayground@privado.com", "12", "1", "thalesdonoPlayground@privado.com", "123456", "8", "12", "3"); 
        sistema.accountMenu();

    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(originalSystemIn);
    }
}