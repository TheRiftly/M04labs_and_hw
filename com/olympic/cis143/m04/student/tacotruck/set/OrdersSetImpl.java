package com.olympic.cis143.m04.student.tacotruck.set;

import java.util.LinkedHashSet;
import java.util.Set;

import com.olympic.cis143.m04.student.tacotruck.Orders;
import com.olympic.cis143.m04.student.tacotruck.TacoImpl;
//Michael Specll Cis 143 M04 labs
public class OrdersSetImpl  implements Orders {
	Set<TacoImpl> set = new LinkedHashSet<TacoImpl>();
	
	
    @Override
    public void addOrder(TacoImpl tacoOrder) {

    	if(tacoOrder != null) {
    	set.add(tacoOrder);
    	}
    	
    }

    @Override
    public boolean hasNext() {
    	return !this.set.isEmpty();
    }

    @Override
    public TacoImpl closeNextOrder() {
  
    	TacoImpl t = set.iterator().next();
    	set.remove(t);
    	return t;
    
    }

    @Override
    public int howManyOrders() {
        return set.size();
    }
}
