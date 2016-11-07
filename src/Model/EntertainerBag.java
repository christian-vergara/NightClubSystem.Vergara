package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 11/6/2016.
 */
public class EntertainerBag {

    private List<Entertainer> entertainerBag = new ArrayList<>();

    public void addEntertainer(Entertainer entertainer) {
        entertainerBag.add(entertainer);
    }

    public void removeEntertainer(Entertainer entertainer) {
        entertainerBag.remove(entertainer);
    }

    public Entertainer findEntertainer(Entertainer entertainer) {
        for(int i = 0;i < entertainerBag.size();i++) {
            if (entertainerBag.get(i) == entertainer) {
                return entertainerBag.get(i);
            }
        }
        return null;
    }

}
