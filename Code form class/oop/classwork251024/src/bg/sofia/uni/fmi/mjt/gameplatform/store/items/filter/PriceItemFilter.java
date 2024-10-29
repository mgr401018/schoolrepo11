package bg.sofia.uni.fmi.mjt.gameplatform.store.items.filter;

import bg.sofia.uni.fmi.mjt.gameplatform.store.items.category.StoreItem;
import java.math.BigDecimal;

public class PriceItemFilter implements ItemFilter{

    BigDecimal lowerBound;
    BigDecimal upperBound;

    public PriceItemFilter(BigDecimal upperBound, BigDecimal lowerBound) {
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
    }

    @Override
    public boolean matches(StoreItem item) {
        return item.getPrice().compareTo(lowerBound) > -1 && item.getPrice().compareTo(upperBound) < 1;
    }
}
