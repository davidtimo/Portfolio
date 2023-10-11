public class Seller extends User{

    private String username;

    private String tokoName;

    private String password;

    private String tokoType;

    private String desc;

    Seller(String username, String tokoName, String password, String tokoType, String desc){

        super.username = username;
        this.tokoName = tokoName;
        super.password = password;
        this.tokoType = tokoType;
        this.desc = desc;

    }

    public String getTokoName(){
        return tokoName;
    }

    public String getTokoType(){
        return tokoType;
    }

    public String getDesc(){
        return desc;
    }
}
