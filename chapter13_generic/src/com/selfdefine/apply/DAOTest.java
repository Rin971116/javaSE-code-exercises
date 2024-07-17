package com.selfdefine.apply;

import org.junit.Test;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/5/26 上午 04:29
 * @Version 1.0
 */
public class DAOTest {
    @Test
    public void test1(){
        CustomerDAO customerDAO = new CustomerDAO();
//        customerDAO.add(); 參數被限定只能傳入Customer了

        OrderDAO orderDAO = new OrderDAO();
//        orderDAO.add(); 參數被限定只能傳入Order了
    }
}
