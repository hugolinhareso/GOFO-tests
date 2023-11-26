package System;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PlaygroundOwnerTest {

    @InjectMocks
    private PlaygroundOwner playgroundOwner;

    @Mock
    private eWallet eWallet;
    
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        System.setOut(new PrintStream(outputStreamCaptor));
        System.setIn(System.in);
    }

    @Test
    public void DeveRetornarOkQuandoSetarSaldo() {
        playgroundOwner = new PlaygroundOwner();
        eWallet = new eWallet();
        eWallet.setBalance(500);
        playgroundOwner.setBalance(eWallet);
        assertEquals(500, playgroundOwner.getMyBalance());
    }

    @Test
    public void DeveRetornarOkQuandoAdicionarPlayground() {
        playgroundOwner = new PlaygroundOwner();
        Playground playground = new Playground();
        playgroundOwner.addPlayground(playground);
        assertEquals(1, playgroundOwner.listOfPlayground.size());
    }

    @Test
    public void DeveRetornarOkQuandoPlaygroundExistente() {
        playgroundOwner = new PlaygroundOwner();
        Playground playground = new Playground();
        playground.setName("Happy");
        playgroundOwner.addPlayground(playground);
        boolean exist = playgroundOwner.existPlayground("Happy");
        assertEquals(Boolean.TRUE, exist);
    }

    @Test
    public void DeveRetornarOkQuandoAlterarNomePlaygroundExistente() {
        Playground playground = new Playground();
        String inputSimulado = "1\ntrabalho";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);

        playgroundOwner = new PlaygroundOwner();
        eWallet = new eWallet();
        playground.setName("Happy");
        playgroundOwner.addPlayground(playground);

        assertEquals("Happy", playground.getName());

        playgroundOwner.updatePlaygroundName("Happy");

        assertEquals("trabalho", playgroundOwner.listOfPlayground.get(0).getName());
        
    }

    @Test
    public void DeveRetornarOkQuandoAlterarLocalPlaygroundExistente() {
        
        String inputSimulado = "2\nBrazil";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);

        playgroundOwner = new PlaygroundOwner();

        inputSimulado = "Brazil";
        inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        Playground playground = new Playground();

        playground.setName("Happy");
        playgroundOwner.addPlayground(playground);

        assertEquals("Happy", playground.getName());

        playgroundOwner.updatePlaygroundName("Happy");

        assertEquals("Brazil", playgroundOwner.listOfPlayground.get(0).getLocation());
        
    }

    @Test
    public void DeveRetornarOkQuandoAlterarPrecoHoraPlaygroundExistente() {
        String inputSimulado = "3\n300";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);

        playgroundOwner = new PlaygroundOwner();

        inputSimulado = "300";
        inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        Playground playground = new Playground();

        eWallet = new eWallet();
        playground.setName("Happy");
        playgroundOwner.addPlayground(playground);

        assertEquals("Happy", playground.getName());

        playgroundOwner.updatePlaygroundName("Happy");

        assertEquals("Happy", playgroundOwner.listOfPlayground.get(0).getName());
        assertEquals(300, playgroundOwner.listOfPlayground.get(0).getPrice());
    }

    @Test
    public void DeveRetornarOkQuandoAlterarStatusPlaygroundExistente() {
        String inputSimulado = "4\nnot available";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);

        playgroundOwner = new PlaygroundOwner();

        inputSimulado = "not available";
        inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        Playground playground = new Playground();

        eWallet = new eWallet();
        playground.setName("Happy");
        playgroundOwner.addPlayground(playground);

        assertEquals("Happy", playground.getName());

        playgroundOwner.updatePlaygroundName("Happy");

        assertEquals("Happy", playgroundOwner.listOfPlayground.get(0).getName());
        assertEquals("not available", playgroundOwner.listOfPlayground.get(0).getStatus());
    }

    @Test
    public void DeveRetornarErroQuandoPlaygroundExistente() {
        playgroundOwner = new PlaygroundOwner();
        Playground playground = new Playground();
        playground.setName("Happy");
        playgroundOwner.addPlayground(playground);
        boolean exist = playgroundOwner.existPlayground("Sad");
        assertEquals(Boolean.FALSE, exist);
    }

   
}
