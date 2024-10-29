package bg.sofia.uni.fmi.mjt.gameplatform.store.items.category;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class DLC extends Base {

    Game game;

    public DLC(String title, BigDecimal price, List<Double> ratings, LocalDateTime releaseDate, Game game) {
        super(title, price, ratings, releaseDate);
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
