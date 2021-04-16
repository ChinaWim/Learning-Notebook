package 项目;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import 项目.pojo.TbItem;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-12-20 下午7:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-solr.xml")
public class SolrDemo {

    @Autowired
    private SolrTemplate solrTemplate;


    @Test
    public void save() {
        //sku
        TbItem item = new TbItem();
        item.setId(1L);
        item.setBrand("苹果");
        item.setCategory("手机");
        //spu
        item.setGoodsId(1L);
        item.setSeller("苹果1号专卖店");
        item.setTitle("苹果iPhoneX");
        item.setPrice(new BigDecimal(8000));
        solrTemplate.saveBean(item);
        solrTemplate.commit();

    }

    /**
     * 按主键查询
     */
    @Test
    public void selectPrimaryKey() {
        TbItem item = solrTemplate.getById(1L, TbItem.class);
        System.out.println(item);

    }

    /**
     * 按主键删除
     */
    @Test
    public void del() {
        solrTemplate.deleteById("1");
        solrTemplate.commit();
    }

    /**
     * 批量删除
     */
//    @Test
//    public void delBatch() {
//        var list = new ArrayList<String>();
//        for (int i = 1; i <= 100; i++) {
//            list.add(i + "");
//        }
//        solrTemplate.deleteById(list);
//        solrTemplate.commit();
//    }

    /**
     * 按条件删除全部
     */
    @Test
    public void delAll() {
        Query query = new SimpleQuery("*:*");
        solrTemplate.delete(query);
        solrTemplate.commit();
    }


    /**
     * 批量插入
     */
    @Test
    public void addBatch() {

      /*  这个是个错误的插入操作
        for (int i = 0; i < 100; i++) {
            //sku
            TbItem item = new TbItem();
            item.setId(i + 1L);
            item.setBrand("苹果" + i);
            item.setCategory("手机");
            //spu
            item.setGoodsId(i + 1L);
            item.setSeller("苹果1号专卖店");
            item.setTitle("苹果iPhoneX");
            item.setPrice(new BigDecimal(8000));
            solrTemplate.saveBean(item);
        }
        solrTemplate.commit();
      */
        List list = new ArrayList();
        for (int i = 0; i < 100; i++) {
            //sku
            TbItem item = new TbItem();
            item.setId(i + 1L);
            item.setBrand("苹果");
            item.setCategory("手机");
            //spu
            item.setGoodsId(i + 1L);
            item.setSeller("苹果1号专卖店");
            item.setTitle("苹果iPhone" + i);
            item.setPrice(new BigDecimal(8000));
            list.add(item);
        }
        solrTemplate.saveBeans(list);
        solrTemplate.commit();
    }

    /**
     * 分页查询
     */

    @Test
    public void selectByPage() {
        Query query = new SimpleQuery("*:*");
        //设置开始位置 默认0
        query.setOffset(10);
        //设置每页row 默认10
        query.setRows(11);
        ScoredPage<TbItem> tbItems = solrTemplate.queryForPage(query, TbItem.class);


        //每页显示多少条
        System.out.println("每页显示多少条:" + tbItems.getSize());
        //总页数
        System.out.println("总页数:" + tbItems.getTotalPages());
        //总记录数
        System.out.println("总记录数:" + tbItems.getTotalElements());

        tbItems.getContent().stream().forEach(x -> {
            System.out.println("title: " + x.getTitle());
            System.out.println("brand: " + x.getBrand());
        });
    }

    /**
     * 条件查询
     */
    @Test
    public void selectByCondition() {
        Query query = new SimpleQuery("*:*");
        //不设置初始位置　tbItems.getSize()得到的每页显示Row是0，todo?
        query.setOffset(0);
        query.setRows(10);
        Criteria criteria = new Criteria("item_title").contains("2");
//        criteria = criteria.and("item_title").contains("5");
        query.addCriteria(criteria);

        ScoredPage<TbItem> tbItems = solrTemplate.queryForPage(query, TbItem.class);
        //每页显示多少条
        System.out.println("每页显示多少条:" + tbItems.getSize());
        //总页数
        System.out.println("总页数:" + tbItems.getTotalPages());
        //总记录数
        System.out.println("总记录数:" + tbItems.getTotalElements());

        tbItems.getContent().stream().forEach(x -> {
            System.out.println("title: " + x.getTitle());
            System.out.println("brand: " + x.getBrand());
        });
    }


}
