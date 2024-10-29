package bg.sofia.uni.fmi.mjt.gameplatform.store.items.filter;

import bg.sofia.uni.fmi.mjt.gameplatform.store.items.category.StoreItem;

/**
 * A filter used to search for store items.
 */
public interface ItemFilter {

    /**
     * Checks if the given store item matches the filter.
     *
     * @param item the store item to be checked
     * @return true if the store item matches the filter, false otherwise
     */
    boolean matches(StoreItem item);

}