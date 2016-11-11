package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 11/6/2016.
 */
public class UserBag {

    private List<User> userBag = new ArrayList<>();
    private static UserBag userBagClass = new UserBag();
    private User currentUser;

    public UserBag() {

    }

    public void addUser(User user) {
        userBag.add(user);
    }

    public void removeUser(User user) {
        userBag.remove(user);
    }

    public List<User> getUserBag() {
        return userBag;
    }


    public static UserBag getUserBagClass() {
        return userBagClass;
    }

    public User verifyLogin(String userName, String password) {
        for (User anUserBag : userBag) {
            if (anUserBag.getUserName().matches(userName) && anUserBag.getPassword().matches(password)) {
                return anUserBag;
            }
        }
        return null;
    }


    public User getCurrentUser() {
        return currentUser;
    }
}