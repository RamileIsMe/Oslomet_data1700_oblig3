function kjopBillett(){
    let nyFilm = $("#film").val();
    let nyAntall = $("#antall").val();
    let nyFornavn = $("#fornavn").val();
    let nyEtternavn = $("#etternavn").val();
    let nyTel = $("#tel").val();
    let nyMail = $("#mail").val();

    let feil = false
    if (nyFilm === "Velg film her"){
        $("#ffilm").html("Velg en film").css("color","red");
        feil = true;
    }else{
        $("#ffilm").html("");
    }

    if (nyAntall === "" || nyAntall === "0"){
        $("#fantall").html("Obligatorisk felt*").css("color","red");
        feil = true;
    }else {
        $("#fantall").html("");
    }

    if (nyFornavn === ""){
        $("#fnavn").html("Obligatorisk felt*").css("color","red");
        feil = true;
    }else {
        $("#fnavn").html("");
    }

    if (nyEtternavn === ""){
        $("#fetter").html("Obligatorisk felt *").css("color","red");
        feil = true;
    }else{
        $("#fetter").html("");
    }

    if (nyTel === "" || isNaN(nyTel)){
        $("#fnr").html("Obligatorisk felt *").css("color","red");
        feil = true;
    } else{
        $("#fnr").html("")
    }

    if (nyMail === ""){
        $("#fmail").html("Obligatorisk felt *").css("color","red");
        feil = true;
    }else{
        $("#fmail").html("")
    }

    const billett ={
        film : nyFilm,
        antall : nyAntall,
        fornavn :nyFornavn,
        etternavn : nyEtternavn,
        tel : nyTel,
        mail : nyMail,
    };

    if (feil === false){
        $.post("/lagre", billett, function(){
            visKvitto();
        });
        $("#film").val("Velg film her");
        $("#antall").val("");
        $("#fornavn").val("");
        $("#etternavn").val("");
        $("#tel").val("");
        $("#mail").val("");
    }
}

function visKvitto(){
    $.get("/visKvitto", function(data){
        formaterData(data);
    });
}

function formaterData(billetter){
    let ut = "<table><tr><th>Film</th><th>Antall</th><th>Fornavn</th><th>Etternavn</th><th>Tel</th><th>Mail</th></tr>"
    for (const billett of billetter){
        ut += "<tr><td>" + billett.film + "</td><td>" + billett.antall + "</td><td>" + billett.fornavn + "</td><td>" +
            billett.etternavn + "</td><td>" + billett.tel + "</td><td>"+ billett.mail + "</td></tr>";
    }
    ut += "</table>";
    $("#kvitto").html(ut);
}

function slettAlle(){
    $.get("/slettAlle",function(){
        $("#kvitto").html("Du har ingen billetter.");
    })

}