package System;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PlayerTest {

    @Mock
    private Player player;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void DeveRetornarOkQuandoSetarSaldo() {
        player = new Player();
        player.setBalance(100);
        assertEquals(100, player.getBalance());
    }

    @Test
    public void DeveRetornarOkQuandoCancelarAgendamento() {
        player = new Player();
        String playground = "Test Playground";
        String time = "12:00";
        ArrayList<String> testBooks = new ArrayList<>();
        testBooks.add(playground);
        player.Bookedslots.add(testBooks);

        assertEquals(1, player.Bookedslots.size());

        player.CancelBooking(playground, time);

        assertEquals(0, player.Bookedslots.size());
    }

    @Test
    public void DeveRetornarOkQuandoProcurarSlotsDisponiveis() {
        player = new Player();
        String playground = "Test Playground";
        String time = "12:00";
        ArrayList<String> testBooks = new ArrayList<>();
        testBooks.add(playground);
        player.Bookedslots.add(testBooks);

        assertEquals(1, player.Bookedslots.get(0).size());

        player.bookingSlots(time, playground);

        assertEquals(3, player.Bookedslots.get(0).size());
    }

    @Test
    public void DeveRetornarOkQuandoCriarTime() {
        player = new Player();
        Player novoPlayer = new Player();
        player.createTeam(novoPlayer);

        assertEquals(1, player.team.size());
    }

    @Test
    public void DeveRetornarOkQuandoEditarInformacaoPlayerPrimeiroNome() {
        String inputSimulado = "1\nThales";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        player = new Player();
        player.editPlayerinfo();
        assertTrue(player.getFullName().contains("Thales"));
    }

    @Test
    public void DeveRetornarOkQuandoEditarInformacaoPlayerUltimoNome() {
        String inputSimulado = "2\nLacerda";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        player = new Player();
        player.editPlayerinfo();
        assertTrue(player.getFullName().contains("Lacerda"));
    }

    @Test
    public void DeveRetornarOkQuandoEditarInformacaoPlayerNovoId() {
        String inputSimulado = "3\n21";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        player = new Player();
        player.editPlayerinfo();
        assertEquals(21, player.getID());
    }

    @Test
    public void DeveRetornarOkQuandoEditarInformacaoPlayerNovoEmail() {
        String inputSimulado = "4\ngrupotcc@gmail.com";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        player = new Player();
        player.editPlayerinfo();
        assertEquals("grupotcc@gmail.com", player.getEmail());
    }

    @Test
    public void DeveRetornarOkQuandoEditarInformacaoPlayerNovoCelular() {
        String inputSimulado = "5\n40028922";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        player = new Player();
        player.editPlayerinfo();
        assertEquals(40028922, player.getPhone());
    }

    @Test
    public void DeveRetornarOkQuandoEditarInformacaoPlayerNovoLocal() {
        String inputSimulado = "6\nBrazil";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        player = new Player();
        player.editPlayerinfo();
        assertEquals("Brazil", player.location);
    }

    @Test
    public void DeveRetornarOkQuandoEditarInformacaoPlayerNovaSenha() {
        String inputSimulado = "7\nteste123";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        player = new Player();
        player.editPlayerinfo();
        assertEquals("teste123", player.getPassword());
    }

    @Test
    public void DeveRetornarOkQuandoDepositarSaldo() {
        player = new Player();
        player.getMoney(500);
        assertEquals(500, player.eWallet.getBalance());
    }

    @Test
    public void DeveRetornarOkQuandoAdicionarInbox() {
        player = new Player();
        player.addInbox("Inbox Teste");
        assertEquals("Inbox Teste", player.Inbox.get(0).toString());
    }

    @Test
    public void DeveRetornarOkQuandoVisualizarInbox() {
        player = new Player();
        player.addInbox("Inbox Teste");
        player.viewInbox();
        assertEquals(1, player.Inbox.size());
    }
}
