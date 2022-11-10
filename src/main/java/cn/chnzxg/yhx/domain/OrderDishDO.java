package cn.chnzxg.yhx.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author chnzxg
 * @date 2022/11/10 15:26
 * @description
 */
@Data
@Table(name = "order_dish")
public class OrderDishDO implements Serializable {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    private Integer orderId;
    private Integer dishId;
    private Integer dishCount;
    private Integer free;
    private Integer discount;
}
