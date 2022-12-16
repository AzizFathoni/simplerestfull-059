/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorialpoint.point;

/**
 *
 * @author Lenovo
 */
public class Product {
    private String Id;
    private String Name;
    private Integer Price;
    private Integer Number;
    private Integer Total;

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer Price) {
        this.Price = Price;
    }

    public Integer getNumber() {
        return Number;
    }

    public void setNumber(Integer Number) {
        this.Number = Number;
    }

    public Integer getTotal() {
        return Total;
    }

    public void setTotal() {
        this.Total = Price * Number;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
}
