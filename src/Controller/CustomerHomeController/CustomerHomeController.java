package Controller.CustomerHomeController;

import App.App;
import Controller.Login.LoginController;
import Model.Bags.TableBag;
import Model.Objects.Customer;
import Model.Objects.Table;
import View.CustomerHomeView.CustomerHomeView;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

/**
 * Created by Studio on 12/16/2016.
 */
public class CustomerHomeController {

    private CustomerHomeView view;
    private int ticketAmount;
    private TableBag tablebag;

    public CustomerHomeController(CustomerHomeView view) {
        this.view = view;
        view.setCustomerHomeEventListener(new CustomerHomeEventListener() {
            @Override
            public void btnClicked(CustomerHomeEventObject customerHomeEventObject) {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Purchase Ticket");
                dialog.setHeaderText("Enter the quantity of tickets");

                System.out.println(App.getUserBag().findUser(3));
                System.out.println(App.getTableBag().findTable(1).getTblCapacity());

                Optional<String> result = dialog.showAndWait();
                ticketAmount = Integer.parseInt(result.get());
                for (int i = 0; i < App.getTableBag().getTableList().size(); i++) {
                    if (App.getTableBag().getTables(i).getCurrentSitting() < App.getTableBag().getTables(i).getTblCapacity()) {
                        App.getTableBag().getTables(i).addCustomer((Customer) App.getUserBag().findUser(view.getCurrent().getUserId()));
                        App.getTableBag().getTables(i).addSitting(ticketAmount);
                        view.getCurrent().setTicketAmount(ticketAmount);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Purchased");
                        alert.setHeaderText("You have purchased " + ticketAmount + " tickets" + "\nYour table number is: " + App.getTableBag().getTables(i).getTblNbr() + "\nThank You!");
                        alert.showAndWait();
                        break;
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Whoops!");
                        alert.setHeaderText("It looks like our tables are full tonight! We apologize and hope to see you soon, Thank you!");
                    }

                }
            }
        });



    }
}
