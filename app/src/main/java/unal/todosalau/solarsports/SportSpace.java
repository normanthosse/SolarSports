package unal.todosalau.solarsports;

import android.widget.ImageView;

import androidx.annotation.Nullable;

public class SportSpace {       //la clase de todos los spacios deportivos
    private int img;
    private String name;
    private String address;
    private String city;
    private String phone;
    private Double power;
    private Double generated;
    private Double consumed;

    public SportSpace(){

    }

    public SportSpace(int img, String name, String address, String city, String phone, Double power, Double generated, Double consumed) {
        this.img = img;
        this.name = name;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.power = power;
        this.generated = generated;
        this.consumed = consumed;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public Double getGenerated() {
        return generated;
    }

    public void setGenerated(Double generated) {
        this.generated = generated;
    }

    public Double getConsumed() {
        return consumed;
    }

    public void setConsumed(Double consumed) {
        this.consumed = consumed;
    }

    //=================================================================
    //permite comparar si un objeto de la lista SportSpace es igual a otro, pero según el nombre
    @Override
    public boolean equals(@Nullable Object obj) {
        return name.equals(((SportSpace) obj).name);
    }
}
