package vn.m2m.iot.dao;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.data.mongodb.core.MongoTemplate;
import vn.m2m.common.AbstractDAO;
import vn.m2m.config.AppfileConfig;
import vn.m2m.config.HazelcastConfig;
import vn.m2m.config.MongoConfig;
import vn.m2m.iot.models.DeviceType;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DeviceTypeDAO extends AbstractDAO<String, DeviceType> {
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

    public DeviceTypeDAO() {
        super(String.class, DeviceType.class);
    }
}
