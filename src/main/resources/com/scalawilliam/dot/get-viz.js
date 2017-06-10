function getRenderer() {
    var obj = {};
    obj.renderDot = function (graph) {
        return Viz(graph, {format: 'svg', engine: 'dot'});
    };
    return obj;
}