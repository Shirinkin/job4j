package ru.job4j.chess;

import ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.exceptions.ImposiibleMoveException;
import ru.job4j.chess.exceptions.OcuupiedWayException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * Class Board
 * @author Mikhail
 * @version 1
 */
public class Board {

    private Figure[] figures = new Figure[32];
    private int indexFigure = 0;

    public void add(Figure figure) {
        figures[indexFigure++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws FigureNotFoundException, ImposiibleMoveException, OcuupiedWayException {
        boolean result = false;
        int index = this.findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException("no figure");
        }
        Cell[] steps = figures[index].way(source, dest);
        for (Cell cell : steps) {
            index = this.findBy(cell);
            if (index != -1) {
                throw new OcuupiedWayException("NO WAY");
            }
        }
        if (steps.length > 0) {
            this.figures[index] = this.figures[index].copy(dest);
            result = true;
        }
        return result;
    }

    public int findBy (Cell cell) {
        int result = -1;
        for (int i = 0; i < this.figures.length; i++) {
            if (figures[i] != null
                    && figures[i].position.x == cell.x
                    && figures[i].position.y == cell.y) {
                result = i;
                break;
            }
        }
        return result;
    }
}
