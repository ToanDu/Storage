package vn.m2m.config;

import com.typesafe.config.Config;
import org.springframework.beans.factory.annotation.Value;
import play.Configuration;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Singleton
public class AppfileConfig {

    @Inject
    public AppfileConfig(Config configuration){
        for(Field field: this.getClass().getDeclaredFields()){
            Annotation annotation = field.getAnnotation(Value.class);
            Class<?> type = field.getType();
            if (annotation instanceof Value) {
                try {
                    Value valueConfig = (Value) annotation;
                    field.setAccessible(true);
                    if(type.isAssignableFrom(String.class)){
                        field.set(this, configuration.getString(valueConfig.value()));
                    }
                    else if(type.isAssignableFrom(Integer.class)){
                        field.set(this, configuration.getInt(valueConfig.value()));
                    }
                    else if(type.isAssignableFrom(Boolean.class)){
                        field.set(this, configuration.getBoolean(valueConfig.value()));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // ///////////////SERVER CONFIG/////////////////
    @Value("server.appname")
    public String serverAppname;

    @Value("play.server.http.port")
    public String serverPort;

    public String getServerKey(){
        String hostname = "";
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
        String serverKey=hostname + "_" + serverPort;
        return serverKey;
    }

    // /////////////////////HAZELCAST CONFIG///////////

    @Value("hazelcast.prefix.name")
    public String prefixNameHzc;

    @Value("hazelcast.group.name")
    public String groupNameHzc;

    @Value("hazelcast.group.password")
    public String groupPasswordHzc;

    @Value("hazelcast.network.members")
    public String networkMembersHzc;

    @Value("hazelcast.connection.attempt.period")
    public Integer connectionAttemptPeriodHzc;

    @Value("hazelcast.connection.attempt.limit")
    public Integer connectionAttemptLimitHzc;

    @Value("hazelcast.connection.timeout")
    public Integer connectionTimeoutHzc;

    @Value("hazelcast.smart-routing")
    public Boolean isSmartRoutingHzc;

    @Value("hazelcast.redo-operation")
    public Boolean isRedoOperationHzc;

    @Value("hazelcast.executorpoolsize")
    public Integer executorPoolSizeHzc;

    // /////////////////////MONGODB CONFIG///////////
    @Value("mongo.network.members")
    public String networkMembersMongo;

    @Value("mongo.network.connectionPerHost")
    public Integer connectionPerHostMongo;

    @Value("mongo.network.threadAllowBlock")
    public Integer threadAllowBlockMongo;

    @Value("mongo.network.replicaSet")
    public Boolean isReplicaSetMongo;

    @Value("mongo.network.socketKeepAlive")
    public Boolean socketKeepAliveMongo;

    @Value("mongo.network.socketTimeout")
    public Integer socketTimeoutMongo;

    @Value("mongo.network.connectTimeout")
    public Integer connectTimeoutMongo;

    @Value("mongo.db.username")
    public String usernameMongo;

    @Value("mongo.db.password")
    public String passwordMongo;

    @Value("mongo.db.databaseName")
    public String databaseNameMongo;

    @Value("mail.from.serverEmail")
    public String serverEmail;

    @Value("list.email.send.contact")
    public String listEmailSendContact;

    @Value("host.name.send.contact")
    public String hostNameSendContact;

    @Value("url.backend.iot")
    public String ulrBackendIot;

    @Value("url.backend.telco")
    public String urlBackendIotTelco;

    @Value("url.backend.telco2")
    public String urlBackendIotTelco2;

    @Value("url.backend.upfile")
    public String urlBackendUpfile;

    @Value("url.android.vtag")
    public String urlAndroidVtag;

    @Value("url.ios.vtag")
    public String urlIosVtag;

    @Value("user.admin.mail")
    public String userAdminMail;

    @Value("url.rule.engine")
    public String urlRuleEngine;

    @Value("version.number")
    public String versionNumber;

    @Value("url.oauth.hydra.admin")
    public String urlHydraAdmin;

    @Value("content.folder.image")
    public String contentFolderImage;

    @Value("url.backend.sendCommandRPC")
    public String ulrBackendSendCommandRPC;

    @Value("url.backend.appLogin")
    public String urlBackendAppLogin;
}
