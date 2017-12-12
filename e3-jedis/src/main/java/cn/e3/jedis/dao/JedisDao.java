package cn.e3.jedis.dao;

public interface JedisDao {
	
	//抽取jedis常用命令
	
	//String
	public String set(String key,String value);
	public String get(String key);
	//自增
	public Long incr(String key);
	//自减
	public Long decr(String key);
	//hash
	//设置值
	public Long hset(String key,String field,String value);
	//获取值
	public String hget(String key,String field);
	//删除
	public Long hdel(String key,String field);
	
	//过期时间方法
	public Long expire(String key,int seconds);
	
	//查询过期时间剩余时间
	public Long ttl(String key);
	
	

}
