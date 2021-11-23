package product;


import java.io.Serializable;

public interface Product extends Serializable {
    public String getName();

    public double getCost();

    public String getDescription();

    TypeProduct getTypeProduct();
}
