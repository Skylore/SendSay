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

        return login != null ? login.equals(user.login) : user.login == null &&
                (password != null ? password.equals(user.password) : user.password == null &&
                        (email != null ? email.equals(user.email) : user.email == null &&
                                (mentor != null ? mentor.equals(user.mentor) : user.mentor == null)));

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (mentor != null ? mentor.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mentor=" + mentor.toString() +
                '}';
    }
}
