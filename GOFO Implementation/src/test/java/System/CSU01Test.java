package System;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import org.junit.Rule;
import org.junit.Test;

import UI.SystemUI;

public class CSU01Test {

    private SystemUI sistema;
   
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void testUS01_1Test() {
        String inputSimulado ="2\nThales\nLacerda\n1\nteste\nthalesllr@privado.com\n40028922\nSP\nPlayer\n123\n3\n3";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        sistema = new SystemUI(); 
        inputSimulado ="500";
        inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        Player player = new Player();
        exit.expectSystemExitWithStatus(0);
        sistema.accountMenu();
    }
}
    
