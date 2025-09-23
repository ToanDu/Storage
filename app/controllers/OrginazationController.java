package controllers;

import play.mvc.Result;
import play.mvc.Security;
import vn.m2m.common.models.User;

/**
 * Created by vtk-anhlt166 on 2/8/22.
 */
@Security.Authenticated(Secured.class)
public class OrginazationController extends AbstractController {

    public Result orginazationView(String id){
        User userSession = getUserSession();
        if(userSession == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        return ok(views.html.iot.orginazation.OrginazationView.render(userSession, id));
    }
}
