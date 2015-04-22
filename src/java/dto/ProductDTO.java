/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author ThanhHV
 */
public class ProductDTO {

    private int PID;
    private String Name;
    private int Price;
    private String Description;
    private String Category;
    private String Image;
    private int Instock;
    private int Promotion;

    public ProductDTO(int PID, String Name, int Price, String Description, String Category, String Image, int Instock, int Promotion) {
        this.PID = PID;
        this.Name = Name;
        this.Price = Price;
        this.Description = Description;
        this.Category = Category;
        this.Image = Image;
        this.Instock = Instock;
        this.Promotion = Promotion;
    }

    public ProductDTO() {

    }

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public int getInstock() {
        return Instock;
    }

    public void setInstock(int Instock) {
        this.Instock = Instock;
    }

    public int getPromotion() {
        return Promotion;
    }

    public void setPromotion(int Promotion) {
        this.Promotion = Promotion;
    }

}
