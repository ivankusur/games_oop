package ru.job4j.puzzle;

public class Win {

    public static boolean monoHorizontal(int[][] matrix, int row) {
        boolean result = true;
        for (int cell = 0; cell < matrix[row].length; cell++) {
            if (matrix[row][cell] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean monoVertical(int[][] matrix, int cell) {
        boolean result = true;
        for (int[] chars : matrix) {
            if (chars[cell] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static int[] extractDiagonal(int[][] board) {
        int[] rsl = new int[board.length];
        for (int i = 0; i < board.length; i++) {
            rsl[i] = board[i][i];
        }
        return rsl;
    }

    public static boolean check(int[][] board) {
        boolean result = false;
        int[] diagonal = extractDiagonal(board);
        for (int i = 0; i < board.length; i++) {
            if (diagonal[i] == 1) {
                if (monoHorizontal(board, i) || monoVertical(board, i)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
