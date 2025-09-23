package vn.m2m.iot.dao;

import com.hazelcast.core.HazelcastInstance;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import vn.m2m.common.AbstractDAO;
import vn.m2m.config.AppfileConfig;
import vn.m2m.config.HazelcastConfig;
import vn.m2m.config.MongoConfig;
import vn.m2m.iot.models.DeviceIot;
import vn.m2m.iot.models.TelcoLog;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vtk-anhlt166 on 12/20/22.
 */
@Singleton
public class TelcoLogDAO extends AbstractDAO<String, TelcoLog> {
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

    public TelcoLogDAO() {
        super(String.class, TelcoLog.class);
    }

    public List<TelcoLog> getLogListCmpPaging(int page, int pagesize, String username, String function, String url) {
        List<TelcoLog> telcoLogList = new ArrayList<>();
        try {
            Criteria query1 =  Criteria.where("username").regex(username,"i");
            Criteria query2 = Criteria.where("name").regex(function,"i");
            Criteria query3 = Criteria.where("url").regex(url,"i");

            List<Criteria> criterias = new ArrayList<Criteria>();
            criterias.add(query1);
            criterias.add(query2);
            criterias.add(query3);

            Query query = new Query();
            Criteria criteria = new Criteria().andOperator(criterias.toArray(new Criteria[criterias.size()]));
            query.addCriteria(criteria);

            query.skip(pagesize * (page - 1));
            query.limit(pagesize);
            query.with(new Sort(Sort.Direction.DESC, "logDate"));
            telcoLogList = (List)mongoTempl().find(query, TelcoLog.class, collectionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return telcoLogList;
    }

    public long countLogListCmp(String username, String function, String url) {
        long countLogCmp = 0;
        try {
            Criteria query1 =  Criteria.where("username").regex(username,"i");
            Criteria query2 = Criteria.where("name").regex(function,"i");
            Criteria query3 = Criteria.where("url").regex(url,"i");

            List<Criteria> criterias = new ArrayList<Criteria>();
            criterias.add(query1);
            criterias.add(query2);
            criterias.add(query3);

            Query query = new Query();
            Criteria criteria = new Criteria().andOperator(criterias.toArray(new Criteria[criterias.size()]));
            query.addCriteria(criteria);

            countLogCmp = mongoTempl().count(query, TelcoLog.class, collectionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countLogCmp;
    }
}
