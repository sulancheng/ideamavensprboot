package com.light.springboot.jpa;

import bean.Result;
import com.light.springboot.entity.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator
 * on 2018/5/11.
 */
@Service
public class TicketServiceImpl implements BeanService {
    private final static Logger logger = LoggerFactory.getLogger(TicketServiceImpl.class);
    @Autowired
    private TicketJpa ticketJpa;
    @Override
    public void testQuery() {

    }

    @Override
    public List<DbResponeBean> mQuerylianhcx() {
        return null;
    }

    @Override
    public Result addBean(Object o) throws Exception {
        return null;
    }

    @Override
    public List<Ticket> findAll() {
        List<Ticket> all = ticketJpa.findAll();
        logger.info("ticket="+all.size()+"   "+all.toString());
        return all;
    }
    public void saveOne(Ticket ticket){
        ticketJpa.save(ticket);
    }
}
