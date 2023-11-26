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

public class CSU02Test {

    private final InputStream originalSystemIn = System.in;
    private final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

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
    public void TesteSegundoCasoDeUso02() {
        sistema = new SystemUI();
        exit.expectSystemExitWithStatus(0);
        
        systemIn.provideLines("2","Thales","Lacerda","1","teste","thalesPlayground@privado.com", "40028922", "SP", "playground owner", "500", "25", "1", "thalesPlayground@privado.com", "teste", "1", "HappyPlayground", "BrasilSPSBC", "500", "available", "5", "10", "2", "8", "3");
        sistema.accountMenu();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(originalSystemIn);
    }
}
