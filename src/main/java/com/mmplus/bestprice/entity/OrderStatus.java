package com.mmplus.bestprice.entity;

import com.mmplus.bestprice.util.Constants;

public enum OrderStatus {

    ORDER_STATUS_UNDER_CONSIDERATION(0){
        public String toString(){
            return Constants.UA_ORDER_UNDER_CONSIDERATION;
        }
    },

    ORDER_STATUS_ACCEPTED(1){
        public String toString(){
            return Constants.UA_ORDER_STATUS_ACCEPTED;
        }
    },

    ORDER_STATUS_DECLINED(2){
        public String toString(){
            return Constants.UA_ORDER_STATUS_DECLINED;
        }
    };

    private int orderStatusValue;

    OrderStatus(int orderStatusValue) {
        this.orderStatusValue = orderStatusValue;
    }

    public int getOrderStatusValue() {
        return orderStatusValue;
    }
}
