package biometricauth.models;

public class User {
    private String UID;
    private String username;
    private String password;
    private HandGeometry handGeometry;

    public User(String UID, String username, String password) {
        this.UID = UID;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "UID='" + UID + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", HandGeometry= {"+ handGeometry+"}" + 
                '}';
    }

    public User() {

    }

    public void setHandGeometry(HandGeometry handGeometry){
        this.handGeometry = handGeometry;
    }

    public HandGeometry getHandGeometry(){
        return handGeometry;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

