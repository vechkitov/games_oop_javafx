package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.*;
import static ru.job4j.chess.firuges.Cell.*;

public class BishopBlackTest {

    @Test
    public void whenGetPositionThenActualPositionEqualsInitPosition() {
        Cell initCell = B2;
        BishopBlack bishop = new BishopBlack(initCell);
        Cell actualCell = bishop.position();
        assertEquals(actualCell, initCell);
    }

    @Test
    public void whenWayIsFromLeftDownToRightUp() {
        BishopBlack bishop = new BishopBlack(C1);
        Cell destCell = G5;
        Cell[] way = bishop.way(destCell);
        Cell[] expected = {D2, E3, F4, destCell};
        assertArrayEquals(way, expected);
    }

    @Test
    public void whenWayIsFromLeftUpToRightDown() {
        BishopBlack bishop = new BishopBlack(B7);
        Cell destCell = E4;
        Cell[] way = bishop.way(destCell);
        Cell[] expected = {C6, D5, destCell};
        assertArrayEquals(way, expected);
    }

    @Test
    public void whenWayIsFromRightDownToLeftUp() {
        BishopBlack bishop = new BishopBlack(G3);
        Cell destCell = D6;
        Cell[] way = bishop.way(destCell);
        Cell[] expected = {F4, E5, destCell};
        assertArrayEquals(way, expected);
    }

    @Test
    public void whenWayIsFromRightUpToLeftDown() {
        BishopBlack bishop = new BishopBlack(E8);
        Cell destCell = A4;
        Cell[] way = bishop.way(destCell);
        Cell[] expected = {D7, C6, B5, destCell};
        assertArrayEquals(way, expected);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenWayIsNotDiagonalThenThrowException() {
        BishopBlack bishop = new BishopBlack(G3);
        Cell destCell = G7;
        bishop.way(destCell);
    }

    @Test
    public void whenIsDiagonalThenTrue() {
        BishopBlack bishop = new BishopBlack(A1);
        assertTrue(bishop.isDiagonal(C1, G5));
    }

    @Test
    public void whenInNotDiagonalThenFalse() {
        BishopBlack bishop = new BishopBlack(A1);
        assertFalse(bishop.isDiagonal(F2, E8));
    }

    @Test
    public void whenCopyFigureThenActualPositionEqualsDestinationPosition() {
        BishopBlack bishop = new BishopBlack(B2);
        Cell destCell = B3;
        Figure copy = bishop.copy(destCell);
        Cell actualCell = copy.position();
        assertEquals(destCell, actualCell);
    }
}