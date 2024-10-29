package bg.sofia.uni.fmi.mjt.gameplatform.store.items.category;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class GameBundle extends Base {

    Game[] games;

    public GameBundle(String title, BigDecimal price, List<Double> ratings, LocalDateTime releaseDate, Game[] games) {
        super(title, price, ratings, releaseDate);
        this.games = games;
    }

    public Game[] getGames() {
        return games;
    }

    public void setGames(Game[] games) {
        this.games = games;
    }
}
