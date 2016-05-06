<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Student Information</h2>
<form:form method="POST" action="ajoutPost">
    <table>
        <tr>
            <td><form:label path="titreProjet">Titre du projet</form:label></td>
            <td><form:input path="titreProjet"/></td>
        </tr>
        <tr>
            <td><form:label path="version">Version</form:label></td>
            <td><form:input path="version"/></td>
        </tr>
        <tr>
            <td><form:label path="date">Date</form:label></td>
            <td><form:input path="date"/></td>
        </tr>
        <tr>
            <td><form:label path="Description">Description</form:label></td>
            <td><form:input path="Description"/></td>
        </tr>
        <tr>
            <td><form:label path="client.entite">Client : entite</form:label></td>
            <td><form:input path="client.entite"/></td>
        </tr>
        <tr>
            <td><form:label path="client.contact">Client : contact</form:label></td>
            <td><form:input path="client.contact"/></td>
        </tr>
        <tr>
            <td><form:label path="client.codePostal">Client : Code Postal</form:label></td>
            <td><form:input path="client.codePostal"/></td>
        </tr>
        <tr>
            <td><input name="equipe.gender"/><td>
        </tr>



        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>