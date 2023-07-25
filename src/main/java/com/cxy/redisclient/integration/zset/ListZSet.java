package com.cxy.redisclient.integration.zset;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.resps.Tuple;

import com.cxy.redisclient.domain.RedisVersion;
import com.cxy.redisclient.integration.JedisCommand;

public class ListZSet extends JedisCommand {
	public List<Tuple> getValues() {
		return values;
	}

	private int db;
	private String key;
	private List<Tuple> values;
	
	public ListZSet(int id, int db, String key) {
		super(id);
		this.db = db;
		this.key = key;
	}

	@Override
	protected void command() {
		jedis.select(db);
		values = jedis.zrangeWithScores(key, 0, -1);
	}

	@Override
	public RedisVersion getSupportVersion() {
		return RedisVersion.REDIS_1_2;
	}

}
