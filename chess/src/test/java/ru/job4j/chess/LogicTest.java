package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.junit.Assert.assertEquals;
import static ru.job4j.chess.firuges.Cell.*;

public class LogicTest {

    @Test(expected = FigureNotFoundException.class)
    public void moveWhenFigureNotFound()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Cell initCell = C1;
        logic.move(initCell, H6);
    }

    @Test(expected = OccupiedCellException.class)
    public void moveWhenOccupiedCell()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Cell initCell = C1;
        logic.add(new BishopBlack(initCell));
        Cell destCell = H6;
        logic.add(new BishopBlack(destCell));
        logic.move(initCell, destCell);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void moveWhenImpossibleMove()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Cell initCell = C1;
        logic.add(new BishopBlack(initCell));
        Cell destCell = C3;
        logic.move(initCell, destCell);
    }

    @Test
    public void whenSuccessMove()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        Cell initCell = C1;
        BishopBlack initBishop = new BishopBlack(initCell);
        logic.add(initBishop);
        Cell destCell = E3;
        logic.move(initCell, destCell);
        Figure destBishop = logic.get(0);
        assertEquals(destCell, destBishop.position());
    }
}
