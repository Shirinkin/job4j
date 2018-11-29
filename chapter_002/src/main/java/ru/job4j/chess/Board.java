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

    public boolean move(Cell source, Cell dest) {
        boolean result = false;
        int index = this.findBy(source);
        if (this.findBy(source) == -1) {
            throw new FigureNotFoundException("Figure not found");
        }
        Cell[] steps = this.figures[index].way(source, dest);
        if (steps.length == 0 || !(steps[steps.length - 1].equals(dest))) {
            throw new ImposiibleMoveException("Impossible move");
        }
        if (!this.figures[index].getClass().toString().contains("Knight")) {
            for (Cell cell : steps) {
                if (findBy(cell) != -1) {
                    throw new OcuupiedWayException("Figure on way " + cell);
                }
            }
        } else if (findBy(dest) != -1) {
            throw new OcuupiedWayException("Figure on way " + dest);
        }
        this.figures[index] = this.figures[index].copy(dest);
        result = true;
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