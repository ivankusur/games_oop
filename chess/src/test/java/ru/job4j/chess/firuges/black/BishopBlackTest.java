package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static ru.job4j.chess.firuges.Cell.*;

public class BishopBlackTest {

    @Test
    public void whenSameCellWithCreatePosition() {
        BishopBlack bishopBlack = new BishopBlack(A1);
        assertThat(bishopBlack.position(), is(A1));
    }

    @Test
    public void whenCorrectPositionCopy() {
        BishopBlack bishopBlack = new BishopBlack(A1);
        assertThat((bishopBlack.copy(A2)).position(), is(A2));
    }

    @Test
    public void whenWayC1ToG2Correct() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        try {
            assertThat(bishopBlack.way(G5), is(new Cell[]{D2, E3, F4, G5}));
        } catch (ImpossibleMoveException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenIsNoDiagonal() {
        boolean rsl = false;
        BishopBlack bishopBlack = new BishopBlack(C1);
        try {
            bishopBlack.way(G6);
        } catch (ImpossibleMoveException e) {
            rsl = true;
        }
        assertThat(rsl, is(true));
    }
}
