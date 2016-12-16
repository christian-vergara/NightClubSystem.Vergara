package Model.Bags;

import App.App;
import Model.Objects.Employee;
import Model.Objects.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by chris on 11/6/2016.
 */
public class UserBag {

    private List<User> userBag = new ArrayList<>();
    private UserBag userBagClass = this;
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


    public UserBag getUserBagClass() {
        return userBagClass;
    }

    public User verifyLogin(String userName, String password) {
        User user = null;
        for (int i = 0;i < userBag.size();i++) {
            if (Objects.equals(App.getUserBag().getUserBag().get(i).getUserName(), userName) && Objects.equals(App.getUserBag().getUserBag().get(i).getPassword(), password)) {
                user = App.getUserBag().userBag.get(i);
            }
        }
   return user;
    }


    public User getCurrentUser() {
        return currentUser;
    }


    public User findUser(int userId) {
        int index = 0;
        for(int i = 0;i < userBag.size();i++ ) {
            if (userBag.get(i).getUserId() == userId) {
                index = i;
                return userBag.get(index);
            }
        }
        return null;
    }


}