# V5.5.50 — Correction identification par plaque

- Edge Function Supabase vehicle-lookup passée en version 3.
- Paramètres alignés sur le point /get-vehicule-info affiché par le fournisseur : nom_hote, immatriculation, pays.
- Plaques SIV normalisées au format AA-123-BC avant l'appel.
- Mapping ajouté pour les champs documentés : energieNGC, puisFisc, puisFiscReel, type_mine, sra_commercial, date1erCir_us/fr.
- Erreurs fournisseur renvoyées en texte exploitable.
- Interface corrigée : plus d'affichage [object Object], les erreurs JSON sont converties en message lisible.
- Cache Supabase conservé pour éviter de repayer une plaque déjà identifiée.
- node --check app.js : OK.
- test intégrité ZIP : OK.

Le secret RAPIDAPI_KEY reste uniquement dans Supabase.
