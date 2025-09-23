/**
 * Created by vtk-anhlt166 on 7/6/21.
 */
function changeRuleChainRoot() {
    console.log("iframeRuleChainRoot");
    var iframe = '<iframe src="http://localhost:4200/ruleChains/8c513cd0-d246-11eb-9381-ab2a1a8daaf0" width="100%" height="100%" allowfullscreen></iframe>'
    $("#iframeRuleChain").html(iframe);
}

function changeRuleChain() {
    var iframe = '<iframe src="http://localhost:4200/ruleChains" width="100%" height="100%" allowfullscreen></iframe>'
    $("#iframeRuleChain").html(iframe);
}