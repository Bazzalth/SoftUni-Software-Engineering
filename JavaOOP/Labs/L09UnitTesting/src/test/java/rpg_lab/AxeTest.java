package L09UnitTesting.src.test.java.rpg_lab;

import L09UnitTesting.src.main.java.rpg_lab.Axe;
import L09UnitTesting.src.main.java.rpg_lab.Dummy;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AxeTest {
    private static final int ATTACK = 10;
    private static final int DURABILITY = 10;
    private static final int HEALTH = 100;
    private static final int EXPERIENCE = 10;

    private Axe axe;
    private Axe brokenAxe;
    private Dummy dummy;

    @Before
    public void setUp() {
        this.axe = new Axe(ATTACK, DURABILITY);
        this.brokenAxe = new Axe(ATTACK, 0);
        this.dummy = new Dummy(HEALTH, EXPERIENCE);
    }

    @Test
    public void testAttackReducesDurability() {
        axe.attack(dummy);
        int expected = DURABILITY - 1;
        assertEquals(expected, axe.getDurabilityPoints());
    }


    @Test(expected = IllegalStateException.class)
    public void testAttackThrowsWhenAxeIsBroken() {
        brokenAxe.attack(dummy);
    }
}
