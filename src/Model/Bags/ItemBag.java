package Model.Bags;

import Model.Objects.Item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 11/6/2016.
 */
public class ItemBag implements Serializable {

    private List<Item> itemBag = new ArrayList<>();

    public void addItem(Item item) {
        itemBag.add(item);
    }

    public void removeItem(Item item) {
        itemBag.remove(item);
    }

    public Item findItem(String name) {
        for(int i = 0;i < itemBag.size();i++) {
            if (itemBag.get(i).getName().equalsIgnoreCase(name)) {
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
