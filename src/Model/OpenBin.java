package Model;

import App.App;
import Model.Bags.CustomerBag;
import Model.Bags.ItemBag;
import Model.Bags.TableBag;
import Model.Bags.UserBag;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by Studio on 12/16/2016.
 */
public class OpenBin {

    public static void openFile() throws IOException, ClassNotFoundException {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(new File("C:\\Users\\Studio\\IdeaProjects\\NightClubSystem.Vergara\\Club.dat")));
        App.setTableBag((TableBag) is.readObject());
        App.setItemBag((ItemBag) is.readObject());
        App.setUserBag((UserBag) is.readObject());
        System.out.println("File Read!");
    }
}
