package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.exception.FigureNotFoundException;
import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.exception.OccupiedCellException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LogicTest {

    @Test
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test
    public void whenMoveAllowedCellIsFree()
            throws OccupiedCellException, FigureNotFoundException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.H6));
        logic.move(Cell.C1, Cell.G5);
    }

    @Test
    public void whenMoveForbiddenCellIsOccupied()
            throws OccupiedCellException, FigureNotFoundException, ImpossibleMoveException {
        boolean rsl = false;
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.G5));
        try {
            logic.move(Cell.C1, Cell.H6);
        } catch (OccupiedCellException e) {
            rsl = true;
        }
        assertThat(rsl, is(true));
    }

    @Test
    public void whenMoveAllowedLegalMove()
            throws OccupiedCellException, FigureNotFoundException, ImpossibleMoveException {
        boolean rsl = false;
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.G6));
        logic.move(Cell.C1, Cell.G5);
    }

    @Test
    public void whenMoveForbiddenIllegalMove()
            throws OccupiedCellException, FigureNotFoundException, ImpossibleMoveException {
        boolean rsl = false;
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.G5));
        try {
            logic.move(Cell.C1, Cell.G6);
        } catch (ImpossibleMoveException e) {
            rsl = true;
        }
        assertThat(rsl, is(true));
    }
}