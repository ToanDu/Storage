package vn.m2m.common.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import vn.m2m.common.HazelcastTTL;
import vn.m2m.common.ModelData;

import java.io.Serializable;
import java.util.Base64;
import java.util.List;

@ModelData(collection = "Role", mapCacheName = "", mapCacheTTL = HazelcastTTL.TTL_1_DAY)
public class Role implements Serializable {
    private static final long serialVersionUID = 8L;
    @Id
    private String id;
    @JsonProperty("role_name")
    private String name;
    @JsonProperty("members")
    private List<String> members;
    @JsonProperty("services_policy")
    private List<Policy> services;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Policy> getServices() {
        return services;
    }

    public void setServices(List<Policy> services) {
        this.services = services;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public static class Policy implements Serializable {
        private static final long serialVersionUID = 8L;

        @Id
        private String id;
        @JsonProperty("resource")
        private List<String> resources;
        @JsonProperty("action")
        private List<String> actions;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getResources() {
            return resources;
        }

        public void setResources(List<String> resources) {
            this.resources = resources;
        }

        public List<String> getActions() {
            return actions;
        }

        public void setActions(List<String> actions) {
            this.actions = actions;
        }
    }

    public String getServiceLog(){
        String content = "ID : " + this.id + "<hr>" +
                "Name : " + this.name + "<hr>" ;
        if(this.services.size() > 0){
            for(int i=0; i<this.services.size(); i++){
                content += this.services.get(i).getId() +"<br>" + this.services.get(i).getResources() +" - " + this.services.get(i).getActions() +"<hr>" ;
            }
        }

        byte[] base64Data = Base64.getEncoder().encode(content.getBytes());

        return new String(base64Data);
    }
}
