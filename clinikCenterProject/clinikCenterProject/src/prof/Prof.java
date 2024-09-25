package prof;

import java.util.HashMap;

public class Prof {
    public String name ;
    public String price ;




    public Prof() {
    }

    public Prof(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public Prof(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
