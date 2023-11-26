package System;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class userProfileTest {

    private userProfile user;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final InputStream originalSystemIn = System.in;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        System.setOut(new PrintStream(outputStreamCaptor));
        System.setIn(System.in);
        user = new userProfile();
    }

    @Test
    public void DeveRetornarOkQuandoSolicitarNome() {
        user.setFName("John");
        user.setLName("Doe");
        assertEquals("John Doe", user.getFullName());
    }

    @Test
    public void DeveRetornarOkQuandoSolicitarId() {
        user.setID(12345);
        assertEquals(12345, user.getID());
    }

    @Test
    public void DeveRetornarOkQuandoSolicitarEmail() {
        user.setEmail("johndoe@example.com");
        assertEquals("johndoe@example.com", user.getEmail());
    }

    @Test
    public void DeveRetornarOkQuandoSolicitarSenha() {
        user.setPassword("password123");
        assertEquals("password123", user.getPassword());
    }

    @Test
    public void DeveRetornarOkQuandoSolicitarNumero() {
        user.setPhone(123456789);
        assertEquals(123456789, user.getPhone());
    }

    @Test
    public void DeveRetornarOkQuandoSolicitarRegra() {
        user.setRule("Administrator");
        assertEquals("Administrator", user.getRule());
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(originalSystemIn);
    }   
}
