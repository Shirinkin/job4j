package ru.job4j.chess.figures;

import ru.job4j.chess.exceptions.ImposiibleMoveException;

/**
 * abstract class Figure
 */
public abstract class Figure {

   public final Cell position;


    public Figure(Cell position) {
        this.position = position;
    }

    /**
     *
     * @param source
     * @param dest - задает ячейку, куда может пойти фигура
     * @return
     * @throws ImposiibleMoveException
     */
    public abstract Cell[] way(Cell source, Cell dest) throws ImposiibleMoveException;

    /**
     * Перемещает фигуру в dest
     * @param dest
     * @return
     */
    public abstract Figure copy(Cell dest);

    protected Cell findCell(int x,int y) {
        Cell result = Cell.A1;
        for (Cell cell : Cell.values()){
            if (cell.x == x && cell.y == y) {
                result = cell;
                break;
            }
        }
        return result;
    }

}
