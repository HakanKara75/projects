package projects.loginpage_app;

public class User {
    // 3. adim  name, user name, email, password

    private String name;
    private String username;
    private String email;
    private String password;

    //4. adim user objesi olusturulurken ozellikler set edilsin.

    public User(String name, String username, String email, String password){
        this.name=name;
        this.username=username;
        this.email=email;
        this.password=password;

    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
