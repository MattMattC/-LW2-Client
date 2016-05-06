<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<c:set var="baseURL" value="lw2_client-1.0-SNAPSHOT"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>[LW2] - Client</title>

    <meta charset="UTF-8">
    <spring:url value="/resources/core/css/hello.css" var="coreCss"/>
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${coreCss}" rel="stylesheet"/>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${baseURL}/">[LW2] - Client</a>

        </div>
    </div>
</nav>
<div class="jumbotron">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
                <ul class="list-inline">
                    <li><h3><a href="/${baseURL}">Home</a></h3></li>
                    <li><h3><a href="resume">Toutes les stbs</a></h3></li>
                    <li><h3><a href="insert">Ajouter une STB</a></h3></li>
                </ul>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                <h3>Coulon Matthieu - Brodier Quentin</h3>
            </div>
        </div>
    </div>
</div>

<div class="container">

    <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12 ">
            <div class="panel">
                <h3><a href="/${baseUrl}">Home</a></h3>
                <p>Liste des instructions</p>
            </div>
        </div>
        <div class="col-lg-12 col-md-12 col-sm-12 ">
            <div class="panel">
                <h3><a href="resume">Toutes les stbs</a></h3>
                <p>Afficher toutes les STBs, avec un lien pour afficher en détail une STB</p>
            </div>
        </div>
        <div class="col-lg-12 col-md-12 col-sm-12 ">
            <div class="panel">
                <h3><a href="insert">Ajouter une STB</a></h3>
                <p>Affiche le formulaire d'ajout de la STB</p>
            </div>
        </div>
    </div>
</div>

<spring:url value="/resources/core/js/hello.js" var="coreJs"/>
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs"/>
<spring:url value="/resources/core/js/main.js" var="mainJs"/>
<spring:url value="/resources/core/js/jquery.js" var="jqueryJS"/>

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="${jqueryJS}"></script>
<script src="${mainJs}"></script>

</body>
</html>