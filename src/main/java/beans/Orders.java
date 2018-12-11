package beans;

public class Orders {
    private int id;
    private String ordertime;
    private float price;
    private String state;
    private String user_id;

    public Orders() {
    }

    public Orders(int id, String ordertime, float price, String state, String user_id) {
        this.id = id;
        this.ordertime = ordertime;
        this.price = price;
        this.state = state;
        this.user_id = user_id;
    }

    public int getId(int anInt) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
