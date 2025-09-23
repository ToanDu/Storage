package vn.m2m.iot.dao;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.data.mongodb.core.MongoTemplate;
import vn.m2m.common.AbstractDAO;
import vn.m2m.config.HazelcastConfig;
import vn.m2m.config.MongoConfig;
import vn.m2m.iot.models.TemplateDevice;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by vtk-anhlt166 on 6/14/22.
 */
@Singleton
public class TemplateDeviceDAO extends AbstractDAO<String, TemplateDevice> {
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

    public TemplateDeviceDAO(){
        super(String.class, TemplateDevice.class);

    }
}
