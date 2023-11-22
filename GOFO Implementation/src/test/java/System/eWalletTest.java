package System;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class eWalletTest {

    private eWallet wallet;

    @Before
    public void setUp() {
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
}
