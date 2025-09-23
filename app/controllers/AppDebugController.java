package controllers;

import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;

/**
 * Created by vtk-anhlt166 on 12/3/21.
 */
public class AppDebugController extends AbstractController {

    public Result appDebug(String projectId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.iot.app.AppDebug.render(userSession, projectId));
    }

    public Result appSdk(String projectId) {
        User userSession = getUserSession();
        if (userSession == null) {
            flash("failed", getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.iot.app.AppSDK.render(userSession, projectId));
    }

    public Result appDebugPage() {
        User userSession = getUserSession();

        return ok(views.html.landingPage.page.AppDebug.render(userSession));
    }

    public Result appSdkPage() {
        User userSession = getUserSession();

        return ok(views.html.landingPage.page.AppSdk.render(userSession));
    }

    public Result solutionMaketPage() {
        User userSession = getUserSession();

        return ok(views.html.landingPage.page.SolutionMaket.render(userSession));
    }
}
