package it.pkg.impl;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import it.pkg.server.basic;

public class basicstruct implements basic{
	public void function() {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName());
	}
	@Cacheable(value={"Cache"})
	public String read(String key) {
		// TODO Auto-generated method stub
		return key;
	}
	@CacheEvict(value = { "Cache"}, allEntries = true) 
	public int updata(String key) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
