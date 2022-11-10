package cn.chnzxg.yhx.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @author chnzxg
 * @date 2022/11/7 10:27
 */
@Data
@Table(name = "dish")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DishDO {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    private Double price;
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private Integer classId;
    @Transient
    private String className;

    public void init() {
        this.setName(this.getName() == null ? "" : this.getName().trim());
        this.setUpdateTime(new Date());
    }

}
