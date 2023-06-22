package Model;

import java.util.ArrayList;

public class UserRepository {
    private static UserRepository instance;
    private ArrayList<User> userList;

    private UserRepository() {
        userList = new ArrayList<>();
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public ArrayList<User> getUserList() {
        return userList;
    }
}

