package System;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class eWalletTest {

    private eWallet wallet;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final InputStream originalSystemIn = System.in;
    
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        System.setIn(System.in);
        wallet = new eWallet();
    }

    @Test
    public void DeveRetornarOkQuandoTiverSaldo() {
        wallet.setBalance(100);
        assertEquals(100, wallet.getBalance());
    }

    @Test
    public void DeveRetornarOkQuandoTentativaDeposito() {
        wallet.setBalance(100);
        wallet.deposit(50);
        assertEquals(150, wallet.getBalance());
    }

    @Test
    public void DeveRetornarOkQuandoSaldoSairDaConta() {
        wallet.setBalance(200);
        wallet.withdraw(50);
        assertEquals(150, wallet.getBalance());
    }

    @Test
    public void DeveRetornarOkQuandoSolicitarVisualizacaoSaldop() {
        wallet.setBalance(300);
        assertEquals(300, wallet.getBalance());
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(originalSystemIn);
    }
}
