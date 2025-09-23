package vn.m2m.iot.dao;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import vn.m2m.common.AbstractDAO;
import vn.m2m.config.HazelcastConfig;
import vn.m2m.config.MongoConfig;
import vn.m2m.iot.models.GroupProduct;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vtk-anhlt166 on 8/4/22.
 */
@Singleton
public class GroupProductDAO extends AbstractDAO<String, GroupProduct> {
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

    public GroupProductDAO(){
        super(String.class, GroupProduct.class);

    }

    public List<GroupProduct> getAllGroupProduct() {
        List<GroupProduct> groupProductList = new ArrayList<>();
        try {
            Query query = new Query();
            query.with(new Sort(Sort.Direction.ASC, "name"));
            groupProductList = (List)mongoTempl().find(query, GroupProduct.class, collectionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return groupProductList;
    }

    public List<GroupProduct> getAllGroupSolution() {
        List<GroupProduct> groupProductList = new ArrayList<>();
        try {
            Query query = new Query(Criteria.where("type").is(GroupProduct.Types.solution.getCode()).and("status").is(true));
            query.with(new Sort(Sort.Direction.ASC, "name"));
            groupProductList = (List)mongoTempl().find(query, GroupProduct.class, collectionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return groupProductList;
    }

    public List<GroupProduct> getAllGroupDevice() {
        List<GroupProduct> groupProductList = new ArrayList<>();
        try {
            Query query = new Query(Criteria.where("type").is(GroupProduct.Types.device.getCode()).and("status").is(true));
            query.with(new Sort(Sort.Direction.ASC, "name"));
            groupProductList = (List)mongoTempl().find(query, GroupProduct.class, collectionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return groupProductList;
    }
}
