package test.Consommable;

import main.Consommable.Consommable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class ConsommableTest {
    
    Consommable c;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("Start test series");
    }

    @AfterAll
	public static void afterAllTests() {
        System.out.println("End test series");
    }

    @BeforeEach
	public void beforeATest() {
		c = new Consommable(10,"vache");
	}

    @AfterEach
	public void afterATest() {
        System.out.println("--------- end of a test---------");
    }

    @Test
    public void effetTest(){
        assertEquals("ceci est un vache qui coute 10",c.effet());
    }
}