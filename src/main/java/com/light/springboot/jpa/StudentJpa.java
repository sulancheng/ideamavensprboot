package com.light.springboot.jpa;

import com.light.springboot.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
	@Transactional
	@Query(value="delete  from student where age=?",nativeQuery=true)
	public int deleteQuery(Integer age);

	/**
	 * 查询name
	 * @param name
	 * @return
	 */
	List<Student> findByname(String name);
	List<Student> findByMyclass(String myclass);

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


	//Student findTopByOrderByAgeDesc();

	/**
	 * 找name  并按照id排序
	 * @param name
	 * @return
	 */
	List<Student> findByNameOrderByIdDesc(String name);
}
