
$(function(){
    "use strict";

    // Селекторы -----------------------------------------------------
    var selectors = {
        userTableRow: "#user-table-body-row",
        userTable: "#user-list-table"
    };

    // Закешированные ноды -------------------------------------------
    var $userTable = $(selectors.userTable);

    // Пути для запросов CRUD ----------------------------------------
    var usersPaths = {
        "get": "/users"
    };

    // Компиляция шаблонов -------------------------------------------
    var userTableRow = _.template($(selectors.userTableRow).html());

    // Коллбэки ------------------------------------------------------
    var renderUserTableBody = function (userList) {
        // Рендер html
        var userRows = userTableRow({friends: userList});
        $("tbody", $userTable).html(userRows);
    };

    // Утилитарные методы -------------------------------------------
    var showTrobbler = function($el){
        $('<div class="trobler">').insertAfter($el);
    };

    var hideTrobler = function($el){
        $el.next("div.trobler").remove();
    };

    //$.get(usersPaths.get).done(renderUserTableBody)
    //    .fail(function() {
    //        alert( "error" );
    //    })
    //    .always(function() {
    //        alert( "finished" );
    //    });

    // Начальный рендер юзеров ----------------------------------------
    renderUserTableBody(window.users);
});
