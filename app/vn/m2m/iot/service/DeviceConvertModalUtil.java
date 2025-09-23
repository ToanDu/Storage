package vn.m2m.iot.service;

import play.Logger;
import vn.m2m.iot.form.DevicePositionInitMarker;
import vn.m2m.iot.models.DeviceIot;
import vn.m2m.models.GroupDAO;
import vn.m2m.utils.DateUtil;

import javax.inject.Inject;

import static vn.m2m.utils.DateUtil.TIME_FORMAT_POSITION_MAP_SIDEBAR;

/**
 * Created by vtk-anhlt166 on 2/19/20.
 */
public class DeviceConvertModalUtil {
    public Logger.ALogger logger = Logger.of(DeviceConvertModalUtil.class);

    @Inject
    public GroupDAO groupDAO;

    public DevicePositionInitMarker convertDeviceIotToInitMapMarker(DeviceIot deviceIot, int webMapTimeLostConnectionMinutes){
        if(deviceIot == null){
            return null;
        }
        if(deviceIot.getLogDate() == null){
            return  null;
        }
        DevicePositionInitMarker positionInitMap = new DevicePositionInitMarker();
        if(deviceIot.getDateTracking() != null && deviceIot.getCurrentLat() > 0 && deviceIot.getCurrentLong() > 0){
            positionInitMap.setId(deviceIot.getId());
            positionInitMap.setImei(deviceIot.getImei());
            positionInitMap.setName(deviceIot.getName());
            positionInitMap.setCurrentLat(deviceIot.getCurrentLat());
            positionInitMap.setCurrentLon(deviceIot.getCurrentLong());
            String sTime = DateUtil.convertDatetoString(deviceIot.getDateTracking(), TIME_FORMAT_POSITION_MAP_SIDEBAR);
            positionInitMap.setsDateTracking(sTime);
            positionInitMap.setRotation(0);
            positionInitMap.setVol(deviceIot.getBattery());

            return  positionInitMap;

        }else {
            return  null;
        }

    }
}
