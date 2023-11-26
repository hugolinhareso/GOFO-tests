package System;

import java.io.InputStream;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import UI.SystemUI;

public class CSU01Test {

    private final InputStream originalSystemIn = System.in;

    @Rule
    public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    private SystemUI sistema;
   
    @Before
    public void setUp() {
        System.setIn(System.in);
    }

    @Test
    public void testUS01_1Test() {
        sistema = new SystemUI();
        exit.expectSystemExitWithStatus(0);
        systemIn.provideLines("2","Thales","Lacerda","1","teste","thalesPlayground@privado.com", "40028922", "SP", "player", "500", "25", "3");
        sistema.accountMenu();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(originalSystemIn);
    }
}
    
