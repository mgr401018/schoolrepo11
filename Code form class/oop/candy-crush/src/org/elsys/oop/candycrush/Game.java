package org.elsys.oop.candycrush;

public class Game {
    Candy[][] board;
    private int score;
    private int size;

    //alt + insert -> constructor, getters and setters

    public Game(int size) {
        this.size = size;
        this.board = new Candy[size][size];
        this.score = 0;
        fillBoard();
    }

    private final int maxBomb = 5;
    private final double BOMB_CHANCE = 0.05;

    //shift + f6 smart refactor (search and replace)

    private void fillBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                createCandy(i, j);
            }
        }
    }

    void createCandy(int i, int j) {
        if(Math.random()<BOMB_CHANCE) {
            board[i][j] = new BombCandy(this);
        } else {
            board[i][j] = new RegularCandy(this);

        }

    }

    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j].display();
            }
            System.out.println();
        }
    }

    public void swap(Coordinate coordinate, int x, int y, Direction direction  ) {
        Coordinate n = coordinate.neighbour(direction);
        if (!n.isInBoard(size)) throw new RuntimeException("Invalid Swap");

        Candy temp = board[n.x()][n.y()];
        board[n.x()][n.y()] =  board[coordinate.x()][coordinate.y()];
        board[coordinate.x()][coordinate.y()] = temp;

        temp.onSwap(coordinate);

        //neshto v git 
    }

    public int getSize() {
        return size;
    }
}