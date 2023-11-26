package System;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AdministratorTest {

    @InjectMocks
    private Administrator admin;

    @Mock
    private Playground playground;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private final PrintStream standardOut = System.out;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        System.setOut(new PrintStream(outputStreamCaptor));
        System.setIn(System.in);
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    // =============================== cenários negativos ================================= //
    @Test
    public void deveRetornarOkQuandoEmailAdminValido() {
        assertEquals("admin@gmail.com", admin.getEmail());
    }

    @Test
    public void deveRetornarOkQuandoSenhaAdminValido() {
        assertEquals("123", admin.getPassword());
    }

    @Test
    public void DeveRetornarOkQuandoSolicitadoApprovePlayground(){
        String inputSimulado = "yes";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        admin = new Administrator();

        inputSimulado = "Brazil";
        inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        playground = new Playground();

        playground = loadPlayground();
        admin.Requested.add(playground);

        assertEquals(0, admin.Approved.size());
        assertEquals(1, admin.Requested.size());

        admin.approvePlayground();

        assertEquals(1, admin.Approved.size());
        assertEquals(0, admin.Requested.size());

    }

    @Test
    public void DeveRetornarOkQuandoSolicitadoListaPlaygrounds(){
        String inputSimulado = "Brazil";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        playground = new Playground();

        playground = loadPlayground();
        admin.Approved.add(playground);

        admin.displayAllPlaygrounds();

        assertEquals(1, admin.Approved.size());
    }

    @Test
    public void DeveRetornarOkQuandoPesquisarPorNomePLaygrounds(){
        String inputSimulado = "Brazil";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        playground = new Playground();

        playground = loadPlayground();
        admin.Approved.add(playground);

        admin.searchByName("Happy Playground");

        assertEquals(1, admin.Approved.size());
        assertEquals("Happy Playground", admin.Approved.get(0).getName());
    }
    
    @Test
    public void DeveRetornarOkQuandoPesquisarPorLocal(){
        String inputSimulado = "Brazil";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        playground = new Playground();
        playground.setLocation();
        playground = loadPlayground();
        admin.Approved.add(playground);

        admin.searchByLocation("Brazil");

        assertEquals(1, admin.Approved.size());
        assertEquals("Brazil", admin.Approved.get(0).getLocation());
    }

    @Test
    public void DeveRetornarOkQuandoPesquisarPorTodosPlaygroundsDisponiveis(){
        String inputSimulado = "available";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        playground = new Playground();
        playground.setStatus();
        
        admin.Approved.add(playground);
        
        admin.displayAllavailablePlaygroundsLocations();

        assertEquals(1, admin.Approved.size());
        assertEquals("available", admin.Approved.get(0).getStatus());
    }

    @Test
    public void DeveRetornarOkQuandoPesquisarPorTodosNomesDePlaygrounds(){
        String inputSimulado = "available";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        playground = new Playground();
        playground.setStatus();
        playground.setName("Happy Playground");
        
        admin.Approved.add(playground);

        admin.displayAllavailablePlaygroundsNames();

        assertEquals(1, admin.Approved.size());
        assertEquals("Happy Playground", admin.Approved.get(0).getName());
    }

    @Test
    public void DeveRetornarOkQuandoAdicionarComplaints(){
        String inputSimulado = "yes";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        playground = new Playground();
        playground = loadPlayground();
        admin.Approved.add(playground);

        admin.addComplaints("Teste");

        assertEquals(1, admin.Approved.size());
        assertEquals("Teste", admin.complaints.get(0).toString());
    }

    @Test
    public void DeveRetornarOkQuandoSuspenderPlayground(){
        String inputSimulado = "yes";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        playground = new Playground();
        playground = loadPlayground();
        admin.Approved.add(playground);

        assertEquals(1, admin.Approved.size());
        assertEquals(0, admin.suspended.size());

        admin.suspendPlayground("Happy Playground");

        assertEquals(0, admin.Approved.size());
        assertEquals(1, admin.suspended.size());
    }

    @Test
    public void DeveRetornarOkQuandoDeletarPlayground(){
        String inputSimulado = "yes";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        playground = new Playground();
        playground = loadPlayground();
        admin.Approved.add(playground);

        assertEquals(1, admin.Approved.size());
        assertEquals(0, admin.suspended.size());

        admin.deletePlayground("Happy Playground");
        String outputCapturado = outputStreamCaptor.toString().trim();

        assertEquals(0, admin.Approved.size());
        assertTrue(outputCapturado.contains("the playground is deleted successfully!!"));
    }

    @Test
    public void DeveRetornarOkQuandoSolicitarPlayground(){
        String inputSimulado = "yes";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        playground = new Playground();
        playground = loadPlayground();

        admin.playgroundRequests(playground);
        String outputCapturado = outputStreamCaptor.toString().trim();

        assertEquals(1, admin.Requested.size());
    }

    @Test
    public void DeveRetornarCompliantsQuandoSolicitarListaDeCompliants(){
        String inputSimulado = "yes";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        playground = new Playground();
        playground = loadPlayground();
        admin.addComplaints("Teste");
        admin.addComplaints("Teste1");
        admin.addComplaints("Teste2");
        admin.showComplaints();

        assertEquals(3, admin.complaints.size());
    }

    @Test
    public void DeveRetornarOkQuandoSolicitarListaDeCompliants(){
        String inputSimulado = "yes";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        playground = new Playground();
        playground = loadPlayground();
        admin.addComplaints("Teste");
        admin.addComplaints("Teste1");
        admin.addComplaints("Teste2");
        admin.showComplaints();

        assertEquals(3, admin.complaints.size());
    }

    @Test
    public void DeveRetornarOkQuandoSolicitarRetomadaPlayground(){
        String inputSimulado = "yes";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        admin = new Administrator();

        inputSimulado = "yes";
        inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        playground = new Playground();
        playground = loadPlayground();
        admin.Approved.add(playground);

        admin.suspendPlayground("Happy Playground");

        assertEquals(0, admin.Approved.size());
        assertEquals(1, admin.suspended.size());

        admin.unSuspendPlayground();

        assertEquals(1, admin.Approved.size());
        assertEquals(0, admin.suspended.size());
    }
    
    @Test
    public void DeveRetornarOkQuandoSolicitarReservaPorLocal(){
        String inputSimulado = "Brazil";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        playground = new Playground();
        playground = loadPlayground();
        playground.setLocation();

        inputSimulado = "1\n1\n20";
        inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        admin = new Administrator();

        admin.Approved.add(playground);

        int res = admin.bookByLocation("Brazil", "PlayerOne", 500);
        assertEquals(0, res);
    }

    @Test
    public void DeveRetornarOkQuandoSolicitarReservaPorNome(){
        playground = new Playground();
        playground = loadPlayground();

        String inputSimulado = "300\n1\n20";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        admin = new Administrator();

        admin.Approved.add(playground);

        int res = admin.bookByName("Happy Playground", "PlayerOne", 500);
        assertEquals(0, res);
    }

    @Test
    public void DeveRetornarCustoQuandoSolicitarReservaPorNome(){
        String inputSimulado ="available";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        playground = new Playground();
        playground = loadPlayground();
        playground.setStatus();
        
        inputSimulado = "-1\n1\n20";
        inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        admin = new Administrator();

        admin.Approved.add(playground);

        int res = admin.bookByName("Happy Playground", "PlayerOne", 500);
        assertEquals(0, res); // verificando com preço zerado
    }
    
    // =============================== cenários positivos ================================= //



    // =============================== cenários negativos ================================= //
    @Test
    public void DeveRetornarErroQuandoSolicitadoApprovePlaygroundInexistentes(){
        String inputSimulado = "no";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);

        admin = new Administrator();
        playground = loadPlayground();
        admin.Requested.add(playground);

        assertEquals(0, admin.Approved.size());
        assertEquals(1, admin.Requested.size());

        admin.approvePlayground();

        assertEquals(0, admin.Approved.size());
        assertEquals(1, admin.Requested.size());

    }

    @Test
    public void DeveRetornarErroQuandoSolicitarReservaPorNomeInexistente(){
        String inputSimulado ="available";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        playground = new Playground();
        playground = loadPlayground();
        playground.setStatus();
        playground.setName("HappyPlayground");

        inputSimulado = "HappyPlayground\n1\n5\n20";
        inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        admin = new Administrator();

        admin.Approved.add(playground);

        int res = admin.bookByName("sad Playground", "PlayerOne", 500);
        assertEquals(0, res); // verificando com preço zerado
    }

    @Test
    public void DeveRetornarErroQuandoSolicitarBuscaPorNomeInexistente(){
        String inputSimulado ="available";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        playground = new Playground();
        playground = loadPlayground();
        playground.setStatus();
        playground.setName("HappyPlayground");

        inputSimulado = "HappyPlayground\n1\n5\n20";
        inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        admin = new Administrator();

        admin.Approved.add(playground);

        admin.searchByName("sad Playground");
    }

    @Test
    public void DeveRetornarErroQuandoSolicitadoListaPlaygroundsInexistentes(){

        admin.displayAllPlaygrounds();

        assertEquals(0, admin.Approved.size());
    }

    @Test
    public void DeveRetornarErroQuandoPesquisarPorNomePLaygroundsInexistentes(){
        String inputSimulado = "no";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        playground = new Playground();
        playground = loadPlayground();
        admin.Approved.add(playground);

        admin.searchByName("Sad Playground");
        String outputCapturado = outputStreamCaptor.toString().trim();
        assertTrue(outputCapturado.contains("No Playground Have the same Name Please Try agian"));
    }

    @Test
    public void DeveRetornarErroQuandoPesquisarPorLocalInexistente(){

        admin.searchByLocation("Brazil");
        String outputCapturado = outputStreamCaptor.toString().trim();

        assertEquals(0, admin.Approved.size());
        assertTrue(outputCapturado.contains("No Playground Have the same Location Please Try agian"));
    }

    @Test
    public void DeveContinuarSuspensoQuandoSolicitarRetomadaPlayground(){
        String inputSimulado = "no";
        InputStream inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        admin = new Administrator();

        inputSimulado = "no";
        inputStreamSimulado = new ByteArrayInputStream(inputSimulado.getBytes());
        System.setIn(inputStreamSimulado);
        playground = new Playground();
        playground = loadPlayground();
        admin.Approved.add(playground);
        
        admin.suspendPlayground("Happy Playground");

        assertEquals(0, admin.Approved.size());
        assertEquals(1, admin.suspended.size());

        admin.unSuspendPlayground();

        assertEquals(0, admin.Approved.size());
        assertEquals(1, admin.suspended.size());
    }
    // =============================== cenários negativos ================================= //


    public Playground loadPlayground(){
        playground.setName("Happy Playground");
        playground.setOwner("Happy Inc");

        return playground;
    }

}
