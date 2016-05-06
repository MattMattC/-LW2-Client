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
            <a class="navbar-brand" href="/${baseURL}/">[LW2] - Client</a>
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
    <c:if test="${not empty erreur}">
        <div class="alert alert-info">
            ${erreur}
        </div>
    </c:if>

    <div class="row">
        <div class="col-lg-10">
            <h3>Ajout d'une STB</h3>
            <form method="POST" action="insertPost">
                <table class="table">
                    <tr>
                        <td>
                            <p class="text-center">titre</p>
                            <input required class="form-control" type="text" name="titreProjet" placeholder="titre"/>
                        </td>
                        <td>
                            <p class="text-center">version</p>
                            <input required class="form-control" name="version" placeholder="version"/>
                        </td>
                        <td>
                            <p class="text-center">date</p>
                            <input required class="form-control" type="date" name="date"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p>description</p>
                            <input required class="form-control" type="text" name="description" placeholder="description"/>
                        </td>
                    </tr>
                </table>

                <table class="table">
                    <tr>
                        <td>
                            <input required class="form-control" type="text" name="client.entite" placeholder="client : entite"/>
                        </td>
                        <td>
                            <input required class="form-control" type="text" name="client.contact"
                                   placeholder="client : contact"/>
                        </td>
                        <td>
                            <input required class="form-control" type="number" name="client.codePostal"
                                   placeholder="client : code postal"/>
                        </td>
                    </tr>
                </table>
                <table class="table">
                    <tr>
                        <td><h3> Equipe </h3></td>
                    </tr>
                    <!-- minimum 2 max 7 -->
                    <tr>
                        <td>
                            <table class="table" id="listEquipe">
                                <input required class="form-control" id="nb_equipe" type="hidden" name="nb_equipe" value="2"/>
                                <tr>
                                    <td>
                                        <div class="radio">
                                            <label>
                                                <input required type="radio" name="equipe1.gender" value="true"> Homme

                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="equipe1.gender" value="false"> Femme
                                            </label>
                                        </div>
                                    </td>
                                    <td>
                                        <input required class="form-control" type="text" name="equipe1.nom"
                                               placeholder="equipe : nom"/>
                                    </td>
                                    <td>
                                        <input required class="form-control" type="text" name="equipe1.prenom"
                                               placeholder="equipe : prenom"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="radio">
                                            <label>
                                                <input required type="radio" name="equipe2.gender" value="true"> Homme

                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="equipe2.gender" value="false"> Femme
                                            </label>
                                        </div>
                                    </td>
                                    <td>
                                        <input required class="form-control" type="text" name="equipe2.nom"
                                               placeholder="equipe : nom"/>
                                    </td>
                                    <td>
                                        <input required class="form-control" type="text" name="equipe2.prenom"
                                               placeholder="equipe :  prenom"/>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td><a id="addEquipe" class="btn btn-default">+</a></td>
                    </tr>

                    <tr>
                        <td><h3> Liste de fonctionnalitees</h3></td>
                    </tr>

                    <tr>
                        <td>
                            <table class="table" id="listFct">
                                <input id="nb_fct" type="hidden" name="nb_fct" value="1"/>

                                <tr class="idFct" idFct="1">
                                    <td>
                                        <table class="table">
                                            <tr>
                                                <td><input required class="form-control" type="text" name="fonctionnalite1.description"
                                                           placeholder="fonctionnalite : description"/></td>
                                                <td><input required class="form-control" type="number" min="1" max="10" name="fonctionnalite1.priorite"
                                                           placeholder="fonctionnalite : priorite"/></td>

                                            </tr>
                                            <tr>
                                                <table class="table listEf1">
                                                    <input required id="nb_ef1" type="hidden" name="nb_ef1" value="2"/>
                                                    <tr>
                                                        <td><input required class="form-control" type="number" min="1" max="10" name="fonctionnalite1.ef1.priorite"
                                                                   placeholder="Exigence fct : priorite"/>
                                                        </td>
                                                        <td><input required class="form-control" type="number" name="fonctionnalite1.ef1.identifiant"
                                                                   placeholder="Exigence fct : identifiant"/></td>
                                                        <td><input required class="form-control" type="text" name="fonctionnalite1.ef1.description"
                                                                   placeholder="Exigence fct : description"/></td>
                                                    </tr>
                                                    <tr>
                                                        <td><input required  class="form-control" type="number" min="1" max="10" name="fonctionnalite1.ef2.priorite"
                                                                   placeholder="Exigence fct : priorite"/>
                                                        </td>
                                                        <td><input class="form-control" type="number" name="fonctionnalite1.ef2.identifiant"
                                                                   placeholder="Exigence fct : identifiant"/></td>
                                                        <td><input class="form-control" type="text" name="fonctionnalite1.ef2.description"
                                                                   placeholder="Exigence fct : description"/></td>
                                                    </tr>
                                                </table>
                                            </tr>
                                            <tr>
                                                <td><a idFct="1" class="addEf btn btn-default">+</a></td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>

                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td><a id="addFonctionnalite" class="btn btn-default">Ajouter fonctionnalite</a></td>
                    </tr>

                </table>
                <hr/>
                <input class="btn btn-default" type="submit" value="Envoyer"/>
            </form>

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