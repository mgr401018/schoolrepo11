package bg.sofia.uni.fmi.mjt.gameplatform.store.items.category;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Game extends Base {
    String genre;

    public Game(String title, BigDecimal price, List<Double> ratings, LocalDateTime releaseDate, String genre) {
        super(title, price, ratings, releaseDate);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
