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
import vn.m2m.iot.models.DeviceIot;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Date;
import java.util.List;

/**
 * Created by vtk-anhlt166 on 4/2/21.
 */
@Singleton
public class DeviceIotDAO extends AbstractDAO<String, DeviceIot> {
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

    public DeviceIotDAO() {
        super(String.class, DeviceIot.class);
    }

    public List<DeviceIot> getDeviceIotByGroupId(String idgroup) {

        List<DeviceIot> deviceIotList = null;
        try {
            Query query = new Query(Criteria.where("groupId").is(idgroup));
            query.with(new Sort(Sort.Direction.ASC, "name"));
            deviceIotList = (List)mongoTempl().find(query, DeviceIot.class, collectionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deviceIotList;
    }

    public long countDeviceIotByGroupId(String idgroup) {

        long deviceIotList = 0;
        try {
            Query query = new Query(Criteria.where("groupPath").is(idgroup));
            deviceIotList = mongoTempl().count(query, DeviceIot.class, collectionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deviceIotList;
    }

    public List<DeviceIot> getDeviceIotByDateTime(Date time) {
        List<DeviceIot> deviceIotList = null;
        try {
            Query query = new Query(Criteria.where("dateTracking").gte(time));
            deviceIotList = (List)mongoTempl().find(query, DeviceIot.class, collectionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deviceIotList;
    }
    public List<DeviceIot> getDeviceIotByGroupPathAndTime(String groupId, Date time) {
        List<DeviceIot> deviceIotList = null;
        try {
            Query query = new Query(Criteria.where("groupPath").is(groupId).and("dateTracking").gte(time));
            deviceIotList = (List)mongoTempl().find(query, DeviceIot.class, collectionName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deviceIotList;
    }
}
