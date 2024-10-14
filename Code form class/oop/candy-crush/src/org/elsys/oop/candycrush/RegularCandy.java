package org.elsys.oop.candycrush;

public class RegularCandy extends Candy{
    
    public RegularCandy(Game game) {
        super(game);
        this.type = (int) Math.floor(Math.random() * 4);
    }
    
    @Override
    public void display(){
            System.out.print(type);
    }

    @Override
    public void onSwap(Coordinate coordinate) {
        horizontalCheck(coordinate);
        verticalSwap(coordinate);
    }

    //equals

    private void horizontalCheck(Coordinate coordinate){
        int rightBound = coordinate.x();
        for (int i = coordinate.x(); i < game.getSize() && game.board[i][coordinate.y()].equals(this); i++) {
            rightBound = i;
        }
        int leftBound = coordinate.x();
        for (int i = coordinate.x(); i >= 0 && game.board[i][coordinate.y()].equals(this); i++) {
            leftBound = i;
        }

        //... hw
    }

    //vertical check hw
}