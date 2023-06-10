
package mx.edu.uaz.ingsoft.poo2.persistencia.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.edu.uaz.ingsoft.poo2.persistencia.entidades.Pendiente;
import mx.edu.uaz.ingsoft.poo2.persistencia.entidades.ToDo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaime
 */
public class PendienteDAOTest {
    static Logger logger = Logger.getLogger(PendienteDAO.class.getName());
    
    private static EntityManagerFactory emf;
    private static EntityManager em;    
    private static PendienteDAO dao;
    private static int numPendiente;
    
    private static final String MSG_ACTUALIZAR="NUEVA DESCRIPCION DEL PENDIENTE";
    
    public PendienteDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("UnidadPersistenciaProyectoToDos");
        em=emf.createEntityManager();
        dao = new PendienteDAO(em);
        numPendiente = 0; // no se han creado objetos todavia
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
        Pendiente entidad = crearNuevoPendiente();
        entidad = dao.add(entidad);
        assertNotNull(entidad);
        assertNotNull(entidad.getId());
        logger.info(entidad.toString());
    }
    @Test
    public void testFindByID(){
        Pendiente entidad = crearNuevoPendiente();
        assertNull(entidad.getId());
        dao.add(entidad);
        assertNotNull(entidad.getId());
        logger.info("Recuperando=>"+entidad.toString());
        Pendiente recuperado = dao.findByID(entidad.getId());
        assertNotNull(recuperado);
        assertEquals(entidad.getDescripcion(),recuperado.getDescripcion());
    }
    @Test
    public void testFindAll(){
        dao.add(crearNuevoPendiente());
        dao.add(crearNuevoPendiente());
        List<Pendiente> listaRecuperada;
        listaRecuperada = dao.findAll();
        assertNotNull(listaRecuperada);
        assert(listaRecuperada.size() >= 2);
    }
    @Test
    public void testDelete(){
        Pendiente entidad = crearNuevoPendiente();
        assertNull(entidad.getId());
        entidad = dao.add(entidad);
        assertNotNull(entidad.getId());
        Long idRegistro = entidad.getId();
        logger.log(Level.INFO, "Borrando=>{0}", entidad.toString());
        dao.delete(entidad);
        Pendiente recuperado;
        recuperado = dao.findByID(idRegistro);
        assertNull(recuperado);
    }
    @Test
    public void testUpdate(){
        Pendiente entidad = crearNuevoPendiente();
        entidad = dao.add(entidad);
        String mensajeOriginal = entidad.toString();
        Long idOriginal = entidad.getId();
        entidad.setDescripcion(MSG_ACTUALIZAR);
        dao.update(entidad);
        Pendiente recuperado = dao.findByID(idOriginal);
        assertNotNull(recuperado);
        assert(MSG_ACTUALIZAR.equals(recuperado.getDescripcion()));
        
    }
    
    private static Pendiente crearNuevoPendiente(){
        numPendiente++;
        Pendiente nuevo = new Pendiente("Ejemplo de pendiente "+numPendiente);
        return nuevo;
    }
    
}
