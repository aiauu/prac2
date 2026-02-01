import java.util.ArrayList;
import java.util.List;

public class prac2 {

    public static void main(String[] args) {

        UserManager manager = new UserManager();

        User user1 = new User("Ayan", "ayan@mail.com", "Admin");
        User user2 = new User("Dana", "dana@mail.com", "User");

        manager.addUser(user1);
        manager.addUser(user2);

        manager.updateUser("Dana", "dana_new@mail.com", "Admin");
        manager.removeUser("Ayan");

        manager.printUsers();
    }
}

class User {
    private String name;
    private String email;
    private String role;

    public User(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void update(String email, String role) {
        this.email = email;
        this.role = role;
    }

    @Override
    public String toString() {
        return name + " | " + email + " | " + role;
    }
}

class UserManager {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(String name) {
        users.removeIf(u -> u.getName().equals(name));
    }

    public void updateUser(String name, String email, String role) {
        User user = findByName(name);
        if (user != null)
            user.update(email, role);
    }

    private User findByName(String name) {
        for (User u : users)
            if (u.getName().equals(name))
                return u;
        return null;
    }

    public void printUsers() {
        for (User u : users)
            System.out.println(u);
    }
}