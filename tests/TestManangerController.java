import controllers.ManagerController;
import controllers.ManagerControllerImpl;
import dataBase.DataBase;
import exceptions.NoSuchContactException;
import javafx.collections.ObservableList;
import models.User;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestManangerController {

    private DataBase dataBase = DataBase.getInstance();
    private ManagerController manangerConroller = new ManagerControllerImpl();
    private User user1, user2, user3, mentor;

    @Before
    public void initDB() {
        mentor = new User("mentor", "123", "user@gmail.com");
        user1 = new User("user1", "user1@gmail.com", mentor);
        user2 = new User("user2", "user2@gmail.com", mentor);
        user3 = new User("user3", "123", "user3@gmail.com");
        dataBase.users.put("1", user1);
        dataBase.users.put("2", user2);
        dataBase.users.put("3", user3);
        dataBase.users.put("4", mentor);
    }

    @After
    public void after(){
        dataBase = null;
    }

    @Test
    public void testShowMyUsers(){
        ObservableList<User> result = manangerConroller.showMyUsers(mentor);
        assertTrue(result.contains(user1));
        assertTrue(result.contains(user2));
        assertTrue(!result.contains(user3));

    }
    @Test
    public void testShowUserInfo() throws NoSuchContactException {

        String res = manangerConroller.showUserInfo("user1");
        assertTrue(res.contains("user1"));
    }

    @Test(expected = NoSuchContactException.class)
    public void negativeTestShowUserInfo() throws NoSuchContactException {

        String res = manangerConroller.showUserInfo("user4");
        assertTrue(res.contains("user4"));
    }

    @Test
    public void testUpdateInfo() throws NoSuchContactException {

        User newUser = new User("user11", "123", "u@gmail.com");
        manangerConroller.updateInfo("user1", newUser);
        assertTrue(dataBase.users.containsValue(newUser));
    }

    @Test(expected = NoSuchContactException.class)
    public void negativeTestUpdateInfo() throws NoSuchContactException {

        User newUser = new User("user11", "123", "u@gmail.com");
        manangerConroller.updateInfo("user67", newUser);
        assertTrue(dataBase.users.containsValue(newUser));
    }

}
