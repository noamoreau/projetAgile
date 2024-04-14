package test.Lotterie;

import org.junit.jupiter.api.Test;

import main.Lotterie.Lotterie;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class LotterieTest {
    Lotterie l;

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
		l = new Lotterie();
	}

    @AfterEach
	public void afterATest() {
        System.out.println("--------- end of a test---------");
    }

    @Test
    public void testBoules() {
        assertTrue(45 == l.getBoules().size());
        for (Integer integer : l.getBoules()) {
            assertTrue(integer instanceof Integer);
        }
        for (int i = 1; i < 46; i++) {
            assertTrue(l.getBoules().contains(i));
        }
    }

    @Test
    public void testTirage() {
        l.tirage();
        assertTrue(6 == l.getTirages().size());
        for (Integer integer : l.getTirages()) {
            assertTrue(integer instanceof Integer);
        }
        for (int i = 0; i < 7; i++) {
            assertTrue(0 < l.getBoules().get(i));
            assertTrue(l.getBoules().get(i) < 46);
        }
    }

}
