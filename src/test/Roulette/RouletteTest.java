package test.Roulette;

import main.Roulette.Roulette;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class RouletteTest {
    Roulette r;

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
		Roulette.setResultat(25);
	}

    @AfterEach
	public void afterATest() {
        System.out.println("--------- end of a test---------");
    }

    @Test
    public void testGain(){
        Roulette.setArgentParier(100);
        
        Roulette.setPari("12");
        assertEquals(0,Roulette.Gain());
        Roulette.setPari("noir");
        assertEquals(0,Roulette.Gain());
        Roulette.setPari("impair");
        assertEquals(200,Roulette.Gain());
        Roulette.setPari("tiers3");
        assertEquals(300,Roulette.Gain());
    }
}
