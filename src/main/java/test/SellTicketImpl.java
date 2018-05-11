package test;

import com.light.springboot.entity.Ticket;
import com.light.springboot.jpa.TicketServiceImpl;

/**
 * Created by Administrator
 * on 2018/5/11.
 */
public class SellTicketImpl implements Runnable {
    TicketServiceImpl ticketService = new TicketServiceImpl();

//    int tickets = ticketService.findAll().get(0); //共享数据
    int index = 0;

    @Override
    public void run() {
        while (true) {

            if (index % 2 == 0) {
                synchronized (SellTicketImpl.class) {//this.getClass()
                    Ticket ticket = ticketService.findAll().get(0);
                    Integer tkcountone = ticket.getTkcount();
                    if (tkcountone > 0) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "正在卖第" + tkcountone + "张票");
                        tkcountone--;
                        ticket.setTkcount(tkcountone);
                        ticketService.saveOne(ticket);
                    }
                }
            } else {
                //sell_Static(); //同步静态方法的锁是 对象的字节码对象
                sell(); //锁是this
            }
            index++;


        }
    }

//    public static synchronized void sell_Static() {
//        if (tickets > 0) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "正在卖第" + tickets + "张票");
//            tickets--;
//        }
//    }

    public synchronized void sell() {
        Ticket ticket = ticketService.findAll().get(0);
        Integer tkcountone = ticket.getTkcount();
        if (tkcountone > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在卖第" + tkcountone + "张票");
            tkcountone--;
            ticket.setTkcount(tkcountone);
            ticketService.saveOne(ticket);
        }
    }

}