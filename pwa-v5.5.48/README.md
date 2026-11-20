# V5.5.48 — Suivi véhicules + Assistant IA atelier

Développement basé sur le ZIP complet V5.5.47 stable.

## Ajouts
- nouvel onglet Suivi véhicules, indépendant des ordres de réparation ;
- fiche permanente : immatriculation, VIN, marque, modèle, moteur, carburant, puissance, kilométrage, client, téléphone, notes ;
- chronologie interventions / entretiens / contrôles / notes / travaux à prévoir ;
- nouvel onglet Assistant IA atelier ;
- dictée vocale via SpeechRecognition quand disponible ;
- analyse serveur via Edge Function Supabase workshop-assistant ;
- validation obligatoire avant ajout au suivi véhicule ;
- aucune donnée manquante n'est inventée par le prompt IA.

## Supabase
Migration vehicle_tracking_ai_foundation appliquée au projet BEL-PERF-AUTO-PRO.
Tables : vehicle_tracking, vehicle_timeline, ai_workshop_drafts.
RLS par auth.uid().
Edge Function workshop-assistant déployée et ACTIVE.

## Validation build
node --check app.js : OK
unzip -t du ZIP complet : OK

Le fournisseur plaque/VIN n'est pas encore branché : le connecteur sera ajouté après sélection du fournisseur et validation du coût.
