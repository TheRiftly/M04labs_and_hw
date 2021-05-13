package com.olympic.cis143.m04.student.homework.tacotruckmap.impl;

import com.olympic.cis143.m04.student.homework.tacotruckmap.OrderDoesNotExistException;
import com.olympic.cis143.m04.student.homework.tacotruckmap.Orders;
import com.olympic.cis143.m04.student.homework.tacotruckmap.TacoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
//Michael Specll Cis 143 M04 homework
public class OrdersMapImpl implements Orders {
	HashMap<String, List<TacoImpl>> map = new HashMap<String,List<TacoImpl>>();
    @Override
    public void createOrder(final String orderid) {
    	if(orderid != null) {
    		ArrayList<TacoImpl> tacos = new ArrayList<TacoImpl>();
    		map.put(orderid, tacos);
    	}
    }

    @Override
    public void addTacoToOrder(final String orderid, final TacoImpl taco) throws OrderDoesNotExistException {
    	List<TacoImpl> tacos = getListOfOrders(orderid);
    	tacos.add(taco);
    }

    @Override
    public boolean hasNext() {
    	return !map.isEmpty();
    }

    @Override
    public List<TacoImpl> closeOrder(final String orderid) throws OrderDoesNotExistException {
    	List<TacoImpl> tacos = getListOfOrders(orderid);
    	map.remove(orderid);
        return tacos;
    }

    @Override
    public int howManyOrders() {
        return map.size();
    }

    @Override
    public List<TacoImpl> getListOfOrders(final String orderid) throws OrderDoesNotExistException {
    	if(map.containsKey(orderid)) { 
    		return map.get(orderid);
    		
    	}
    	throw  new OrderDoesNotExistException("Order Does Not Exist");
    }
}
