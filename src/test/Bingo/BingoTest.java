package test.Bingo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import main.Bingo.bingo;


public class BingoTest {
    bingo b;

    @BeforeEach
    public static void cree(){
        bingo.create_grille();
    }

    @Test
    public void testGrille(){
        bingo.create_grille();
        assertEquals(9,bingo.grille1.size());
        assertEquals(9, bingo.grille3.size());
        assertFalse(bingo.grille4.isEmpty());
        assertTrue(Integer.valueOf(bingo.grille5.get(5)) < 45);
    }

    @Test
    public void testGrilleTrouve(){
        bingo.create_grille();
        for (int i=0; i<9; i++){
            assertEquals(false,bingo.trouve2.get(i));
        }
    }
}
