package System;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PlayGroundScheduleTest {

    @InjectMocks
    private PlayGroundSchedule schedule;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void DeveRetornarSlotsQuandoSolicitarAgendamento() {
        String inputSimulado = "8\n11";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        schedule = new PlayGroundSchedule();
        schedule.setschedule();
        schedule.displayAllSlots();
        assertEquals(1, schedule.getDayIndex("sunday"));
        assertEquals(2, schedule.getDayIndex("monday"));
        assertEquals(8, schedule.getBegin());
        assertEquals(11, schedule.getEnd());

    }

    @Test
    public void DeveRetornarOkQuandoSetarPreco() {
        String inputSimulado = "30";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        schedule = new PlayGroundSchedule();
        schedule.setPrice();
        assertEquals(30, schedule.getTimeSlotPerHour());

    }

    @Test
    public void DeveRetornarSlotsDisponiveisQuandoSolicitado() {
        String inputSimulado = "30";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        schedule = new PlayGroundSchedule();
        schedule.displayFreeSlots();
        assertEquals(1, schedule.getDayIndex("sunday"));
        assertEquals(2, schedule.getDayIndex("monday"));

    }

    @Test
    public void DeveRetornarOkQuandoSolicitadoPrecoHora() {
        String inputSimulado = "30";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        schedule = new PlayGroundSchedule();
        schedule.setPrice();
        int price = schedule.getTimeSlotPerHour();
        assertEquals(30, price);

    }

    @Test
    public void DeveRetornarOkQuandoSolicitadoInicioBooking() {
        String inputSimulado = "8\n11";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        schedule = new PlayGroundSchedule();
        schedule.setschedule();
        int begin = schedule.getBegin();
        assertEquals(8, begin);

    }

    @Test
    public void DeveRetornarOkQuandoSolicitadoFimBooking() {
        String inputSimulado = "8\n11";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        schedule = new PlayGroundSchedule();
        schedule.setschedule();
        int end = schedule.getEnd();
        assertEquals(11, end);

    }

    @Test
    public void DeveRetornarOkQuandoSolicitadoDiaUm() {
        schedule = new PlayGroundSchedule();
        int res = schedule.getDayIndex("sunday");
        assertEquals(1, res);
        res = schedule.getDayIndex("monday");
        assertEquals(2, res);
        res = schedule.getDayIndex("tuesday");
        assertEquals(3, res);
        res = schedule.getDayIndex("wendesday");
        assertEquals(4, res);
        res = schedule.getDayIndex("thursday");
        assertEquals(5, res);
        res = schedule.getDayIndex("friday");
        assertEquals(6, res);
        res = schedule.getDayIndex("saturday");
        assertEquals(7, res);
        res = schedule.getDayIndex("x");
        assertEquals(-1, res);
    }

    @Test
    public void DeveRetornarOkQuandoSolicitadoSlot() {
        schedule = new PlayGroundSchedule();
        ArrayList<String> scheduleAdd = new ArrayList<String>();
        scheduleAdd.add("12");
        schedule.schedule.add(scheduleAdd);
        schedule.schedule.get(0).add("PlayerTwo");
        schedule.bookSlot("PlayerOne", "12", "sunday");
        assertEquals("12", schedule.schedule.get(0).get(0));
        assertEquals("PlayerOne", schedule.schedule.get(0).get(1));

    }
}
