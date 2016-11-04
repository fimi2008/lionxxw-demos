package com.lionxxw.sorljpro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import com.lionxxw.utils.DBUtil;

/**		
 * <p>Title: SolrCloudTest </p>
 * <p>Description: 类描述:使用SolrJ管理solr集群</p>
 * <p>Copyright (c) 2015 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author xiang_wang	
 * @date 2016年1月19日下午6:02:04
 * @version 1.0
 * <p>修改人：</p>
 * <p>修改时间：</p>
 * <p>修改备注：</p>
 */
public class SolrCloudTest {
	private static final String ZK_HOST = "127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183";
	private static final String DEFAULT_COLLECTION = "collection2";
	
	@Test
	public void addDoc() throws Exception{
		// 1.使用SorlJ连接集群.参数:zkHost是一个zookeeper集群列表
		CloudSolrServer solrServer = new CloudSolrServer(ZK_HOST);
		// 设置默认的collection
		solrServer.setDefaultCollection(DEFAULT_COLLECTION);
		// 2.创建一文档对象
		SolrInputDocument doc = new SolrInputDocument();
		// 3.向文档对象中添加域
		doc.addField("id", "test001");
		doc.addField("title", "test001+++++");
		// 提交文档到索引库
		solrServer.add(doc);
		// 提交修改
		solrServer.commit();
	}
	
	@Test
	public void delDoc() throws Exception{
		// 1.使用SorlJ连接集群.参数:zkHost是一个zookeeper集群列表
		CloudSolrServer solrServer = new CloudSolrServer(ZK_HOST);
		//	设置默认的collection
		solrServer.setDefaultCollection(DEFAULT_COLLECTION);
		// 根据id删除
		solrServer.deleteById("test001");
		// 根据查询删除
		// solrServer.deleteByQuery("*:*");
		solrServer.commit();
	}
	
	@Test
	public void importData() throws Exception{
		CloudSolrServer solrServer = new CloudSolrServer(ZK_HOST);
		//	设置默认的collection
		solrServer.setDefaultCollection(DEFAULT_COLLECTION);
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