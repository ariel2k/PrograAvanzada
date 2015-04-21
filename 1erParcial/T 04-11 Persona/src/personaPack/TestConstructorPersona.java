package personaPack;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestConstructorPersona {

	@Test
	public void testConstructor() {
		Persona p1 = new Persona ("Ariel", "Molina");
		System.out.println(p1);
	}

}
