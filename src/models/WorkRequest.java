package models;

public class WorkRequest {

    private String name;
    private String state;
    private String email;
    private int salary;

    public WorkRequest(String name, String state, String email, int salary) {
        this.name = name;
        this.state = state;
        this.email = email;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public String getEmail() {
        return email;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkRequest that = (WorkRequest) o;

        if (salary != that.salary) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        return email != null ? email.equals(that.email) : that.email == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + salary;
        return result;
    }

    @Override
    public String toString() {
        return "WorkRequest{" +
                "name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }
}
