package unitTests;

import org.junit.Test;

import primitives.Coordinate;

import static org.junit.Assert.*;

public class CoordinateTest {

    @Test
    public void equals() {
        Coordinate a = new Coordinate(8.999999999);
        Coordinate b = new Coordinate(9.0);
        Coordinate c = new Coordinate(1.000000000001);
        Coordinate d = new Coordinate(1.00000000001);
        Coordinate f = new Coordinate(7.7);
        Coordinate g = new Coordinate(7.6);
        Coordinate h = new Coordinate(199999999.0000001);
        Coordinate i = new Coordinate(199999999.0000010);

        assertFalse(a.equals(c));
        assertFalse(f.equals(g));
        assertFalse(g.equals(f));
        assertTrue(a.equals(b));
        assertTrue(c.equals(d));
        assertTrue(d.equals(c));
        assertTrue(h.equals(i));




    }

    @Test
    public void subtract() {
    }

    @Test
    public void add() {
    }
}