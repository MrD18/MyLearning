package com.dhao.service.impl;

import com.dhao.entity.Books;
import com.dhao.dao.BooksDao;
import com.dhao.service.BooksService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Books)表服务实现类
 *
 * @author makejava
 * @since 2021-01-31 09:54:30
 */
@Service("booksService")
public class BooksServiceImpl implements BooksService {
    @Resource
    private BooksDao booksDao;

    /**
     * 通过ID查询单条数据
     *
     * @param bookid 主键
     * @return 实例对象
     */
    @Override
    public Books queryById(Integer bookid) {
        return this.booksDao.queryById(bookid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Books> queryAllByLimit(int offset, int limit) {
        return this.booksDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param books 实例对象
     * @return 实例对象
     */
    @Override
    public Books insert(Books books) {
        this.booksDao.insert(books);
        return books;
    }

    /**
     * 修改数据
     *
     * @param books 实例对象
     * @return 实例对象
     */
    @Override
    public Books update(Books books) {
        this.booksDao.update(books);
        return this.queryById(books.getBookid());
    }

    /**
     * 通过主键删除数据
     *
     * @param bookid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer bookid) {
        return this.booksDao.deleteById(bookid) > 0;
    }
}