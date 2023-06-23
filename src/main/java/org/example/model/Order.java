package org.example.model;

import lombok.*;
import org.example.base.model.BaseEntity;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class Order extends BaseEntity<Integer> {
    private int userID;
    private boolean status;
    private int shippingID;
    private long paycheck;



    public Order(Integer integer, int userID, boolean status, int shippingID, long paycheck) {
        super(integer);
        this.userID = userID;
        this.status = status;
        this.shippingID = shippingID;
        this.paycheck = paycheck;
    }
}
