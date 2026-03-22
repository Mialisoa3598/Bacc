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