package bg.sofia.uni.fmi.mjt.gameplatform.store.items.category;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public abstract class Base implements StoreItem {
    String title;
    BigDecimal price;
    List<Double> ratings;
    LocalDateTime releaseDate;

    public Base(String title,
    BigDecimal price,
    List<Double> ratings,
    LocalDateTime releaseDate){
        this.title = title;
        this.price = price;
        this.releaseDate = releaseDate;
        this.ratings = ratings;
    }

    @Override
    public String getTitle(){
        return title;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public double getRating() {
        double sum = 0;
        for(Double rat : ratings){
            sum += rat;
        }
        return sum / ratings.size();
    }

    @Override
    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public void rate(double rating) {
        this.ratings.add(rating);
    }
}
