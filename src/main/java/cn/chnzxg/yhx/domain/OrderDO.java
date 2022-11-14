package cn.chnzxg.yhx.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author chnzxg
 * @date 2022/11/10 15:14
 * @description
 */
@Data
@Table(name = "public.order")
public class OrderDO implements Serializable {

    public enum ORDER_TYPE {
        HALL(0, "hall"),
        TAKEOUT(1, "takeout");

        private int code;
        private String desc;
        ORDER_TYPE(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    private Integer type;
    private Double discount;
    private Integer people;
    private String common;
    private Date time;
    @Transient
    private double estimate;
    private double actual;
    @Transient
    private double estimateAvg;
    @Transient
    private double actualAvg;
    @Transient
    private List<OrderDishDO> orderDishDOList;
}
