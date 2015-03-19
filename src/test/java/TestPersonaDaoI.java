import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.com.sp.jdbc.Persona;
import co.com.sp.jdbc.PersonaDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:datasource-test.xml",
		"classpath:applicationContext.xml" })
public class TestPersonaDaoI {
	private static Log logger = LogFactory.getLog("TestPersonasDaoImpl");

	@Autowired
	private PersonaDao personaDao;

	@Test
	public void deberiaMostrarPersonas() {
		try {
			System.out.println();
			logger.info("Inicio del test deberiaMostrarPersonas");
			List<Persona> personas = personaDao.findAllPersonas();
			int contadorPersonas = 0;
			for (Persona persona : personas) {
				logger.info("Persona: " + persona);
				contadorPersonas++;
			}
			// Segun el numero de personas recuperadas, deberia ser el mismo de
			// la tabla
			assertEquals(contadorPersonas, personaDao.contadorPersonas());
			logger.info("Fin del test deberiaMostrarPersonas");

		} catch (Exception e) {
			logger.error("Error JBDC", e);
		}
	}

	@Test
	public void testContarPersonasPorNombre() {
		try {
			System.out.println();
			logger.info("Inicio del test Contar Personas por nombre");
			String nombre = "Juan";
			Persona personaEjemplo = new Persona();
			personaEjemplo.setNombre(nombre);
			int noPersonasEncontradas = personaDao
					.contadorPersonasPorNombre(personaEjemplo);
			logger.info("Numero de personas encontradas por nombre '" + nombre
					+ "': " + noPersonasEncontradas);
			assertEquals(2, noPersonasEncontradas);
			logger.info("Fin del test Contar Personas por nombre");
		} catch (Exception e) {
			logger.error("Error JBDC", e);
		}
	}
}