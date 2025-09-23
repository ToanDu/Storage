package vn.m2m.iot.dao;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.StringUtils;
import vn.m2m.common.AbstractDAO;
import vn.m2m.config.HazelcastConfig;
import vn.m2m.config.MongoConfig;
import vn.m2m.iot.models.Widget;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class WidgetDAO extends AbstractDAO<String, Widget> {
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

    public WidgetDAO(){
        super(String.class, Widget.class);

    }

    public Widget getByUsername(String username){
        if(StringUtils.isEmpty(username)){
            return null;
        }

        Widget widget= getOneByFieldname("username", username);

        return widget;
    }

    public List<Widget> getWidgetList(String projectId, String username) {
        List<Widget> widgetList = new ArrayList<>();
        try {
            Query query = new Query(Criteria.where("projectId").is(projectId).and("username").is(username));
            query.with(new Sort(Sort.Direction.DESC, "logDate"));
            widgetList = (List)mongoTempl().find(query, Widget.class, collectionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return widgetList;
    }

    public Widget getByOrgId(String id){
        if(StringUtils.isEmpty(id)){
            return null;
        }

        Widget widget= getOneByFieldname("orgId", id);

        return widget;
    }

    public List<Widget> getWidgetListByProjectId(String projectId) {
        List<Widget> widgetList = new ArrayList<>();
        try {
            Query query = new Query(Criteria.where("projectId").is(projectId));
            widgetList = (List)mongoTempl().find(query, Widget.class, collectionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return widgetList;
    }
}
