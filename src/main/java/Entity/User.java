package Entity;

public class User {
    private String userId;
    private String name;
    private String password;
    private String email;
    private String avatar;
    private String address;
    private int type;

    //每个实体类必须要一个空的构造函数
    public User(){

    }

    public User(String userId, String name, String password, String email, String avatar, String address, int type) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
        this.address = address;
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
