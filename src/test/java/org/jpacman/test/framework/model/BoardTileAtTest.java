package org.jpacman.test.framework.model;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.jpacman.framework.model.Board;
import org.jpacman.framework.model.Direction;
import org.jpacman.framework.model.Tile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Test the Board.tileAt method by means of a series of test cases with
 * Parameterized data.
 *
 * @author Arie van Deursen, TU Delft, Feb 10, 2012
 */
@RunWith(Parameterized.class)
public class BoardTileAtTest {
/**
 * random text.
 */
	private int startx, starty;
	/**
	 * random text.
	 */
	private Direction dir;
	/**
	 * random text.
	 */
	private int nextx, nexty;
	/**
	 * random text.
	 */
	private Board board;

	/**
	 * random.
	 */
	private static final int WIDTH = 10;
	/**
	 * random.
	 */
	private static final int HEIGHT = 20;

	/**
	 *
	 * @param x cordinaat
	 * @param y cordinaat
	 * @param d richting
	 * @param nx nieuwe cordinaat
	 * @param ny nieuwe cordinaat
	 */
	public BoardTileAtTest(final int x, final int y,
	        final Direction d, final int nx, final int ny) {
		startx = x;
		starty = y;
		dir = d;
		nextx = nx;
		nexty = ny;
		board = new Board(WIDTH, HEIGHT);
	}
/**
 * random text.
 */
	@Test
	public void testTileAtDirection() {
		Tile source = board.tileAt(startx, starty);
		Tile actual = board.tileAtDirection(source, dir);
		Tile desired = board.tileAt(nextx, nexty);
		assertEquals(desired, actual);
	}

	/**
	 * random text.
	 * @return Collwction object
	 */
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] values = new Object[][] {
				// x-axis boundaries, y random inpoints
				// left boundary
				{2, 2, Direction.UP, 2, 1 },
				{2, 2, Direction.DOWN, 2, 3 },
				{2, 2, Direction.LEFT, 1, 2 },
				{2, 2, Direction.RIGHT, 3, 2 },
				// worm holes
				{0, 2, Direction.LEFT, WIDTH - 1, 2 },
				{WIDTH - 1, 2, Direction.RIGHT, 0, 2 },
				{2, 0, Direction.UP, 2, HEIGHT - 1 },
				{2, HEIGHT - 1, Direction.DOWN, 2, 0 } };
		return Arrays.asList(values);
	}

}
