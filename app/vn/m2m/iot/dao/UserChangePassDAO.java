package vn.m2m.iot.dao;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.util.StringUtils;
import vn.m2m.common.AbstractDAO;

import vn.m2m.config.HazelcastConfig;
import vn.m2m.config.MongoConfig;
import vn.m2m.iot.models.UserChangePass;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserChangePassDAO extends AbstractDAO<String, UserChangePass> {
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

    public UserChangePassDAO(){
        super(String.class, UserChangePass.class);

    }

    public UserChangePass getByUsername(String username){
        if(StringUtils.isEmpty(username)){
            return null;
        }

        UserChangePass userChangePass= getOneByFieldname("username", username);

        return userChangePass;
    }
}
