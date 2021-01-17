package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.exception.FigureNotFoundException;
import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.exception.OccupiedCellException;

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

    @Test (expected = OccupiedCellException.class)
    public void whenMoveForbiddenCellIsOccupied()
            throws OccupiedCellException, FigureNotFoundException, ImpossibleMoveException {
        boolean rsl = false;
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.G5));
        logic.move(Cell.C1, Cell.H6);
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

    @Test (expected = ImpossibleMoveException.class)
    public void whenMoveForbiddenIllegalMove()
            throws OccupiedCellException, FigureNotFoundException, ImpossibleMoveException {
        boolean rsl = false;
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.G5));
        logic.move(Cell.C1, Cell.G6);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenMoveForbiddenIllegalMove2()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.G5));
        logic.move(Cell.C1, Cell.G6);
    }
}