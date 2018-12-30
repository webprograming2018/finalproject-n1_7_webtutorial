function highlight(id, string, language) {
    if (language == "HTML")
        return document.getElementById(id).innerHTML = Prism.highlight(string, Prism.languages.markup);
    else if (language == "CSS")
        return $(id).html(Prism.highlight(string, Prism.languages.css));
    else if (language == "JAVASCRIPT")
        return $(id).html(Prism.highlight(string, Prism.languages.javascript));
}

// Bat su kien dong cua so
window.onbeforeunload = function(event) {
    var timeend = new Date().toLocaleString();
    // $http.get('/api/lessons/get-lesson-id?state=' + $state.current.name).then(onSuccess, onError);
    return "Closed";
}

// Bat su kien chuyen tab, thu nho cua so
document.addEventListener("visibilitychange", function() {
    if (document.hidden) {
        vm.endTime = new Date();
        // $http.get('/api/lessons/get-lesson-id?state=' + $state.current.name).then(onSuccess, onError);
    } else {
        vm.startTime = new Date();
    }
}, false);

// Bat su kien chuyen trang
window.onpopstate = function() {
    // $http.get('/api/lessons/get-lesson-id?state=' + $state.current.name).then(onSuccess, onError);
};