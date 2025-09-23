package controllers;

import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;

@Security.Authenticated(Secured.class)
public class ModuleController extends AbstractController {

    public Result module(String projectId) {

        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.iot.module.Module.render(userSession, projectId));
    }
}
