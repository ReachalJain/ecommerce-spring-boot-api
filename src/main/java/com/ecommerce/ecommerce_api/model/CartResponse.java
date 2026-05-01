package com.ecommerce.ecommerce_api.model;

public class CartResponse {

    private int cartId;
    private int userId;
    private int productId;
    private Integer quantity;


    private String productName;
    private double productPrice;
    private String productImage;
    private String productDescription;


    public CartResponse(int cartId, int userId, int productId,
                        Integer quantity, String productName,
                        double productPrice, String productImage,
                        String productDescription) {
        this.cartId = cartId;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.productDescription = productDescription;
    }


    public int getCartId() { return cartId; }
    public int getUserId() { return userId; }
    public int getProductId() { return productId; }
    public Integer getQuantity() { return quantity; }
    public String getProductName() { return productName; }
    public double getProductPrice() { return productPrice; }
    public String getProductImage() { return productImage; }
    public String getProductDescription() { return productDescription; }
}