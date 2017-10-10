package com.macquarium.ong;

import com.macquarium.ong.vo.Customer;

public interface SignUpDaoService {

    public boolean insertCustomer(Customer customer);
    public boolean updateCustomer(Customer customer);
    public boolean isExistingCustomer(Customer customer);


}
