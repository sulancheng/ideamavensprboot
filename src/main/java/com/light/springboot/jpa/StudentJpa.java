package com.light.springboot.jpa;

import com.light.springboot.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Transactional事务使用总结：
 *
 * 1、异常在A方法内抛出，则A方法就得加注解
 * 2、多个方法嵌套调用，如果都有 @Transactional 注解，则产生事务传递，默认 Propagation.REQUIRED
 * 3、如果注解上只写 @Transactional  默认只对 RuntimeException 回滚，而非 Exception 进行回滚
 * 如果要对 checked Exceptions 进行回滚，则需要 @Transactional(rollbackFor = Exception.class)
 *
 * org.springframework.orm.jpa.JpaTransactionManager
 *
 * org.springframework.jdbc.datasource.DataSourceTransactionManager
 *
 * org.springframework.transaction.jta.JtaTransactionManager
 *
 */

//实现JpaSpecificationExecutor接口实现复杂查询
public interface StudentJpa extends BaseRepository<Student, Integer> , JpaSpecificationExecutor<Student> {
	@Modifying
	@Query(value="select * from student where age>=?",nativeQuery=true)
	public List<Student> myQuery(Integer age);
	
	
	
	@Modifying
	@Transactional
	@Query(value="select * from student where id=?",nativeQuery=true)
	public List<Student> myQueryzong(Integer id);



	
	@Modifying
	@Transactional//事务
	@Query(value="delete  from student where age=?",nativeQuery=true)
	public int deleteQuery(Integer age);

	@Modifying
	@Transactional//事务 UPDATE 或 DELETE 操作需要使用事务，此时需要定义 Service 层，在 Service 层的方法上添加事务操作；
	@Query(value="update student set name=? where id=?",nativeQuery=true)
	public int updataQuery(String name,Integer id);
	/**
	 * 查询name
	 * @param name
	 * @return
	 */
	List<Student> findByname(String name);
	List<Student> findByMyclass(String myclass);

	/**
	 * 查询所有的数据并排序
	 * @return
	 */
	List<Student> findByOrderByMyclassAsc();

    /**
     * 分页查询id不是传入id的用户
     * @param id
     * @param pageable
     * @return
     */
    Page<Student> findByIdNot(Long id,Pageable pageable);

	/**
	 * 分页查询name是传入userName的用户
	 * @param name
	 * @param pageable
	 * @return
	 */
	Page<Student> findByName(String name,Pageable pageable);

	//Page<Student> findAll(Pageable pageable);
	//Student findTopByOrderByAgeDesc();

	/**
	 * 找name  并按照id排序
	 * @param name
	 * @return
	 */
	List<Student> findByNameOrderByIdDesc(String name);
}
