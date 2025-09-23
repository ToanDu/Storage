package controllers;

import play.mvc.Result;

/**
 * Created by vtk-anhlt166 on 12/15/21.
 */
public class DownloadPageController extends AbstractController  {

    public Result download() {
        return ok(views.html.download.DownloadPage.apply());
    }
}
