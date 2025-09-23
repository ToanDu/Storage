package controllers;

import com.google.inject.Inject;
import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;
import vn.m2m.service.ApiService;

/**
 * Created by vtk-anhlt166 on 8/22/22.
 */
@Security.Authenticated(Secured.class)
public class AdminOverviewProjectController extends AbstractController {
    @Inject
    public ApiService apiService;

    public Result adminOverviewProject(String projectId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(controllers.routes.Application.login());
        }

        if (userSession.getSystemRole() != User.SystemRole.SYSTEM_ADMIN.getCode()) {
            flash("failed", getMessages().at("noti.notPermit"));
            return redirect(controllers.routes.Application.login());
        }

        return ok(views.html.admin.overview.project.AdminOverview_detailProject.render(userSession, projectId));
    }
}
