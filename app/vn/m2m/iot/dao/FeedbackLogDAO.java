package vn.m2m.iot.dao;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import vn.m2m.common.AbstractDAO;
import vn.m2m.config.AppfileConfig;
import vn.m2m.config.HazelcastConfig;
import vn.m2m.config.MongoConfig;
import vn.m2m.iot.models.FeedbackLog;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class FeedbackLogDAO extends AbstractDAO<String, FeedbackLog> {
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

    public FeedbackLogDAO() {
        super(String.class, FeedbackLog.class);
    }

    public List<FeedbackLog> getLogListFeedbackPaging(int page, int pagesize, String email, String phone) {
        List<FeedbackLog> feedbackLogList = new ArrayList<>();
        try {
            Criteria query1 =  Criteria.where("email").regex(email,"i");
            Criteria query2 = Criteria.where("phone").regex(phone,"i");
//            Criteria query3 = Criteria.where("url").regex(url,"i");

            List<Criteria> criterias = new ArrayList<Criteria>();
            criterias.add(query1);
            criterias.add(query2);
//            criterias.add(query3);

            Query query = new Query();
            Criteria criteria = new Criteria().andOperator(criterias.toArray(new Criteria[criterias.size()]));
            query.addCriteria(criteria);

            query.skip(pagesize * (page - 1));
            query.limit(pagesize);
            query.with(new Sort(Sort.Direction.DESC, "logDate"));
            feedbackLogList = (List)mongoTempl().find(query, FeedbackLog.class, collectionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return feedbackLogList;
    }

    public long countLogListFeedback(String email, String phone) {
        long countLogFeedback = 0;
        try {
            Criteria query1 =  Criteria.where("email").regex(email,"i");
            Criteria query2 = Criteria.where("phone").regex(phone,"i");
//            Criteria query3 = Criteria.where("url").regex(url,"i");

            List<Criteria> criterias = new ArrayList<Criteria>();
            criterias.add(query1);
            criterias.add(query2);
//            criterias.add(query3);

            Query query = new Query();
            Criteria criteria = new Criteria().andOperator(criterias.toArray(new Criteria[criterias.size()]));
            query.addCriteria(criteria);

            countLogFeedback = mongoTempl().count(query, FeedbackLog.class, collectionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countLogFeedback;
    }
}
