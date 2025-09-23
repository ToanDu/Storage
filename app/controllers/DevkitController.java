package controllers;

import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;

/**
 * Created by vtk-anhlt166 on 12/3/21.
 */
@Security.Authenticated(Secured.class)
public class DevkitController extends AbstractController {

    public Result devkit(String projectId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.iot.devkit.Devkit.render(userSession, projectId));
    }
}
