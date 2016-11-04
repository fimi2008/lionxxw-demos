package com.lionxxw.sorljpro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import com.lionxxw.utils.DBUtil;

public class SorlJTest {
	
	private static final String BASE_URL = "http://localhost:8080/solr";
	
	@Test
	public void addDoc() throws Exception{
		// 1.创建一个连接solr服务的客户端对象SolrServer对象.
		SolrServer solrServer = new HttpSolrServer(BASE_URL);
		// 2.创建一文档对象
		SolrInputDocument doc = new SolrInputDocument();
		// 3.向文档对象中添加域
		doc.addField("id", "test001");
		doc.addField("title", "test001+++++");
		// 提交文档到索引库
		solrServer.add(doc);
		solrServer.commit();
	}
	
	@Test
	public void delDoc() throws Exception{
		// 1.创建一个连接solr服务的客户端对象SolrServer对象.
		SolrServer solrServer = new HttpSolrServer(BASE_URL);
		// 根据id删除
		solrServer.deleteById("test001");
		// 根据查询删除
		// solrServer.deleteByQuery("*:*");
		solrServer.commit();
	}
	
	@Test
	public void importData() throws Exception{
		SolrServer solrServer = new HttpSolrServer(BASE_URL);
		Connection conn = DBUtil.getConnection();
		String sql = "select * from products";
		PreparedStatement prep = conn.prepareStatement(sql);
		ResultSet rs = prep.executeQuery();
		int count = 0;
		// 向solr中导入数据
		while (rs.next()){
			SolrInputDocument doc = new SolrInputDocument();
			doc.addField("id", rs.getString("pid"));
			doc.addField("name", rs.getString("name"));
			doc.addField("category", rs.getString("catalog_name"));
			doc.addField("price", rs.getString("price"));
			doc.addField("content", rs.getString("description"));
			doc.addField("url", rs.getString("picture"));
			
			// 向solr中添加记录
			solrServer.add(doc);
			count++;
			System.out.println("已成功加入"+count+"条");
		}
		// 提交修改
		solrServer.commit();
		System.out.println("数据导入完成~");
	}
}