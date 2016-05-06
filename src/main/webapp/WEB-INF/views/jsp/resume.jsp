<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
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
            <a class="navbar-brand" href="/">[LW2] - Client</a>
        </div>
    </div>
</nav>

<div class="jumbotron">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
                <ul class="list-inline">
                    <li><h3><a href="/">Home</a></h3></li>
                    <li><h3><a href="/resume">Toutes les stbs</a></h3></li>
                    <li><h3><a href="/insert">Ajouter une STB</a></h3></li>
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
        <div class="col-lg-10">
            <c:if test="${not empty stb_list}">
                <table class="table table-bordered">
                    <tr>
                        <th>ID</th>
                        <th>Titre</th>
                        <th>version</th>
                        <th>date</th>
                        <th>description</th>

                    </tr>

                    <c:forEach items="${stb_list}" var="stb">
                        <tr>
                            <td>${stb.id}</td>
                            <td><a href="/resume/${stb.id}">${stb.titreProjet}</a></td>
                            <td>${stb.version}</td>
                            <td>${stb.date}</td>
                            <td>${stb.description}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${not empty stb}">
                <div class="panel">
                    <h3>${stb.titreProjet} _
                        <small>${stb.id}</small>
                    </h3>
                    <div class="panel">
                        <div class="row">
                            <div class="col-lg-4 col-md-4 col-sm-4">version : ${stb.version}</div>
                            <div class="col-lg-4 col-md-4 col-sm-4">${stb.date}</div>
                            <div class="col-lg-4 col-md-4 col-sm-4">${stb.description}</div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">Client</div>
                        <div class="panel-body">
                            <p><strong> entite </strong> : ${stb.client.entite}</p>
                            <p><strong> contact</strong> : ${stb.client.contact}</p>
                            <p><strong> code postal</strong> : ${stb.client.codePostal}</p>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">Equipe</div>
                        <div class="panel-body">

                            <div class="row">
                                <c:forEach items="${stb.equipeList}" var="equipe">
                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-6">
                                        <c:choose>
                                            <c:when test="${equipe.gender==true}">Homme</c:when>
                                            <c:otherwise>Femme</c:otherwise>
                                        </c:choose>
                                        <p>${equipe.nom}</p>
                                        <p>${equipe.prenom}</p>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-heading">Fonctionnalités</div>
                        <div class="panel-body">

                            <c:forEach items="${stb.fonctionnaliteList}" var="fct" varStatus="seq1">
                                <h5>${fct.description}_
                                    <small>${fct.priorite}</small>
                                </h5>
                                <table class="table">
                                    <tr>
                                        <th>identifiant</th>
                                        <th>description</th>
                                        <th>priorite</th>
                                    </tr>
                                    <c:if test="${not empty fct.getExigenceFonctionnelle()}" >
                                        <c:forEach items="${fct.getExigenceFonctionnelle()}" var="ef" varStatus="seq2">
                                        <tr>
                                            <td>${ef.identifiant}</td>
                                            <td>${ef.description}</td>
                                            <td>${ef.priorite}</td>
                                        </tr>
                                        </c:forEach>
                                    </c:if>
                                </table>
                            </c:forEach>
                        </div>
                    </div>

                </div>
            </c:if>
        </div>
    </div>

</div>

<spring:url value="/resources/core/css/hello.js" var="coreJs"/>
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs"/>
<spring:url value="/resources/core/css/jquery.js" var="jqueryJS"/>

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="${jqueryJS}"></script>

</body>
</html>