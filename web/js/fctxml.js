/**
 * Cette méthode "Ajax" affiche le XML.
 *
 * On utilise la propriété 'responseText' de l'objet XMLHttpRequest afin
 * de récupérer sous forme de texte le flux envoyé par le serveur.
 */
function afficheXML ()
	{
	// Objet XMLHttpRequest.
	var xhr = new XMLHttpRequest();

	// Requête au serveur avec les paramètres éventuels.
	xhr.open("GET","ServletAuteur");

	// On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
	xhr.onload = function()
		{
		// Si la requête http s'est bien passée.
		if (xhr.status === 200)
			{
			// Elément html que l'on va mettre à jour.
			var elt = document.getElementById("tt_zone");
			elt.innerHTML = xhr.responseText;
			}
		};

	// Envoie de la requête.
	xhr.send();
	}


/**
 * Cette méthode "Ajax" affiche la liste des auteurs.
 *
 * Utilise la propriété 'responseXML' de l'objet XMLHttpRequest afin
 * de récupérer sous forme d'arbre DOM le document XML envoyé par le serveur.
 */
function l_auteurs ()
	{
        // Objet XMLHttpRequest.
	var xhr = new XMLHttpRequest();

	// Requête au serveur avec les paramètres éventuels.
	xhr.open("GET","ServletAuteur");

	// On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
	xhr.onload = function()
		{
		// Si la requête http s'est bien passée.
		if (xhr.status === 200)
			{
			// Elément html que l'on va mettre à jour.
			var elt = document.getElementById("lnom");
                        
                        // Lecture du fichier XML
			var noms = xhr.responseXML.getElementsByTagName("nom");
                        
                        elt.innerHTML = "<option>-----</option>";
                        for(i=0; i<noms.length; i++)
                            elt.insertAdjacentHTML("beforeend", "<option>"+noms[i].firstChild.nodeValue+"</option>");
			}
		};

	// Envoie de la requête.
	xhr.send();
            
	}


/**
 * Cette méthode "Ajax" affiche la liste des citations.
 *
 * Utilise la propriété 'responseXML' de l'objet XMLHttpRequest afin
 * de récupérer sous forme d'arbre DOM le document XML envoyé par le serveur.
 */
function l_citations ()
	{
        // Objet XMLHttpRequest.
	var xhr = new XMLHttpRequest();
        var param = document.getElementById("lnom").value;
	// Requête au serveur avec les paramètres éventuels.
	xhr.open("GET","ServletCitation?nomauteur="+param);

	// On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
	xhr.onload = function()
		{
		// Si la requête http s'est bien passée.
		if (xhr.status === 200)
			{
			// Elément html que l'on va mettre à jour.
			var elt = document.getElementById("lcitations");
                        
                        // Lecture du fichier XML
                        var ch = "<ul>";
			var cit = xhr.responseXML.getElementsByTagName("citation");
                        
                        
                        for(i=0; i<cit.length; i++)
                            ch += "<li>"+cit[i].firstChild.nodeValue+"</li>";
			}
                        elt.innerHTML = ch + "</ul>";
		};

	// Envoie de la requête.
	xhr.send();
           
	}


/**
 * Cette méthode "Ajax" simule la zone de recherche 'Google'.
 */
function processKey ()
	{
        // Objet XMLHttpRequest.
	var xhr = new XMLHttpRequest();
        var param = document.getElementById("saisie").value;
	// Requête au serveur avec les paramètres éventuels.
	xhr.open("GET","ServletGoogle?mot_input="+param);

	// On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
	xhr.onload = function()
		{
		// Si la requête http s'est bien passée.
		if (xhr.status === 200)
			{
                        var elt = document.getElementById("zoneaff");
                        
                        // Lecture du fichier XML
                        var textAff = "";
			var textes = xhr.responseXML.getElementsByTagName("texte");
                        
                        if(param == ""){
                            elt.innerHTML = textAff;
                            elt.style.display = "none";
                        }else{
                            for(i=0; i<textes.length; i++)
                                textAff += textes[i].firstChild.nodeValue +"</br>";
                            }
                            elt.innerHTML = textAff;
                            elt.style.display = "block";	
                        }
		};

	// Envoie de la requête.
	xhr.send();
           
	}

/**
 * Cette méthode "Ajax" simule pour 'formAdd'.
 */
function l_formulaire ()
	{
        // Objet XMLHttpRequest.
	var xhr = new XMLHttpRequest();
        var param = document.getElementById("zoneForm").value;
	// Requête au serveur avec les paramètres éventuels.
	xhr.open("GET","ServletSaisie?mot_input="+param);

	// On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
	xhr.onload = function()
		{
		// Si la requête http s'est bien passée.
		if (xhr.status === 200)
			{
                        var elt = document.getElementById("zoneAdd");
                        
                        // Lecture du fichier XML
			var textAff = "<div">+xhr.responseXML.getElementsByTagName("resultat").firstChild.nodeValue+"</div>";
			}
                        elt.insertAdjacentHTML("afterend", textAff);			
		};

	// Envoie de la requête.
	xhr.send();
           
	}


/**
 * Cette méthode "Ajax" permet de tester les paramètres passés par l'url.
 */
function testEncodeUrl ()
	{
	// Objet XMLHttpRequest.
	var xhr = new XMLHttpRequest();

	// Requête au serveur avec les paramètres éventuels.
	var param = "texte=" + encodeURIComponent(document.getElementById("envoie").value);
	var url = "ServletEncode";
	alert(url + "?" + param);

	xhr.open("POST",url,true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

	// On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
	xhr.onload = function()
		{
		// Si la requête http s'est bien passée.
		if (xhr.status === 200)
			// Elément html que l'on va mettre à jour.
			document.getElementById("recue").value = xhr.responseXML.getElementsByTagName("msg")[0].firstChild.nodeValue ;
		};

	// Envoie de la requête.
	xhr.send(param);
	}


/**
 * Lancement après le chargement du DOM.
 */
document.addEventListener("DOMContentLoaded", () => {

    document.getElementById("bt_zone").addEventListener("click",afficheXML);
    document.getElementById("bt_auteurs").addEventListener("click",l_auteurs);
    document.getElementById("lnom").addEventListener("change",l_citations);
    document.getElementById("saisie").addEventListener("input",processKey);
    document.getElementById("bt_Url").addEventListener("click",testEncodeUrl);
    document.getElementById("zoneAdd").addEventListener("keyup",l_formulaire);
    
});
