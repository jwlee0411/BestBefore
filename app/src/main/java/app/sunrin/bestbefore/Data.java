package app.sunrin.bestbefore;

public class Data {

    private String productName;
    private String productCategory;
    private String productDate;
    private String productRegisterDate;

    public String getProductName()
    {
        return productName;
    }

    public String getProductCategory()
    {
        return productCategory;
    }
    public String getProductDate()
    {
        return productDate;
    }

    public String getProductRegisterDate(){return productRegisterDate;}

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public void setProductCategory(String productCategory)
    {
        this.productCategory = productCategory;
    }

    public void setProductDate(String productDate)
    {
        this.productDate = productDate;
    }

    public void setProductRegisterDate(String productRegisterDate){this.productRegisterDate = productRegisterDate;}



}
