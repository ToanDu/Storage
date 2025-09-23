package controllers;

import play.mvc.Security;
import vn.m2m.common.models.User;
import play.mvc.Result;
import vn.m2m.config.AppfileConfig;

import javax.inject.Inject;

/**
 * Created by vtk-anhlt166 on 7/6/21.
 */
@Security.Authenticated(Secured.class)
public class RuleChainController extends AbstractController {
    @Inject
    public AppfileConfig appfileConfig;

    public Result ruleChain(String projectId){
        User user = getUserSession();
        if(user == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        String urlRuleEngine = appfileConfig.urlRuleEngine + "?token=" + user.getToken() + "&project_id=" + projectId;
        logger.info("urlRuleEngine :{}", urlRuleEngine);

        return ok(views.html.ruleChain.RuleChain.apply(user, urlRuleEngine, projectId));
    }

    public Result flowEngineWithId(String projectId, String id){
        User user = getUserSession();
        if(user == null){
            flash("failed",getMessages().at("noti.sessionTimeOut"));
            return redirect(routes.Application.login());
        }

        String urlRuleEngine = appfileConfig.urlRuleEngine + "/ruleChains/" + id;
        logger.info("urlRuleEngine :{}", urlRuleEngine);

        return ok(views.html.ruleChain.RuleChain.apply(user, urlRuleEngine, projectId));
    }
}
