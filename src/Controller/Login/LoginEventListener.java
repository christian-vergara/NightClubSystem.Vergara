package Controller.Login;

import java.util.EventListener;

/**
 * Created by chris on 11/9/2016.
 */
public interface LoginEventListener extends EventListener {
    void btnClicked(LoginEventObject ev);
}
