package kr.co.jhta.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {

	/*
	 * mybatis의 주요 API
	 * 		-SqlSession
	 * 			매퍼파일에 정의된 SQL문을 실행하는 객체다.
	 * 			insert(String id)
	 * 			insert(String id, Object parameter)
	 * 			update(String id)
	 * 			update(String id, Object parameter)
	 * 			delete(String id)
	 * 			delete(String id, Object parameter)
	 * 			selectOne(String id)
	 * 			selectOne(String id, Object parameter)
	 */
	private static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			String resource = "mybatis/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * SqlSessionFactory 객체를 반환한다.
	 * @return SqlSessionFactory 객체
	 */
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
	/**
	 * SQL 구문을 실행하는 SqlSession 객체를 반환한다.
	 * @return SqlSession 객체(INSERT/UPDATE/DELETE/SELECT, 트랜잭션 기능 제공)
	 */
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
}
