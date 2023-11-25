package System;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import UI.SystemUI;

public class CSU02Test {

    private SystemUI sistema;
   
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

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
        SystemUI.accountMenu();
    }
}
