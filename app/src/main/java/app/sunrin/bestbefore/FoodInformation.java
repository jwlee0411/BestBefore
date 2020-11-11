package app.sunrin.bestbefore;

import java.util.ArrayList;

public class FoodInformation {
    public ArrayList<String> category;
    public String productName;
    public int dateLeft;

    public FoodInformation(ArrayList<String> category, String productName, int dateLeft){
        this.category=category;
        this.productName=productName;
        this.dateLeft=dateLeft;
    }


}
