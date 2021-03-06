package com.wisely.ch8_5.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.wisely.ch8_5.dao.PersonRepository;
import com.wisely.ch8_5.domain.Person;
import com.wisely.ch8_5.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {
	
	@Autowired
	PersonRepository personRepository;

	@CachePut(value="people",key="#person.id")	//1、@CachePut缓存新增的或更新的数据到缓存，其中缓存名称为people，数据的key的person的id
	public Person save(Person person) {
		Person p = personRepository.save(person);
		System.out.println("为id、key为：" + p.getId() + "数据做了缓存");
		return p;
	}

	
	@CacheEvict(value="people")	//2、@CacheEvict从缓存people中删除key为id的数据
	public void remove(Long id) {
		System.out.println("删除了id、key为：" + id + "的数据缓存");
		personRepository.delete(id);
	}

	@Cacheable(value="people",key="#person.id")	//3、@Cacheable缓存key作为person的id数据到缓存people中，如果没有指定key，则方法参数作为key保存到缓存中
	public Person findOne(Person person) {
		Person p = personRepository.findOne(person.getId());
		System.out.println("为id、key为：" + p.getId() + "数据做了缓存");
		return p;
	}

}
