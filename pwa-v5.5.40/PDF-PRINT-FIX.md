/* BEL-PERF'AUTO V5.5.40 — règle d'intégration pdf-light.js
Le fichier pdf-light.js de V5.5.39 peut rester chargé pour fournir bpaLightPdfBase64()
aux fonctions e-mail, MAIS il ne doit plus modifier #printInvoice.

Dans la source V5.5.40 complète, le bloc qui faisait :
  btn.textContent = 'Télécharger PDF'
  btn.onclick = downloadPdf
a été supprimé.

Le bouton #printInvoice reste donc géré par app.js :
  $('#printInvoice').onclick = () => window.print();

Résultat : PDF / Imprimer utilise le document graphique A4 de l'application
(logo, voiture, prestations, tableaux, mentions), au lieu du PDF texte simplifié.
