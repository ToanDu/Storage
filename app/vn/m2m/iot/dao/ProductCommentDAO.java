package vn.m2m.iot.dao;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import vn.m2m.common.AbstractDAO;
import vn.m2m.config.HazelcastConfig;
import vn.m2m.config.MongoConfig;
import vn.m2m.iot.models.ProductComment;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vtk-anhlt166 on 8/16/22.
 */
@Singleton
public class ProductCommentDAO extends AbstractDAO<String, ProductComment> {
    @Inject
    public MongoConfig mongoConfig;

    @Inject
    private HazelcastConfig hazelcastConfig;


    protected MongoTemplate mongoTempl() throws Exception {
        return mongoConfig.getMongoTemplate();
    }

    protected HazelcastInstance hazelcastInstance(){
        return hazelcastConfig.getHazelcastInstance();
    }

    public ProductCommentDAO(){
        super(String.class, ProductComment.class);
    }

    public List<ProductComment> getCommentByProductId(String productId) {
        List<ProductComment> productCommentList = new ArrayList<>();
        try {
            Query query = new Query(Criteria.where("productId").is(productId));
            productCommentList = (List)mongoTempl().find(query, ProductComment.class, collectionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productCommentList;
    }
}
