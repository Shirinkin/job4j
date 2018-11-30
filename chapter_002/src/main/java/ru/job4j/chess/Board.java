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
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
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

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position.equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }
}