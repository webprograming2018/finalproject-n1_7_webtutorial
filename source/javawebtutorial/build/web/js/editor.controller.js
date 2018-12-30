var editorSetting = {
    lineNumbers: true,
    mode: "htmlmixed",
    gutters: ["CodeMirror-lint-markers"],
    lint: true,
    inputStyle: "contenteditable",
    styleActiveLine: true,
    extraKeys: {
        "Ctrl-Space": "autocomplete"
    },
    autoCloseBrackets: true,
    theme: 'monokai',
    matchBrackets: true,
    matchTags: true,
    autoCloseTags: true,
    lineWrapping: true
};

var htmlEditor = CodeMirror.fromTextArea(document.getElementById("htmlEditor"), editorSetting);
htmlEditor.setSize("100%", "50vh");

var cssEditor = CodeMirror.fromTextArea(document.getElementById("cssEditor"), editorSetting);
cssEditor.setSize("100%", "50vh");
cssEditor.setOption("mode", "css");

var jsEditor = CodeMirror.fromTextArea(document.getElementById("jsEditor"), editorSetting);
jsEditor.setSize("100%", "50vh");
jsEditor.setOption("mode", "javascript");

function validate(editor) {
    var result = true;
    editor.forEach(function(element) {
        if (element.className == "CodeMirror-lint-mark-warning" || element.className == "CodeMirror-lint-mark-error")
            result = false;
    });
    return result;
}

function get(id){
    return document.getElementById(id).value
}

function load(id, code) {
    if (id == "htmlEditor") {
        htmlEditor.getDoc().setValue(code);
    } else if (id == "cssEditor") {
        cssEditor.getDoc().setValue(code);
    } else if (id == "jsEditor") {
        jsEditor.getDoc().setValue(code);
    }else {
        result.getDoc().setValue(code);
    }
}

function run() {
    if (validate(htmlEditor.getAllMarks()) && validate(cssEditor.getAllMarks()) && validate(jsEditor.getAllMarks()))
        $http.post('api/demo-code/compile', {
            html: htmlEditor.getValue(),
            css: cssEditor.getValue(),
            javascript: jsEditor.getValue()
        }).then(
            function onSuccess(response) {
                document.getElementById("result").contentWindow.document.open();
                document.getElementById("result").contentWindow.document.write("");
                document.getElementById("result").contentWindow.document.write(response.data.result);
                document.getElementById("result").contentWindow.document.close();
            },
            function onError(response) {
                document.getElementById("result").contentWindow.document.open();
                document.getElementById("result").contentWindow.document.write("");
                document.getElementById("result").contentWindow.document.write("SERVER ERROR");
                document.getElementById("result").contentWindow.document.close();
            });
    else
        alert("Check your code please!");
}

function changeTheme(newTheme) {
    htmlEditor.setOption('theme', newTheme);
    cssEditor.setOption('theme', newTheme);
    jsEditor.setOption('theme', newTheme)
}