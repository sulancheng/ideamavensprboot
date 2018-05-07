package com.light.springboot.jpa;

import bean.Result;
import com.light.springboot.entity.Student;
import com.light.springboot.enums.ResultEnum;
import com.light.springboot.exception.MyException;
import com.light.springboot.utils.ResultUtils;
import org.slf4j.Logger;
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
public class UserServiceImpl implements UserService {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private StudentJpa studentJpa;
    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
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
        String sql = "from " + tablename + " u WHERE u." + filed + "=" + o;
        logger.info(sql + "--------page--sql语句-------------");
        List<T> list = new ArrayList<>();
        try {
            Query query = entityManager.createQuery(sql);
            //query.setParameter(1,o);
            query.setFirstResult((start - 1) * pageNumer);
            query.setMaxResults(pageNumer);
            list = query.getResultList();
            logger.info("取出的长度" + list.size());
            entityManager.close();
        } catch (Exception e) {
            logger.error("------------分页错误---------------");
        }
        return list;
    }

    @Override
    @SuppressWarnings("unused")//成功
    public List<DbResponeBean> mQuerylianhcx() {
        Query createNativeQuery = entityManager
                .createNativeQuery("SELECT b.message ,b.class,s.name,a.guo,a.sheng FROM banji b,student s ,address a " +
                        "WHERE a.bid = b.id and a.sid = s.id");
        List resultList = createNativeQuery.getResultList();
        if (resultList.size() <= 0) {
            return null;
        }
        ArrayList<DbResponeBean> dbResponeBeans = new ArrayList<>();
        for (int i = 0; i < resultList.size(); i++) {
            Object[] cells = (Object[]) resultList.get(i);
            logger.info(" message = " + cells[0] + " class = " + cells[1] + " name = " + cells[2] + " guo = " + cells[3] + "  sheng=" + cells[4]);
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

    @Transactional(rollbackFor = Exception.class)//事务与回滚  成功  默认只有runtimeexception才会进行事务回滚
    @Override
    public Result addBean(Object o) throws Exception {
//        updataById("我的测试",32);//测试看会不会回滚 成功
        Student student = (Student) o;
        if (student.getName().equals("23")) {
//            throw new MyException(ResultEnum.ERROR);
            return ResultUtils.erro("保存失败，名字重复");
        }
        studentJpa.save(student);
        return ResultUtils.erro("保存成功！");
    }

    @Override
    public List<Student> findAll() {
       return studentJpa.findByOrderByMyclassAsc();
    }


    @Transactional(rollbackFor = Exception.class)//事务与回滚  成功  默认只有runtimeexception才会进行事务回滚
    public Object updataById(String name, Integer id) throws Exception {
//        int shiwu =  studentJpa.updataQuery(name, id);
//        if (true)
//            throw  new RuntimeException("模拟异常触发回滚");
//        return  ResultUtils.sucess((shiwu >= 1 ? true : false) + "");
        //上面的的情况未用try catch捕获 设置rollbackFor，在该异常等级下会进行事务回滚，会自动在异常时候进行捕获
        //下面的使用try catch，使用之后属于自定义捕获，rollbackFor会失效，事务不进行回滚需要手动回滚。
//        int shiwu = 0;
//        try {
//            shiwu = studentJpa.updataQuery(name, id);
////        if (true)
////            throw  new RuntimeException("模拟异常触发回滚");
//        } catch (Exception e) {
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚
//            return ResultUtils.erro("回滚成功，保存失败");
//        }
//        return ResultUtils.sucess((shiwu >= 1 ? true : false) + "");
        //第三，是将异常往上面抛出，在handle中统一进行收集。
        int shiwu = studentJpa.updataQuery(name, id);
        if (shiwu <= 1)
            throw new MyException(ResultEnum.ERROR);
        return ResultUtils.sucess((shiwu >= 1 ? true : false) + " 受影响的行：" + shiwu);

        //第四，Exception参数只能传递msg，所以我们只能自定义异常 如MyException
    }

    @Transactional(rollbackFor = Exception.class)//事务与回滚  成功
    public boolean inssrtList(List<Student> list) {
        List<Student> students = studentJpa.saveAll(list);
        if (students.size() >= 1) {
            return true;
        } else {
            return false;
        }
    }
}
