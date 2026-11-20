# V5.5.49 — Identification véhicule par plaque + cache

- Ajout du bouton **Identifier avec la plaque** dans Suivi véhicules.
- Edge Function Supabase `vehicle-lookup` ACTIVE, JWT requis.
- Secret fournisseur attendu côté Supabase : `RAPIDAPI_KEY` (jamais exposé au navigateur).
- Cache `vehicle_lookup_cache` protégé par RLS.
- Une plaque déjà recherchée est relue depuis le cache : pas de nouvel appel fournisseur.
- Remplissage automatique selon disponibilité : VIN, marque, modèle/version, code moteur, carburant, puissance, K-Type, CNIT, cylindrée.
- Saisie manuelle conservée si une donnée est absente.
- Build complet basé sur V5.5.48.
- `node --check app.js` OK ; `unzip -t` OK.

La recherche de nouvelles plaques restera volontairement en attente tant que la clé RapidAPI du plan choisi n'est pas enregistrée dans les secrets Supabase.
