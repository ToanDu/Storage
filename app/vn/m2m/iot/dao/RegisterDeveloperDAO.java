package vn.m2m.iot.dao;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.data.mongodb.core.MongoTemplate;
import vn.m2m.common.AbstractDAO;
import vn.m2m.config.HazelcastConfig;
import vn.m2m.config.MongoConfig;
import vn.m2m.iot.models.RegisterDeveloper;

import javax.inject.Inject;

/**
 * Created by vtk-anhlt166 on 7/27/22.
 */
public class RegisterDeveloperDAO extends AbstractDAO<String, RegisterDeveloper> {
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

    public RegisterDeveloperDAO(){
        super(String.class, RegisterDeveloper.class);

    }
}
