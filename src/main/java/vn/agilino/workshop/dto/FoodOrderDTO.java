package vn.agilino.workshop.dto;

public class FoodOrderDTO {

    private int id;
    private String address;
    private String foodName;

    public FoodOrderDTO(int id, String address, String foodName) {
        this.id = id;
        this.address = address;
        this.foodName = foodName;
    }

    public FoodOrderDTO() {
    }

    public int getId() {
        return this.id;
    }

    public String getAddress() {
        return this.address;
    }

    public String getFoodName() { return foodName; }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFoodName(String foodName) { this.foodName = foodName; }

    @Override
    public String toString() {
        return "FoodOrderDTO{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", foodName='" + foodName + '\'' +
                '}';
    }
}
