package com.light.springboot.jpa;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
@Service//dao层使用@repository注解
public class UserService  {
    @PersistenceContext
    private EntityManager entityManager;
	@Autowired
	private StudentJpa studentJpa;
	private final static Logger logger = (Logger) LoggerFactory.getLogger(UserService.class);
	
	@SuppressWarnings("unused")
	public void testQuery() {
		Query createNativeQuery = entityManager
				.createNativeQuery("select *,ifnull(id,0)+ifnull(class,0) as sumid from student where id < 10");
//		List<Student> resultLists = createNativeQuery.getResultList();
//		logger.info("自定义数据的取出"+resultLists.toString());
		List resultList = createNativeQuery.getResultList();
		for (int i = 0; i < resultList.size(); i++) {
			Object[] cells = (Object[]) resultList.get(i);
			System.out.println("id = " + cells[0]);
			System.out.println("name = " + cells[1]);
			System.out.println("age = " + cells[2]);
			System.out.println("class = " + cells[3]);
			System.out.println("classandid = " + cells[4]);
		}
		entityManager.close();

	}
	@Transactional//失败
	public <T> List<T> findpages(String tablename, String filed, Object o, int start, int pageNumer) {
		String sql="from "+tablename+" u WHERE u."+filed+"="+o;
		logger.info(sql+"--------page--sql语句-------------");
		List<T> list=new ArrayList<>();
		try {
			Query query=entityManager.createQuery(sql);
			//query.setParameter(1,o);
			query.setFirstResult((start-1)*pageNumer);
			query.setMaxResults(pageNumer);
			list= query.getResultList();
			logger.info("取出的长度"+list.size());
			entityManager.close();
		}catch (Exception e){
			logger.error("------------分页错误---------------");
		}
		return list;
	}
	@SuppressWarnings("unused")//成功
	public ArrayList<DbResponeBean> mQuerylianhcx() {
		Query createNativeQuery = entityManager
				.createNativeQuery("SELECT b.message ,b.class,s.name,a.guo,a.sheng FROM banji b,student s ,address a " +
						"WHERE a.bid = b.id and a.sid = s.id");
		List resultList = createNativeQuery.getResultList();
		if (resultList.size()<=0){
			return null;
		}
		ArrayList<DbResponeBean> dbResponeBeans = new ArrayList<>();
		for (int i = 0; i < resultList.size(); i++) {
			Object[] cells = (Object[]) resultList.get(i);
			logger.info(" message = " + cells[0]+" class = " + cells[1]+" name = " + cells[2]+ " guo = " + cells[3]+"  sheng="+cells[4]);
			DbResponeBean dbResponeBean = new DbResponeBean();
			dbResponeBean.setMessage(cells[0]);
			dbResponeBean.setMyclass(cells[1]);
			dbResponeBean.setName(cells[2]);
			dbResponeBean.setGuo(cells[3]);
			dbResponeBean.setSheng(cells[4]);
			dbResponeBeans.add(dbResponeBean);
		}
		entityManager.close();
		return dbResponeBeans;
	}
}
