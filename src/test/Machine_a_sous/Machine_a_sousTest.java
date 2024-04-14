package test.Machine_a_sous;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import main.Machine_a_sous.Anneau;

public class Machine_a_sousTest {
    Anneau a;

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
		a = new Anneau();
	}

    @AfterEach
	public void afterATest() {
        System.out.println("--------- end of a test---------");
    }

    @Test
    public void testIsrolling() {
        assertTrue(a.isRolling());
        a.setRolling(false);
        assertFalse(a.isRolling());
    }

    @Test 
    public void testidx() {
        assertTrue(0 <= a.getIdx() && a.getIdx() <=4);
        a.setIdx(0);
        assertTrue(a.toString().equals("€"));
    }
}
