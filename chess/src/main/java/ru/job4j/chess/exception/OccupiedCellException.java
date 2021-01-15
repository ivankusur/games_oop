package ru.job4j.chess.exception;

public class OccupiedCellException extends Exception {
    public OccupiedCellException(String message) {
        super(message);
    }
}
