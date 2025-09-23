package vn.m2m.iot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import vn.m2m.common.HazelcastTTL;
import vn.m2m.common.ModelData;

import java.io.Serializable;
import java.util.List;

@ModelData(collection = "Event", mapCacheName = "", mapCacheTTL = HazelcastTTL.TTL_1_DAY)
public class Event implements Serializable {
    private static final long serialVersionUID = 1L; //1L

    @Id
    @JsonProperty("eventid")
    private String id;
    private String name;
    private String organization;
    private List<Condition> condition;
    private List<Action> action;
    private Interval interval;
    private boolean status;

    @JsonIgnore
    private String statusStr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public List<Condition> getCondition() {
        return condition;
    }

    public void setCondition(List<Condition> condition) {
        this.condition = condition;
    }

    public Interval getInterval() {
        return interval;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getStatusStr() {
        return this.status ? "Active" : "Deactive";
    }

    public List<Action> getAction() {
        return action;
    }

    public void setAction(List<Action> action) {
        this.action = action;
    }

    public static class Condition implements Serializable {
        private static final long serialVersionUID = 1L; //1L
        @JsonProperty("deviceid")
        private String deviceId;
        private String variableName;
        private String variableType;
        private String operator;
        private String threshold;
        private String logicalOperator;

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public String getVariableName() {
            return variableName;
        }

        public void setVariableName(String variableName) {
            this.variableName = variableName;
        }

        public String getVariableType() {
            return variableType;
        }

        public void setVariableType(String variableType) {
            this.variableType = variableType;
        }

        public String getOperator() {
            return operator;
        }

        public void setOperator(String operator) {
            this.operator = operator;
        }

        public String getThreshold() {
            return threshold;
        }

        public void setThreshold(String threshold) {
            this.threshold = threshold;
        }

        public String getLogicalOperator() {
            return logicalOperator;
        }

        public void setLogicalOperator(String logicalOperator) {
            this.logicalOperator = logicalOperator;
        }
    }

    public static class Action implements Serializable {
        private static final long serialVersionUID = 1L; //1L
        private String actionType;
        private String receiver;
        private String subject;
        private String message;

        public String getActionType() {
            return actionType;
        }

        public void setActionType(String actionType) {
            this.actionType = actionType;
        }

        public String getReceiver() {
            return receiver;
        }

        public void setReceiver(String receiver) {
            this.receiver = receiver;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class Interval implements Serializable {
        private static final long serialVersionUID = 1L; //1L
        private boolean monday;
        private boolean tuesday;
        private boolean wednesday;
        private boolean thursday;
        private boolean friday;
        private boolean saturday;
        private boolean sunday;

        @JsonProperty("starttime")
        private String startTime;

        @JsonProperty("endtime")
        private String endTime;

        public boolean isMonday() {
            return monday;
        }

        public void setMonday(boolean monday) {
            this.monday = monday;
        }

        public boolean isTuesday() {
            return tuesday;
        }

        public void setTuesday(boolean tuesday) {
            this.tuesday = tuesday;
        }

        public boolean isWednesday() {
            return wednesday;
        }

        public void setWednesday(boolean wednesday) {
            this.wednesday = wednesday;
        }

        public boolean isThursday() {
            return thursday;
        }

        public void setThursday(boolean thursday) {
            this.thursday = thursday;
        }

        public boolean isFriday() {
            return friday;
        }

        public void setFriday(boolean friday) {
            this.friday = friday;
        }

        public boolean isSaturday() {
            return saturday;
        }

        public void setSaturday(boolean saturday) {
            this.saturday = saturday;
        }

        public boolean isSunday() {
            return sunday;
        }

        public void setSunday(boolean sunday) {
            this.sunday = sunday;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }
    }
}
