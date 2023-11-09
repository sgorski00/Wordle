package org.example.game.play;

import java.util.Arrays;

public class Board {
    private final char[][] board;

    public Board(){
        board = new char[6][5];
        initialization();
    }

    private void initialization(){
        for (char[] chars : board) {
            Arrays.fill(chars, '-');
        }
    }

    public void printBoard(){
        System.out.print("~~~~~~~\n");
        for (char[] chars : board) {
            System.out.print("|");
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.print("~~~~~~~\n");
    }

    public char[][] board() {
        return board;
    }
}
