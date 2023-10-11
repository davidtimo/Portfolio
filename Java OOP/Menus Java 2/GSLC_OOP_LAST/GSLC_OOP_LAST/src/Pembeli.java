public class Pembeli extends User{

    private String username;
    private String name;

    private String gender;
    private String password;

    public void setUsername(String username){
        this.username = username;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public void setPassword(String password){
        this.password = password;
    }

    Pembeli(String username, String name, String gender, String password){

        super.username = username;
        this.name = name;
        this.gender = gender;
        super.password = password;

    }

}
