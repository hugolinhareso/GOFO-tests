package System;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

@RunWith(MockitoJUnitRunner.class)
public class PlaygroundTest {


    @InjectMocks
    private Playground playground;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        System.setOut(new PrintStream(outputStreamCaptor));
        System.setIn(System.in);
    }

    @Test
    public void testSetAndGetCancellationPeriod() {
        playground = new Playground();
        playground.setCancellationPeriod(24);
        assertEquals(24, playground.getCancellationPeriod());
    }

    @Test
    public void testSetAndGetName() {
        playground = new Playground();
        playground.setName("Playground 1");
        assertEquals("Playground 1", playground.getName());
    }

    @Test
    public void testSetAndGetOwner() {
        playground = new Playground();
        playground.setOwner("Owner Name");
        assertEquals("Owner Name", playground.getOwner());
    }

    @Test
    public void testSetAndGetLocation() {
        String inputSimulado = "Brazil";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        playground = new Playground();
        playground.setLocation();
        assertEquals("Brazil", playground.getLocation());
    }

    @Test
    public void DeveRetornarOkQuandoSolicitadoSlotsDisponiveis() {
        String inputSimulado = "available";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        playground = new Playground();
        playground = loadPlayground();
        playground.setStatus();

        playground.bookingTheSlot("playerOne", "12", "friday");
        assertEquals("available", playground.getStatus());

    }

    @Test
    public void DeveRetornarOkQuandoSolicitadoCancelamentoAgendamento() {
        String inputSimulado = "available";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        playground = new Playground();
        playground = loadPlayground();
        playground.setStatus();

        playground.cancelBooking("friday", "12");
        assertEquals("available", playground.getStatus());
        assertEquals(0, playground.object.getBegin());
        assertEquals(0, playground.object.getEnd());
    }
    
    public Playground loadPlayground(){
        playground.setName("Happy Playground");
        playground.setOwner("Happy Inc");

        return playground;
    }
}
