package System;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class userProfileTest {

    private userProfile user;

    @Before
    public void setUp() {
        user = new userProfile();
        new eWallet();
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
}
