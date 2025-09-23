package vn.m2m.iot.dao;

import com.hazelcast.core.HazelcastInstance;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import vn.m2m.common.AbstractDAO;
import vn.m2m.config.HazelcastConfig;
import vn.m2m.config.MongoConfig;
import vn.m2m.iot.models.GroupProduct;
import vn.m2m.iot.models.Product;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by vtk-anhlt166 on 8/4/22.
 */
@Singleton
public class ProductDAO extends AbstractDAO<String, Product> {
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

    public ProductDAO(){
        super(String.class, Product.class);
    }

    public List<Product> getProductByUser(String userId, String filterKey, String sortKey) {
        List<Product> productList = new ArrayList<>();
        try {
            Query query = new Query(Criteria.where("userId").is(userId));
            if(filterKey.equals("ASC")){
                query.with(new Sort(Sort.Direction.ASC, sortKey));
            } else {
                query.with(new Sort(Sort.Direction.DESC, sortKey));
            }
            productList = (List)mongoTempl().find(query, Product.class, collectionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    public List<Product> getAllProductMarket(String filterKey, String sortKey, List<String> groupProduct) {
        List<Product> productList = new ArrayList<>();
        try {
            Query query = new Query();
            Criteria queryStatus =  Criteria.where("statusShow").is(true).and("statusGroup").is(true).and("statusApprove").is(1);
            query.addCriteria(queryStatus);

            if(groupProduct.size() > 0){
                List<Criteria> criterias = new ArrayList<Criteria>();
                for(String groupId: groupProduct){
//                    Criteria queryGroupId =  Criteria.where("groupId").is(groupId);
                    Criteria queryGroupId =  Criteria.where("groupId").regex(groupId,"i");
                    criterias.add(queryGroupId);
                }

                Criteria criteria = new Criteria().orOperator(criterias.toArray(new Criteria[criterias.size()]));
                query.addCriteria(criteria);
            }

            if(filterKey.equals("ASC")){
                query.with(new Sort(Sort.Direction.ASC, sortKey));
            } else {
                query.with(new Sort(Sort.Direction.DESC, sortKey));
            }

            productList = (List)mongoTempl().find(query, Product.class, collectionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    public List<Product> getProductMarket(String filterKey, String sortKey, List<String> groupProduct, int groupType, String nameSearch) {
        List<Product> productList = new ArrayList<>();
        try {
            Query query = new Query();
            Criteria queryStatus =  Criteria.where("statusShow").is(true).and("statusGroup").is(true).and("statusApprove").is(1).and("groupType").is(groupType);
            query.addCriteria(queryStatus);
            Criteria queryName = Criteria.where("name").regex(Pattern.compile(nameSearch, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE));
            query.addCriteria(queryName);

            if(groupProduct.size() > 0){
                List<Criteria> criterias = new ArrayList<Criteria>();
                for(String groupId: groupProduct){
//                    Criteria queryGroupId =  Criteria.where("groupId").is(groupId);
                    Criteria queryGroupId =  Criteria.where("groupId").regex(groupId,"i");
                    criterias.add(queryGroupId);
                }

                Criteria criteria = new Criteria().orOperator(criterias.toArray(new Criteria[criterias.size()]));
                query.addCriteria(criteria);
            }

            if(filterKey.equals("ASC")){
                query.with(new Sort(Sort.Direction.ASC, sortKey));
            } else {
                query.with(new Sort(Sort.Direction.DESC, sortKey));
            }

            productList = (List)mongoTempl().find(query, Product.class, collectionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    public List<Product> getAllSolution(int limit, String name) {
        List<Product> productList = new ArrayList<>();
        try {
            Query query = new Query(Criteria.where("groupType").is(GroupProduct.Types.solution.getCode()).and("statusShow").is(true).and("statusGroup").is(true).and("statusApprove").is(1));
            Criteria queryName = Criteria.where("name").regex(Pattern.compile(name, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE));
            query.addCriteria(queryName);
            query.limit(limit);
            query.with(new Sort(Sort.Direction.DESC, "createDate"));
            productList = (List)mongoTempl().find(query, Product.class, collectionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }
    public List<Product> getAllSolution(int limit, String name, String groupId) {
        List<Product> productList = new ArrayList<>();
        try {
            Query query = new Query(Criteria.where("groupId").is(groupId).and("statusShow").is(true).and("statusGroup").is(true).and("statusApprove").is(1));
            Criteria queryName = Criteria.where("name").regex(Pattern.compile(name, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE));
            query.addCriteria(queryName);
            query.limit(limit);
            query.with(new Sort(Sort.Direction.DESC, "createDate"));
            productList = (List)mongoTempl().find(query, Product.class, collectionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    public List<Product> getAllDevice(int limit, String name) {
        List<Product> productList = new ArrayList<>();
        try {
            Query query = new Query(Criteria.where("groupType").is(GroupProduct.Types.device.getCode()).and("statusShow").is(true).and("statusGroup").is(true).and("statusApprove").is(1));
            Criteria queryName = Criteria.where("name").regex(Pattern.compile(name, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE));
            query.addCriteria(queryName);
            query.limit(limit);
            query.with(new Sort(Sort.Direction.DESC, "createDate"));
            productList = (List)mongoTempl().find(query, Product.class, collectionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    public List<Product> getAllDevice(int limit, String name, String groupId) {
        List<Product> productList = new ArrayList<>();
        try {
            Query query = new Query(Criteria.where("groupId").is(groupId).and("statusShow").is(true).and("statusGroup").is(true).and("statusApprove").is(1));
            Criteria queryName = Criteria.where("name").regex(Pattern.compile(name, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE));
            query.addCriteria(queryName);
            query.limit(limit);
            query.with(new Sort(Sort.Direction.DESC, "createDate"));
            productList = (List)mongoTempl().find(query, Product.class, collectionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    public long countProductInGroup(String groupId){
        long countProduct = 0;
        try {
            Query query = new Query( Criteria.where("groupId").is(groupId).and("statusShow").is(true).and("statusGroup").is(true).and("statusApprove").is(1));
            countProduct = mongoTempl().count(query, Product.class, collectionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countProduct;
    }

    public List<Product> getAllProductInGroup(String groupId) {
        List<Product> productList = new ArrayList<>();
        try {
            Query query = new Query(Criteria.where("groupId").is(groupId));
            productList = (List)mongoTempl().find(query, Product.class, collectionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }
}
