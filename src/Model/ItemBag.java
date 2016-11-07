package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 11/6/2016.
 */
public class ItemBag {

    private List<Item> itemBag = new ArrayList<>();

    public void addItem(Item item) {
        itemBag.add(item);
    }

    public void removeItem(Item item) {
        itemBag.remove(item);
    }

    public Item findItem(Item item) {
        for(int i = 0;i < itemBag.size();i++) {
            if (itemBag.get(i) == item) {
                return itemBag.get(i);
            }
        }
        return null;
    }

    public int getSize() {
        return itemBag.size();
    }

    public Item getItem(int index) {
        return itemBag.get(index);
    }
}
