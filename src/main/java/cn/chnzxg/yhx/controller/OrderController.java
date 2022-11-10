package cn.chnzxg.yhx.controller;

import cn.chnzxg.yhx.common.Result;
import cn.chnzxg.yhx.domain.DishDO;
import cn.chnzxg.yhx.domain.OrderDO;
import cn.chnzxg.yhx.domain.OrderDishDO;
import cn.chnzxg.yhx.mapper.DishMapper;
import cn.chnzxg.yhx.mapper.OrderDishMapper;
import cn.chnzxg.yhx.mapper.OrderMapper;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Date;
import java.util.List;

/**
 * @author chnzxg
 * @date 2022/11/7 10:39
 * @description
 */
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderController {

    private final OrderMapper orderMapper;
    private final OrderDishMapper orderDishMapper;
    private final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @GetMapping("/list")
    public Result<List<OrderDO>> list(
            @RequestParam(required = false) Integer type,
            @RequestParam(required = false) String common,
            @RequestParam(required = false) Date timeStart,
            @RequestParam(required = false) Date timeEnd,
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer limit
    ) {
        Condition condition = new Condition(OrderDO.class);
        Example.Criteria criteria = condition.createCriteria();
        if (StringUtil.isNotEmpty(common)) {
            criteria.andLike("common", "%" + common + "%");
        }
        if (timeStart != null) {
            criteria.andGreaterThanOrEqualTo("time", timeStart);
        }
        if (timeEnd != null) {
            criteria.andLessThanOrEqualTo("time", timeEnd);
        }
        if (type != null) {
            criteria.andEqualTo("type", type);
        }
        condition.setOrderByClause("id desc");

        PageHelper.startPage(page, limit);
        List<OrderDO> result = orderMapper.selectByCondition(condition);
        int count = orderMapper.selectCountByCondition(condition);
        return Result.page(result, page, limit, count);
    }

    @GetMapping("/get")
    public Result<OrderDO> get(
            @RequestParam Integer id
    ) {
        OrderDO orderDO = orderMapper.selectByPrimaryKey(id);
        Condition condition = new Condition(OrderDishDO.class);
        condition.createCriteria().andEqualTo("orderId", id);
        List<OrderDishDO> orderDishDOS = orderDishMapper.selectByCondition(condition);
        orderDO.setOrderDishDOList(orderDishDOS);
        return Result.success(orderDO);
    }

    @GetMapping("/delete")
    public Result<String> delete(
            @RequestParam Integer id
    ) {
        orderMapper.deleteByPrimaryKey(id);
        deleteAllOrderDish(id);
        return Result.success();
    }

    @PostMapping("/update")
    public Result<String> update(
            @RequestBody OrderDO orderDO
    ) {
        orderMapper.updateByPrimaryKey(orderDO);
        updateOrderDish(orderDO);
        return Result.success();
    }

    @PostMapping("/create")
    public Result<String> create(
            @RequestBody OrderDO orderDO
    ) {
        orderMapper.insert(orderDO);
        updateOrderDish(orderDO);
        return Result.success();
    }

    private void updateOrderDish(OrderDO orderDO) {
        deleteAllOrderDish(orderDO.getId());
        if (orderDO.getOrderDishDOList() != null && !orderDO.getOrderDishDOList().isEmpty()) {
            orderDO.getOrderDishDOList().forEach(orderDishMapper::insert);
        }
    }

    private void deleteAllOrderDish(Integer orderId) {
        Condition condition = new Condition(OrderDishDO.class);
        condition.createCriteria().andEqualTo("orderId", orderId);
        orderDishMapper.deleteByCondition(condition);
    }

}
