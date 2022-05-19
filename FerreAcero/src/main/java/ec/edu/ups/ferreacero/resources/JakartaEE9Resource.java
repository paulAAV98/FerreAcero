package ec.edu.ups.ferreacero.resources;

import ec.edu.ups.ejb.CategoriaFacade;
import ec.edu.ups.ejb.PersonaFacade;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.entidades.Persona;
import ec.edu.ups.entidades.Producto;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import java.util.GregorianCalendar;

/**
 *
 * @author 
 */
@Path("jakartaee9")
public class JakartaEE9Resource {
   
    /*
    @EJB
    private PersonaFacade ejbPersona;
    
   
    
    @GET
    public Response ping(){
        Persona p = new Persona(0, "Pepito", "Perez", new GregorianCalendar(1987, 0, 31));
        ejbPersona.create(p);
        
        return Response
                .ok("Persona creada con Jakarta EE")
                .build();
*/
    
    @EJB
    private ProductoFacade ejbProducto;
    
    @EJB 
    private CategoriaFacade ejbCategoria;
     
    @GET
    public Response ping(){
        Categoria c = new Categoria(4, "Iluminación");
        Producto p1 = new Producto (3, "FOCO LED ALTA POTENCIA", "EVLITE", 3.91, 8, c);
        
        c.addProductos(p1);
        c.addProductos(new Producto (4, "ODB LED REDONDO SOBREPONER", "EVLITE", 3.84, 15, c));
        c.addProductos(new Producto (5, "ODB LED CUADRADO SLIM ", "EVLITE", 3.17, 5, c));
        ejbCategoria.create(c);
        
        //Error: Se debe eliminar el producto de la entidad
        c.removeProduct(p1);
        ejbCategoria.edit(c);
        
        //Se debe eliminar manualmente
        Producto p2 = ejbProducto.find(4);
        ejbProducto.remove(p2);
        
        return Response
                .ok("Producto creado con Jakarta EE")
                .build();
    
    }
}
