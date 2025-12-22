package requests.jacksonbinding.POJO;

public class Headquarters {

    public Headquarters(String city, String state) {
        this.city = city;
        this.state = state;
    }

    private String city;
    private String state;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
