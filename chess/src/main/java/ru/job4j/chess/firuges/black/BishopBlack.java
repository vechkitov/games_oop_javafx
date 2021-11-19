package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Фигура "Черный Слон"
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            String msg = String.format("Could not move by diagonal from %s to %s", position, dest);
            throw new ImpossibleMoveException(msg);
        }
        int x = position.getX();
        int y = position.getY();
        int size = Math.abs(dest.getX() - x);
        Cell[] steps = new Cell[size];
        int deltaX = (dest.getX() - x) > 0 ? 1 : -1;
        int deltaY = (dest.getY() - y) > 0 ? 1 : -1;
        for (int index = 0; index < size; index++) {
            x += deltaX;
            y += deltaY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
