package ru.job4j.tictactoe;
import javafx.scene.shape.Rectangle;

/**
 * Package for tictactoe.
 *
 * @author Evgeny Butov (mailto:but87@mail.ru)
 * @version 1
 * @since 02.08.2018
 */

public class Figure3T extends Rectangle {
    private boolean markX = false;
    private boolean markO = false;

    public Figure3T() {
    }

    public Figure3T(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }

    public void take(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }

    public boolean hasMarkX() {
        return this.markX;
    }

    public boolean hasMarkO() {
        return this.markO;
    }

    public boolean hasMarks() {
        return this.markX || this.markO;
    }
}