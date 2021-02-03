package com.dhao.dao;

import com.dhao.entity.Books;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Books)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-31 09:54:29
 */
@Mapper
public interface BooksDao {

    /**
     * 通过ID查询单条数据
     *
     * @param bookid 主键
     * @return 实例对象
     */
    Books queryById(Integer bookid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Books> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param books 实例对象
     * @return 对象列表
     */
    List<Books> queryAll(Books books);

    /**
     * 新增数据
     *
     * @param books 实例对象
     * @return 影响行数
     */
    int insert(Books books);

    /**
     * 修改数据
     *
     * @param books 实例对象
     * @return 影响行数
     */
    int update(Books books);

    /**
     * 通过主键删除数据
     *
     * @param bookid 主键
     * @return 影响行数
     */
    int deleteById(Integer bookid);

}