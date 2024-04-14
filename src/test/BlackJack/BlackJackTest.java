package test.BlackJack;

import org.junit.jupiter.api.Test;

import main.BlackJack.BlackJack;
import main.BlackJack.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


public class BlackJackTest {
    BlackJack b;

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
        b = new BlackJack(new User(100, "test"));
	}

    @AfterEach
	public void afterATest() {
        System.out.println("--------- end of a test---------");
    }

    @Test
    public void startingDealTest() {
        assertEquals(0, b.getPlayer().getUserScore());
        assertEquals(0, b.getDealer().getUserScore());
        b.startingDeal();
        assertEquals(2, b.getPlayer().getUserHand().size());
        assertEquals(2, b.getDealer().getUserHand().size());
        assertNotEquals(0, b.getPlayer().getUserScore());
        assertNotEquals(0, b.getDealer().getUserScore());
    }
}
