package com.imooc.dao.cache;

import com.imooc.BaseTest;
import com.imooc.dao.SeckillDao;
import com.imooc.entity.Seckill;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisDaoTest extends BaseTest {

	private long id = 1001;

	@Autowired
	private RedisDao redisDao;

	@Autowired
	private SeckillDao seckillDao;

	@Test
	public void testGetSeckill() throws Exception {
		// get and put
		Seckill seckill = redisDao.getSeckill(id);
		if (seckill == null) {
			seckill = seckillDao.queryById(id);
			if (seckill != null) {
				String result = redisDao.putSeckill(seckill);
				System.out.println(result);
				seckill = redisDao.getSeckill(id);
				System.out.println(seckill);
			}
		}
	}

	@Test
	public void testPutSeckill() throws Exception {

	}

}
