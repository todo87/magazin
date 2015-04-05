<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/views/includes/script/header.jsp"/>
<script type="text/javascript" src="/res/custom_script/admin/main.js"></script>
<script type="text/javascript" src="/res/custom_script/admin/common_admin_all.js"></script>
<script type="text/javascript">
    var mainAdmin = angular.module("mainAdmin", []);

    mainAdmin.controller("collectionsArray",
            function($scope,sharedDataTable) {
                $scope.colnames = ${collectionNames};

                //function binded to the radio button on change
                $scope.onClick = function (){
                    //ajax call
                    $.ajax(
                            {url: "${requestScope['javax.servlet.forward.request_uri']}/" + $scope.valueSelected,
                                success: function(data){
                                    sharedDataTable.setDataTable(data);
                                    alert(data);

                                }});
                }
            });
    mainAdmin.controller("dataTable",
            function($scope,sharedDataTable) {

            });
    mainAdmin.service("sharedDataTable",function(){
        var dataTable="";
        return {
            getDataTable: function () {
                return dataTable;
            },
            setDataTable: function(data) {
                dataTable = data;
            }
        };
    });

</script>
<html>
<head>
    <title>Main admin</title>
</head>
<body ng-app="mainAdmin">
    <div class="container-fluid">
        <p class="logout_paragraph">Logged as <strong>${pageContext.request.userPrincipal.name}</strong> | <a id="logout_link" onclick="formSubmit()">Logout</a></p>
        <form action="/logout" method="post" id="logoutForm" style="display: none;">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <div class="jumbotron">
            <h2>Welcome !</h2>
        </div>
        <div id="divchkCollections" class="admin_left_menu pre-scrollable col-md-2">
            <div ng-controller="collectionsArray" id="chkCollections" class="admin_collection_list radio">
                <h4>Collections</h4>
                    <label ng-repeat="colname in colnames">
                        <input type="radio" name="chkCollectionsRadio" ng-model="$parent.valueSelected" ng-change="onClick()" ng-value="colname" class="radio-button"> {{colname}}
                    </label>
            </div>
        </div>
        <div id="admin_data_table" class="col-md-10">


        </div>

    </div>
</body>
</html>
