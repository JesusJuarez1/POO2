package mx.edu.uaz.ingsoft.poo2;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.dao.ProductoDAO;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades.Productos;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProductoDAOTest {
    static Logger logger = Logger.getLogger(ProductoDAO.class.getName());
    
    private static EntityManagerFactory emf;
    private static EntityManager em;    
    private static ProductoDAO dao;
    private static int numProducto;
    
    private static final String MSG_ACTUALIZAR="NUEVO NOMBRE PRODUCTO";

    public ProductoDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("UnidadPersistenciaTienda");
        em=emf.createEntityManager();
        dao = new ProductoDAO(em);
        numProducto = 0; // no se han creado objetos todavia
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
        Productos entidad = crearNuevoProducto();
        entidad = dao.add(entidad);
        assertNotNull(entidad);
        assertNotNull(entidad.getId());
        logger.info(entidad.toString());
    }
    @Test
    public void testFindByID(){
        Productos entidad = crearNuevoProducto();
        assertNull(entidad.getId());
        dao.add(entidad);
        assertNotNull(entidad.getId());
        logger.info("Recuperando=>"+entidad.toString());
        Productos recuperado = dao.findByID(entidad.getId());
        assertNotNull(recuperado);
        assertEquals(entidad.getNombre(),recuperado.getNombre());
    }
    @Test
    public void testFindAll(){
        dao.add(crearNuevoProducto());
        dao.add(crearNuevoProducto());
        List<Productos> listaRecuperada;
        listaRecuperada = dao.findAll();
        assertNotNull(listaRecuperada);
        assert(listaRecuperada.size() >= 2);
    }
    @Test
    public void testDelete(){
        Productos entidad = crearNuevoProducto();
        assertNull(entidad.getId());
        entidad = dao.add(entidad);
        assertNotNull(entidad.getId());
        Long idRegistro = entidad.getId();
        logger.log(Level.INFO, "Borrando=>{0}", entidad.toString());
        dao.delete(entidad);
        Productos recuperado;
        recuperado = dao.findByID(idRegistro);
        assertNull(recuperado);
    }
    @Test
    public void testUpdate(){
        Productos entidad = crearNuevoProducto();
        entidad = dao.add(entidad);
        String mensajeOriginal = entidad.toString();
        Long idOriginal = entidad.getId();
        entidad.setNombre(MSG_ACTUALIZAR);
        dao.update(entidad);
        Productos recuperado = dao.findByID(idOriginal);
        assertNotNull(recuperado);
        assert(MSG_ACTUALIZAR.equals(recuperado.getNombre()));
        
    }
    
    private static Productos crearNuevoProducto(){
        numProducto++;
        Productos nuevo = new Productos("Ejemplo de pendiente "+numProducto);
        return nuevo;
    }
}
