package bg.sofia.uni.fmi.mjt.gameplatform.store.items.filter;


import bg.sofia.uni.fmi.mjt.gameplatform.store.items.category.StoreItem;

public class RatingItemFilter implements ItemFilter{
    Double minrate;

    public RatingItemFilter(Double minrate) {
        this.minrate = minrate;
    }

    public Double getMinrate() {
        return minrate;
    }

    public void setMinrate(Double minrate) {
        this.minrate = minrate;
    }

    @Override
    public boolean matches(StoreItem item) {
        return item.getRating() > minrate;
    }
}
