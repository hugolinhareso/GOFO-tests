package System;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import UI.SystemUI;

public class CSU07Test {

    @Rule
    public final TextFromStandardInputStream systemIn = TextFromStandardInputStream.emptyStandardInputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    private Playground playground;
    private Administrator administrator;
    private PlaygroundOwner playgroundOwner;

    @Test
    public void testeSetimoCasoDeUso07() {
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
        
        exit.expectSystemExitWithStatus(0);
        systemIn.provideLines("2", "Thales", "Lacerda","1", "teste", "thalesdonoPlayground@privado.com", "40028922", "SP", "player", "20000", "123", 
        "1", "thalesdonoPlayground@privado.com", "teste", "7","playground owner" , "lili@gmail.com", "O happyPlayground está horrivel!!", "12",
         "1", "admin@gmail.com", "123", "5", "2", "HappyPlayground", "6", "3"); 
        SystemUI.accountMenu();// viu a reclamação do cliente e suspendeu o playground para resolver o problema!

    }
}
