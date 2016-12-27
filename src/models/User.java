package models;

public class User {

    private String login;
    private String password;
    private String email;
    private User mentor;

    public User() {
    }

    public User(String login, String password, String email) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public User(String login, String email, User mentor) {
        this.login = login;
        this.email = email;
        this.mentor = mentor;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public User getMentor() {
        return mentor;
    }

    public String getPassword() {
        return password;
    }

    public void setMentor(User mentor) {
        this.mentor = mentor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return login.equals(user.login);
    }

    @Override
    public int hashCode() {
        return login.hashCode();
    }

    @Override
    public String toString() {
        return mentor != null ? "User{" +
                "login='" + login + '\'' +
                '}';
    }
}
