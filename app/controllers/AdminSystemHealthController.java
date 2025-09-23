package controllers;

import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;

/**
 * Created by vtk-anhlt166 on 8/23/22.
 */
@Security.Authenticated(Secured.class)
public class AdminSystemHealthController extends AbstractController {

    public Result systemHealth() {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        if (userSession.getSystemRole() != User.SystemRole.SYSTEM_ADMIN.getCode()) {
            flash("failed", getMessages().at("noti.notPermit"));
            return redirect(controllers.routes.Application.login());
        }

        return ok(views.html.admin.systemHealth.SystemHealth.render(userSession));
    }
}
