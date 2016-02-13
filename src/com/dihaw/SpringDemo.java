package com.dihaw;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/dihaw/spring.xml");
		Employee employee = (Employee) context.getBean("employee");

		// calling getEmployee method first time.
		System.out.println(employee.getEmployee(1));

		// calling getEmployee method second time. This time, method will not
		// execute.
		System.out.println(employee.getEmployee(1));

		// calling getEmployee method third time with different value.
		System.out.println(employee.getEmployee(2));
		
		
        
        /** reload the cache **/
        CacheManager cacheManager = (CacheManager) context.getBean("cacheManager");
        List<String> caches = new ArrayList(cacheManager.getCacheNames().size());
        Collection<String> cacheNames = cacheManager.getCacheNames();

		for(String cacheName: cacheNames){
			System.out.println("------------------------------cacheName: "+cacheName);
			cacheManager.getCache(cacheName).clear();
			caches.add(cacheName);
		}
		
	}

}
