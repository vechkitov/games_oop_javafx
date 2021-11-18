package ru.job4j.chess.firuges;

import ru.job4j.chess.ImpossibleMoveException;

/**
 * Поведение шахматной фигуры.
 */
public interface Figure {

    /**
     * Получает позицию фигуры на поле
     *
     * @return Cell
     */
    Cell position();

    /**
     * Возвращает массив клеток, которые должна пройти фигура при своем движении от
     * текущей клетки (не включается* в массив) до указанной клетки (включительно).
     *
     * @param dest Cell клетка, куда должна пойти фигура
     * @return Cell[] массив клеток, которые должна пройти фигура при своем движении
     * @throws ImpossibleMoveException если движение невозможно
     */
    Cell[] way(Cell dest) throws ImpossibleMoveException;

    /**
     * Возвращает имя картинки фигуры
     *
     * @return String имя картинки фигуры
     */
    default String icon() {
        return String.format("%s.png", getClass().getSimpleName());
    }

    /**
     * Создает объект с позицией dest.
     *
     * @param dest Cell клетка, в которой надо создать объект
     * @return Figure созданный объект
     */
    Figure copy(Cell dest);
}
