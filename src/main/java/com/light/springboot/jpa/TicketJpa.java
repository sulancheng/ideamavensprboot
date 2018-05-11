package com.light.springboot.jpa;

import com.light.springboot.entity.Ticket;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Administrator
 * on 2018/5/11.
 */

public  interface TicketJpa extends BaseRepository<Ticket, Integer> , JpaSpecificationExecutor<Ticket> {

}
