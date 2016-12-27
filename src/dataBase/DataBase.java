package dataBase;

import models.ContactList;
import models.SupportRequest;
import models.User;
import models.WorkRequest;

import java.util.*;

public class DataBase {

    private static DataBase instance;
 
    public DataBase() {
    }

    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }

        return instance;
    }

    public final Map<String, User> users = new HashMap<>();
    public final Map<String, User> managers = new HashMap<>();

    public final List<SupportRequest> supportRequests = new ArrayList<>();
    public final Map<String, ContactList> contactLists = new HashMap<>();
    public final Map<String, User> banned = new HashMap<>();

    public final Queue<WorkRequest> workRequests = new LinkedList<>();

}
