package project;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by HL on 3/21/17.
 */
public class Stuff2Test {

    Stuff stuff;

    @Test
    public void addTest() {
        Stuff stuff = new Stuff();
        assertTrue("1+1", 2 == stuff.add(1, 1));
    }

    @Test
    public void subTest() {
        Stuff stuff = new Stuff();
        assertTrue("1-1", 0 == stuff.sub(1, 1));
    }

    @Test
    public void multiTest() {
        Stuff stuff = new Stuff();
        assertTrue("1-1", 0 == stuff.add(stuff.sub(stuff.sub(1, 0), stuff.sub(1, 0)),
                stuff.sub(stuff.sub(1, 0), stuff.sub(1, 0))));
    }
}