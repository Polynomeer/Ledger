package beans;

public class User {
    private int uid;
    private String id;
    private String password;
    private String name;
    private String phone;
    private char gender;
    private String job;
    private String hobby;
    private String address;
    private int age;

    public User(int uid, String id, String password, String name, String phone, char gender, String job, String hobby, String address, int age) {
        this.uid = uid;
        this.id = id;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.job = job;
        this.hobby = hobby;
        this.address = address;
        this.age = age;
    }

    public int getUid() {
        return uid;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public char getGender() {
        return gender;
    }

    public String getJob() {
        return job;
    }

    public String getHobby() {
        return hobby;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }
}
