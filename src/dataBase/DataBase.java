package dataBase;

import models.ContactList;
import models.SupportRequest;
import models.User;
import models.WorkRequest;

import java.util.*;

public class DataBase {

    private static DataBase instance;
 
    private DataBase() {
    }

    static {
        String fromJson = new Logger().read();
        if (fromJson.isEmpty()) {
            instance = new DataBase();
        } else {
            instance = Converter.fromJson(fromJson, DataBase.class);
        }
    }

    public static DataBase getInstance() {
        return instance;
    }

    public final Map<String, User> users = new HashMap<>();
    public final Map<String, User> managers = new HashMap<>();

    public final List<SupportRequest> supportRequests = new ArrayList<>();
    public final Map<String, ContactList> contactLists = new HashMap<>();
    public final Map<String, User> banned = new HashMap<>();
    public final Map<String, SupportRequest> managerSupportRequest = new HashMap<>();

    public final Queue<WorkRequest> workRequests = new LinkedList<>();

}
