package cn.chnzxg.yhx.controller;

import cn.chnzxg.yhx.common.Result;
import cn.chnzxg.yhx.domain.DishDO;
import cn.chnzxg.yhx.mapper.DishMapper;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import javax.xml.validation.Validator;
import java.util.Date;
import java.util.List;

/**
 * @author chnzxg
 * @date 2022/11/7 10:39
 * @description
 */
@RestController
@RequestMapping("/dish")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DishController {

    private final DishMapper dishMapper;
    private final Logger logger = LoggerFactory.getLogger(DishController.class);

    @GetMapping("/list")
    public Result<List<DishDO>> list(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer priceStart,
            @RequestParam(required = false) Integer priceEnd,
            @RequestParam(required = false) Integer classId,
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer limit
    ) {
        Condition condition = new Condition(DishDO.class);
        Example.Criteria criteria = condition.createCriteria();
        if (StringUtil.isNotEmpty(name)) {
            criteria.andLike("name", "%" + name + "%");
        }
        if (priceStart != null) {
            criteria.andGreaterThanOrEqualTo("price", priceStart);
        }
        if (priceEnd != null) {
            criteria.andLessThanOrEqualTo("price", priceEnd);
        }
        if (classId != null) {
            criteria.andEqualTo("classId", classId);
        }
        condition.setOrderByClause("id desc");

        PageHelper.startPage(page, limit);
        List<DishDO> result = dishMapper.selectByCondition(condition);
        int count = dishMapper.selectCountByCondition(condition);
        return Result.page(result, page, limit, count);
    }

    @GetMapping("/delete")
    public Result<String> delete(
            @RequestParam Integer id
    ) {
        dishMapper.deleteByPrimaryKey(id);
        return Result.success();
    }

    @PostMapping("/update")
    public Result<String> update(
            @RequestBody DishDO dishDO
    ) {
        dishDO.init();
        dishMapper.updateByPrimaryKey(dishDO);
        return Result.success();
    }

    @PostMapping("/create")
    public Result<String> create(
            @RequestBody DishDO dishDO
    ) {
        dishDO.init();
        dishMapper.insert(dishDO);
        return Result.success();
    }

}
