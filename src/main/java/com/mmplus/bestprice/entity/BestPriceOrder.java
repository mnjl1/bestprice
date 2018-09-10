package com.mmplus.bestprice.entity;

public class BestPriceOrder {
    private Long bestPriceOrderId;
    private String CompanyName;
    private String productEan;
    private String productName;
    private Long regularPrice;
    private Long discountPrice;
    private BestPriceEvent bestPriceEvent;

    private BestPriceOrder(){
    }

    public BestPriceOrder(Long bestPriceOrderId, String companyName, String productEan, String productName,
                          Long regularPrice, Long discountPrice, BestPriceEvent bestPriceEvent) {
        this.bestPriceOrderId = bestPriceOrderId;
        CompanyName = companyName;
        this.productEan = productEan;
        this.productName = productName;
        this.regularPrice = regularPrice;
        this.discountPrice = discountPrice;
        this.bestPriceEvent = bestPriceEvent;
    }

    public Long getBestPriceOrderId() {
        return bestPriceOrderId;
    }

    public void setBestPriceOrderId(Long bestPriceOrderId) {
        this.bestPriceOrderId = bestPriceOrderId;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getProductEan() {
        return productEan;
    }

    public void setProductEan(String productEan) {
        this.productEan = productEan;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(Long regularPrice) {
        this.regularPrice = regularPrice;
    }

    public Long getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Long discountPrice) {
        this.discountPrice = discountPrice;
    }

    public BestPriceEvent getBestPriceEvent() {
        return bestPriceEvent;
    }

    public void setBestPriceEvent(BestPriceEvent bestPriceEvent) {
        this.bestPriceEvent = bestPriceEvent;
    }
}
