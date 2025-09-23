package controllers;

import com.google.inject.Inject;
import org.springframework.util.StringUtils;
import play.Logger;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import services.UserService;
import vn.m2m.common.models.User;
import vn.m2m.utils.ParseUtil;
import vn.m2m.utils.UserHelper;

public class Secured extends Security.Authenticator {
    Logger.ALogger logger = Logger.of(Secured.class);
    @Inject
    UserService userService;

    @Override
    public String getUsername(Http.Context ctx) {
        Http.Session session = ctx.session();
//        String sessionId = session.get(UserHelper.SessionData.sessionId);
        String username = session.get(UserHelper.SessionData.username);

        if(StringUtils.isEmpty(username)){
            logger.info("username empty");
            return null;
        }
//        if(UserHelper.isSessionTimeOut(sessionId)){
//            // session expired
//            logger.info("session expired - session.clear():");
//            userService.cleanUserSessionInCookie(ctx);
//            return null;
//        }
        User currentUser = getCurrentUsername(username);
        if(currentUser!= null){
            String lastModified = session.get(UserHelper.SessionData.lastModified);
            if(StringUtils.isEmpty(lastModified)
                    || !lastModified.equals(""+ ParseUtil.parseDate(currentUser.getLastModified()))){
                userService.addUserSessionToCookie(session, currentUser, false);
            }

            return currentUser.getUsername();
        }
        logger.info("currentUser null");
        return null;
    }

    @Override
    public Result onUnauthorized(Http.Context ctx) {
        String returnUrl = ctx.request().header("Raw-Request-URI").get();
        userService.cleanUserSessionInCookie(ctx);
        return redirect("/login?returnUrl="+returnUrl);
    }

    public User getCurrentUser() {
        String sessionId = Http.Context.current().session().get(UserHelper.SessionData.sessionId);
        return getCurrentUser(sessionId);
    }
    private User getCurrentUser(String sessionId) {
        if(StringUtils.isEmpty(sessionId))
        {
            return null;
        }
        User currentUser = userService.getUserBySession(sessionId);
        return currentUser;
    }
    private User getCurrentUsername(String username) {
        if(StringUtils.isEmpty(username))
        {
            return null;
        }
        User currentUser = userService.getUserByUsername(username);
        return currentUser;
    }
    // Access rights



}
