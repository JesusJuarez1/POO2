package mx.edu.uaz.ingsoft.poo2;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.dao.TicketDAO;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades.Ticket;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TicketDAOTest {
    static Logger logger = Logger.getLogger(TicketDAO.class.getName());
    
    private static EntityManagerFactory emf;
    private static EntityManager em;    
    private static TicketDAO dao;
    private static int numTicket;
    
    private static final double TOTAL_ACT=1234.56;
    
    public TicketDAOTest(){
    }
    
    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("UnidadPersistenciaTienda");
        em=emf.createEntityManager();
        dao = new TicketDAO(em);
        numTicket = 0; // no se han creado objetos todavia
    }
    
    @AfterClass
    public static void tearDownClass() {
        em.close();
        emf.close();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAdd() {
        Ticket entidad = crearNuevoProducto();
        entidad = dao.add(entidad);
        assertNotNull(entidad);
        assertNotNull(entidad.getId());
        logger.info(entidad.toString());
    }
    @Test
    public void testFindByID(){
        Ticket entidad = crearNuevoProducto();
        assertNull(entidad.getId());
        dao.add(entidad);
        assertNotNull(entidad.getId());
        logger.info("Recuperando=>"+entidad.toString());
        Ticket recuperado = dao.findByID(entidad.getId());
        assertNotNull(recuperado);
        assertEquals(""+entidad.getTotal(),""+recuperado.getTotal());
    }
    @Test
    public void testFindAll(){
        dao.add(crearNuevoProducto());
        dao.add(crearNuevoProducto());
        List<Ticket> listaRecuperada;
        listaRecuperada = dao.findAll();
        assertNotNull(listaRecuperada);
        assert(listaRecuperada.size() >= 2);
    }
    @Test
    public void testDelete(){
        Ticket entidad = crearNuevoProducto();
        assertNull(entidad.getId());
        entidad = dao.add(entidad);
        assertNotNull(entidad.getId());
        Long idRegistro = entidad.getId();
        logger.log(Level.INFO, "Borrando=>{0}", entidad.toString());
        dao.delete(entidad);
        Ticket recuperado;
        recuperado = dao.findByID(idRegistro);
        assertNull(recuperado);
    }
    @Test
    public void testUpdate(){
        Ticket entidad = crearNuevoProducto();
        entidad = dao.add(entidad);
        String mensajeOriginal = entidad.toString();
        Long idOriginal = entidad.getId();
        entidad.setTotal(TOTAL_ACT);
        dao.update(entidad);
        Ticket recuperado = dao.findByID(idOriginal);
        assertNotNull(recuperado);
        assert(TOTAL_ACT == recuperado.getTotal());
        
    }
    
    private static Ticket crearNuevoProducto(){
        numTicket++;
        Ticket nuevo = new Ticket(numTicket);
        return nuevo;
    }
}
