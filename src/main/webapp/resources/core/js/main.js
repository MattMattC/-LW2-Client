$( document ).ready(function() {
});

$('#addEquipe').on('click', function(){
    var nb_tr = $('#listEquipe tr').length+1;
    $('#nb_equipe').val(nb_tr);
    if(nb_tr<=7){


        $("#listEquipe").append("<tr><td><div class=\"radio\"><label>"+
            "<input type=\"radio\" name=\"equipe"+nb_tr+".gender\" value=\"true\"> Homme</label>"+
            "</div><div class=\"radio\"><label>"+
            "<input type=\"radio\" name=\"equipe"+nb_tr+".gender\" value=\"false\"> Femme</label>"+
            "</div></td><td>"+
            "<input class=\"form-control\" type=\"text\" name=\"equipe"+nb_tr+".nom\" placeholder=\"equipe : nom\"/>"+
            "</td><td> <input class=\"form-control\" type=\"text\" name=\"equipe"+nb_tr+".prenom\" placeholder=\"equipe : prenom\"/>"+
            "</td></tr>");
    }
});


$('#addFonctionnalite').on('click', function() {
    var next_id = $('.idFct').length +1 ;
    $('#nb_fct').val(next_id);
    console.log(next_id);


    $('#listFct').append(
        "<tr class=\"idFct\" idFct=\""+next_id+"\"><td><table class=\"table\"><tr>"+
        "<td><input class=\"form-control\" type=\"text\" name=\"fonctionnalite"+next_id+".description\" placeholder=\"fonctionnalite : description\"/></td>"+
        "<td><input class=\"form-control\" min=\"1\" max=\"10\" type=\"number\" name=\"fonctionnalite"+next_id+".priorite\" placeholder=\"fonctionnalite : priorite\"/></td>"+
        "</tr><tr><table class=\"table listEf"+next_id+"\"><input id=\"nb_ef"+next_id+"\" type=\"hidden\" name=\"nb_ef"+next_id+"\" value=\"2\"/><tr>"+
        "<td><input class=\"form-control\" min=\"1\" max=\"10\" type=\"number\" name=\"fonctionnalite"+next_id+".ef1.priorite\" placeholder=\"Exigence fct : priorite\"/></td>"+
        "<td><input class=\"form-control\" type=\"number\" name=\"fonctionnalite"+next_id+".ef1.identifiant\" placeholder=\"Exigence fct : identifiant\"/></td>"+
        "<td><input class=\"form-control\" type=\"text\" name=\"fonctionnalite"+next_id+".ef1.description\" placeholder=\"Exigence fct : description\"/></td>"+
        "</tr><tr><td><input class=\"form-control\" min=\"1\" max=\"10\" type=\"number\" name=\"fonctionnalite"+next_id+".ef2.priorite\" placeholder=\"Exigence fct : priorite\"/></td>"+
        "<td><input class=\"form-control\" type=\"number\" name=\"fonctionnalite"+next_id+".ef2.identifiant\" placeholder=\"Exigence fct : identifiant\"/></td>"+
        "<td><input class=\"f\orm-control\" type=\"text\" name=\"fonctionnalite"+next_id+".ef2.description\" placeholder=\"Exigence fct : description\"/></td>"+
        "</tr></table></tr><tr><td><a idFct=\""+next_id+"\" class=\"addEf btn btn-default\">+</a></td></tr></table></td></tr>"
    );

});

$('#listFct').on('click', '.addEf', function(){
    var id = $(this).attr('idFct');

    var nb_tr = $(".listEf"+id+" tr").length+1;
        console.log("nb ef : "+nb_tr);
    $("#nb_ef"+id).val(nb_tr);


    $(".listEf"+id).append("<tr><td><input class=\"form-control\" min=\"1\" max=\"10\" type=\"number\" name=\"fonctionnalite"+id+".ef"+nb_tr+".priorite\" placeholder=\"Exigence fct : priorite\"/></td>"+
        "<td><input class=\"form-control\" type=\"number\" name=\"fonctionnalite"+id+".ef"+nb_tr+".identifiant\" placeholder=\"Exigence fct : identifiant\"/></td>"+
        "<td><input class=\"form-control\" type=\"text\" name=\"fonctionnalite"+id+".ef"+nb_tr+".description\" placeholder=\"Exigence fct : description\"/></td> </tr>");
});