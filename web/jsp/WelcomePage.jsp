<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Se connecter</title>
        <SCRIPT LANGUAGE="JavaScript">
        Today = new Date;
        Jour = Today.getDate();
        Mois = (Today.getMonth())+1;
        Annee = Today.getFullYear();
        Message = "Nous sommes le : " + Jour + "/" + Mois + "/" + Annee;
        </SCRIPT>
	<link href="css/j.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Welcome</h1>
        <ul>
            <li><a href="WelcomePageCtrl?fct=banker">Banker</a></li>
            <li><a href="WelcomePageCtrl?fct=visitor">Visitor</a></li>
        </ul>
        
        <div>${requestScope.msg_erreur}<div>
        <hr>

    </body>
</html>