package Model;

import Model.Bags.CustomerBag;
import Model.Bags.ItemBag;
import Model.Bags.TableBag;
import Model.Bags.UserBag;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by Studio on 12/16/2016.
 */
public class SaveBin {

    public static void save() throws IOException {
        try {
            FileOutputStream outputStream = new FileOutputStream("Club.dat");
            ObjectOutputStream objStream = new ObjectOutputStream(outputStream);
            System.out.println("Writing file...");
            objStream.writeObject(App.App.getTableBag());
            objStream.writeObject(App.App.getItemBag());
            objStream.writeObject(App.App.getUserBag());
            objStream.close();
            System.out.println("File Written!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
