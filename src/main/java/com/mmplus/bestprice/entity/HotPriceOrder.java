package com.mmplus.bestprice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="hot_price_order")
public class HotPriceOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_id", updatable=false, insertable=false, nullable=false)
    private Long id;
	
	@Column(name="company_name")
    private String companyName;
	
	@Column(name="ean")
    private String productEan;
	
	@Column(name="product_name")
    private String productName;
    
	@Column(name="regular_price")
	private Long regularPrice;
	
	@Column(name="discount_price")
    private Long discountPrice;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="bestPriceEventId", insertable=false, updatable=false)
    private BestPriceEvent bestPriceEvent;
	
    public HotPriceOrder(){
    }

    public HotPriceOrder(Long bestPriceOrderId, String companyName, String productEan, String productName,
                          Long regularPrice, Long discountPrice, BestPriceEvent bestPriceEvent) {
        this.id = bestPriceOrderId;
        this.companyName = companyName;
        this.productEan = productEan;
        this.productName = productName;
        this.regularPrice = regularPrice;
        this.discountPrice = discountPrice;
        this.bestPriceEvent = bestPriceEvent;
    }

    public Long getBestPriceOrderId() {
        return id;
    }

    public void setBestPriceOrderId(Long bestPriceOrderId) {
        this.id = bestPriceOrderId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
    
	public Long getHotPriceOrderId() {
		return id;
	}

	public void setHotPriceOrderId(Long hotPriceOrderId) {
		this.id = hotPriceOrderId;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((bestPriceEvent == null) ? 0 : bestPriceEvent.hashCode());
		result = prime * result + ((discountPrice == null) ? 0 : discountPrice.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((productEan == null) ? 0 : productEan.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((regularPrice == null) ? 0 : regularPrice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HotPriceOrder other = (HotPriceOrder) obj;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (bestPriceEvent == null) {
			if (other.bestPriceEvent != null)
				return false;
		} else if (!bestPriceEvent.equals(other.bestPriceEvent))
			return false;
		if (discountPrice == null) {
			if (other.discountPrice != null)
				return false;
		} else if (!discountPrice.equals(other.discountPrice))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (productEan == null) {
			if (other.productEan != null)
				return false;
		} else if (!productEan.equals(other.productEan))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (regularPrice == null) {
			if (other.regularPrice != null)
				return false;
		} else if (!regularPrice.equals(other.regularPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HoPriceOrder [hotPriceOrderId=" + id + ", CompanyName=" + companyName + ", productEan="
				+ productEan + ", productName=" + productName + ", regularPrice=" + regularPrice + ", discountPrice="
				+ discountPrice + ", bestPriceEvent=" + bestPriceEvent + "]";
	}
    
    
}
