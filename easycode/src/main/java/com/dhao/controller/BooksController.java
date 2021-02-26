package com.dhao.controller;

import com.dhao.entity.Books;
import com.dhao.service.BooksService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Books)表控制层
 *
 * @author makejava
 * @since 2021-01-31 09:54:31
 */
@RestController
@RequestMapping("/books")
public class BooksController {
    /**
     * 服务对象
     */
    @Resource
    private BooksService booksService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public Books selectOne(Integer id) {
        return this.booksService.queryById(id);
    }

}