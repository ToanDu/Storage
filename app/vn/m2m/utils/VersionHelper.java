package vn.m2m.utils;

/**
 * Created by tannb on 05/08/2019.
 */
public class VersionHelper {
    public class StaticContent{
        public static final String VERSION_NAME ="version.name";
        public static final String VERSION_ORGANIZATION ="version.organization";
        public static final String VERSION_NUMBER ="version.number";
        public static final String VERSION_BUILD_DATE ="version.builddate";
    }

    public static String versionName = AppHelper.getAppConfigString(StaticContent.VERSION_NAME);
    public static String versionOrganization = AppHelper.getAppConfigString(StaticContent.VERSION_ORGANIZATION);
    public static String versionNumber = AppHelper.getAppConfigString(StaticContent.VERSION_NUMBER);
    public static String versionBuildDate = AppHelper.getAppConfigString(StaticContent.VERSION_BUILD_DATE);
}
