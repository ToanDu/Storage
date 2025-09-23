package vn.m2m.iot.dao;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.StringUtils;
import vn.m2m.common.AbstractDAO;
import vn.m2m.config.AppfileConfig;
import vn.m2m.config.HazelcastConfig;
import vn.m2m.config.MongoConfig;
import vn.m2m.iot.models.CustomerSurvey;
import vn.m2m.iot.models.DeviceIot;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class CustomerSurveyDAO extends AbstractDAO<String, CustomerSurvey> {
    @Inject
    AppfileConfig appfileConfig;

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

    public CustomerSurveyDAO() {
        super(String.class, CustomerSurvey.class);
    }

    public List<CustomerSurvey> getLogListCustomerSurveyPaging(int page, int pagesize) {
        List<CustomerSurvey> customerSurveyList = new ArrayList<>();
        try {
//            Criteria query1 =  Criteria.where("username").regex(username,"i");
//            Criteria query2 = Criteria.where("name").regex(function,"i");
//            Criteria query3 = Criteria.where("url").regex(url,"i");

//            List<Criteria> criterias = new ArrayList<Criteria>();
//            criterias.add(query1);
//            criterias.add(query2);
//            criterias.add(query3);

            Query query = new Query();
//            Criteria criteria = new Criteria().andOperator(criterias.toArray(new Criteria[criterias.size()]));
//            query.addCriteria(criteria);

            query.skip(pagesize * (page - 1));
            query.limit(pagesize);
            query.with(new Sort(Sort.Direction.DESC, "logDate"));
            customerSurveyList = (List)mongoTempl().find(query, CustomerSurvey.class, collectionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerSurveyList;
    }

    public long countLogListCustomerSurvey() {
        long countLogCustomerSurvey = 0;
        try {
//            Criteria query1 =  Criteria.where("username").regex(username,"i");
//            Criteria query2 = Criteria.where("name").regex(function,"i");
//            Criteria query3 = Criteria.where("url").regex(url,"i");
//
//            List<Criteria> criterias = new ArrayList<Criteria>();
//            criterias.add(query1);
//            criterias.add(query2);
//            criterias.add(query3);

            Query query = new Query();
//            Criteria criteria = new Criteria().andOperator(criterias.toArray(new Criteria[criterias.size()]));
//            query.addCriteria(criteria);

            countLogCustomerSurvey = mongoTempl().count(query, CustomerSurvey.class, collectionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countLogCustomerSurvey;
    }

    public CustomerSurvey getByUsername(String username){
        if(StringUtils.isEmpty(username)){
            return null;
        }

        CustomerSurvey dataModel= getOneByFieldname("username", username);

        return dataModel;
    }

    public List<CustomerSurvey> getCustomerSurveyByUsername(String username) {
        List<CustomerSurvey> customerSurveyList = new ArrayList<>();
        try {
            Query query = new Query(Criteria.where("username").is(username));
            customerSurveyList = (List)mongoTempl().find(query, CustomerSurvey.class, collectionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerSurveyList;
    }
}
