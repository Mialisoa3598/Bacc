# Forage d’eau  
Devis : 
    ny étude tsy voatery atao   
(Firy % client nanaiky nanaovana étude (sur terrain))
Azo/tsia : étude sur le terrain  
Si oui -> devis forage  
Faire forage : ovina nanomboka , nahazo rano, teste sanitaire. 

En faite, un client fait un demande de forage d'eau a un entreprise, et l'entreprise donne de devis au client, bien sur il y a plusieur type de devis comme : etude du terrain, forage, analyse d'eau ...
client 1 -> plusieurs demandes; demande 1 -> client 1
Demande 1 -> plusieurs devis; devis 1 -> demande 1
devis 1 -> 1 type ; type 1 -> plusieurs devis 

## Entite :
* **Demande :**  date, Client, lieu, district, *devis(S)*
* **Client :**  nom, contact, *demande(S)*
* **TypeDevis :**  libelle, *devis(S)*
* **Devis :**  montantTotal, *typedevis*, date, *demande*, *detailDevis(S)*
* **DetailDevis :**  devis, libelle, montant
* **Status :**  libelle, *demandeStatus*
* **DemandeStatus :**  *demande*, *status*, date

on va faire un sprint3-bis toujours dans forage :
Maintenant on va utiliser transactional c'est a dire:
lorsqu'on insert demande -Transactional-> insert Demande creer (Status)
    -> creer demande deviens transactional
    devient : Liste DetailDevis; Objet Devis -> transactional, puis save(inserer) Devis et recup ID -> FK DetailDevis. Dans Statut Creer -> transactional -> DemandeStatut (Devis Etude Creer, Devis Etude accepter,...)
les typedevis ne seront que 2 : Etude et Forage seulement


Sprint 4 :
Toujours en Transactional.
Ajout Devis se fera comme ceci :
    - Select Demande : (exemple Demande 2) 
        -> Puis Details demande s'affiche (utiliser ajax qui fait appel a un api controller), bien sur en fonction du select demande
    - Type devis : 
        -> Etude, Forage
    - Ligne ajout Detail devis : Libelle , P.U, Montant(pas stocker dans la base mais calculer automatique js) avec bouton + pour ajout autrer ligne et un x pour supprimer cette ligne (js)
    - Montant Total (pas stocker dans la base mais calculer automatique js)
les modifications dans la base :
plus de montant ny montanttotal dans devis et detaisdevis 
detailsDevis ajout de PU, Qte

As tu compris? logique avant de developper';

Merci Tout est OK maintenant on va passer au sprint 7 car ca devrait etre 6 le dashboard qu'on vient de faire mais ce n'est pas grave maintenant on va passer au sprint 7 qui est :
Savoir Temps/durée de traitement pour chaque demande, savoir le temps de traitement entre les demandes. Pour ca on ajoute 2 colonnes dans la table t_demande_status, Pourquoi 2 ? car on va utiliser 2 approche pour calculer la dureer,duree simple pour l'approche1 et duree complexe pour l'approche 2.

1er approche simple -> Duration.between(date1, date2) return tohours(). Dans cette methode on va utiliser le plus proche c'est a dire calculer la dureer entre 2 dates (heures precis). On compte 24h.
exemple :
lundi a 16h30 demande cree
mardi a 8h30 devis cree donc la duree est de 16h 

2eme approche complexe -> On va devoir etre realiste sur cette methode, c'est a dire on ne vas pas compter les week-ends (samedi et dimanche), on vas pouvoir aussi dire que l'on travail de 8h a 17h par exemple. Pour cela on va creer une table t_parametre car on va pouvoir changer l'heure de travail mais aussi changer les dates ou on ne pourra pas travailler.
exemple :
lundi a 16h30 demande cree
mardi a 8h30 devis cree donc la duree est juste 1h

La durée est calculée entre deux DemandeStatus consécutifs d'une même demande
La table t_parametre — c'est une nouvelle table spécifique au sprint 7 dans forage
Elle contiendrait :
Heure début travail (ex: 8h)
Heure fin travail (ex: 17h)
Jours fériés/exceptionnels
Les week-ends dépendent aussi dans le paramètre
Pour l'exemple lundi 16h30 → mardi 8h30 = 1h — le raisonnement est :
Lundi : de 16h30 à 17h00 = 30 min de travail restant
Mardi : de 8h00 à 8h30 = 30 min de travail
Total = 1h

As-tu compris? logique avant de developper
Pose moi des questions pour mieux t'aider dans la logique.
Puis developpe les fontionnalites claire pour ce sprint 7.

C'est ok mais le probleme est que si maintenant je modifie la date dans l'historique les durees ne changent pas par rapport a la date modifier aussi