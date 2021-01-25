/*
* option : {
*   url: String,
*   method: String,
*   requestHeader: Array,
*   data: Object,
*   successCode: Number,
*   successFn: Function,
*   errorFn: Function
* */
function ajax(option) {
    console.log(option);
    const httpRequest = new XMLHttpRequest();

    if(!httpRequest) return false;
    else {
        httpRequest.onreadystatechange = function () {
            if (httpRequest.readyState === XMLHttpRequest.DONE) {
                if (httpRequest.status === option.successCode) {
                    if (option.successFn) option.successFn(httpRequest.response);
                } else {
                    if (option.errorFn) option.errorFn(httpRequest.response);
                }
            }
        }
        httpRequest.open(option.method, option.url);

        if(option.requestHeader instanceof Array) {
            option.requestHeader.forEach(function (header) {
                httpRequest.setRequestHeader(header.name, header.value);
            });
        }
        httpRequest.send(option.data)
    }
}