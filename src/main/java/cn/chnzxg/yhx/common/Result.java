package cn.chnzxg.yhx.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chnzxg
 * @date 2022/11/7 10:41
 * @description
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Result<T> implements Serializable {

    private Integer status;
    private String msg;
    private Integer page;
    private Integer limit;
    private Integer total;
    private T data;

    public static <T> Result<T> success() {
        return new Result<T>();
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    public static <T> Result<T> error(String msg) {
        return new Result<T>(msg);
    }

    public static <T> Result<T> page(T data, Integer page, Integer limit, Integer total) {
        if (page == null) page = 0;
        if (limit == null) page = 10;
        return new Result<>(data, page, limit, total);
    }

    public Result() {
        this.status = 200;
        this.msg = "成功";
        this.data = null;
    }

    private Result(T data) {
        this.status = 200;
        this.msg = "成功";
        this.data = data;
    }

    private Result(String msg) {
        this.status = 500;
        this.msg = msg;
        this.data = null;
    }

    private Result(T data, Integer pageIndex, Integer pageSize, Integer total) {
        this.status = 200;
        this.msg = "成功";
        this.data = data;
        this.page = pageIndex;
        this.limit = pageSize;
        this.total = total;
    }

}
