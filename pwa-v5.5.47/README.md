# V5.5.47 — correction stabilité après audit réel

Audit comparatif effectué entre la V5.5.41 fonctionnelle et la V5.5.46.

Causes trouvées :
1. la fonction updateDocumentPaymentLink() avait été supprimée accidentellement lors de l'ajout du forfait. applySettings() l'appelait au démarrage, provoquant une erreur JavaScript avant initSupabase(). C'est pourquoi l'écran Synchronisation restait sur le placeholder et « Non connecté » ;
2. autoCoefficient() était appelé alors que la fonction réelle de l'application est partsCoefficient(), ce qui cassait la modification du prix d'achat d'une pièce ;
3. V5.5.46 utilisait une nouvelle storageKey Supabase, empêchant de retrouver la session standard précédente.

Corrections V5.5.47 :
- updateDocumentPaymentLink restaurée ;
- partsCoefficient restauré ;
- stockage Auth Supabase standard restauré ;
- persistSession + autoRefreshToken conservés ;
- PDF / Imprimer reste directement lié à window.print() ;
- Forfait HT + temps réel + détail marges conservés ;
- nouvel en-tête sans voiture + prestations conservé ;
- cache PWA incrémenté V5.5.47.

ZIP complet : BEL-PERF-AUTO-PWA-V5-5-47-STABLE-CORRIGE.zip
