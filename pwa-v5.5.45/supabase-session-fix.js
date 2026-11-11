/* V5.5.45 — correctif synchronisation Supabase à intégrer dans la base complète V5.5.44.
- restaurer la session avec auth.getSession() au démarrage ;
- createClient avec persistSession:true, autoRefreshToken:true, detectSessionInUrl:true ;
- ne jamais laisser une ancienne config vide écraser BPA_SUPABASE_DEFAULT ;
- mémoriser l'e-mail dans bpa_sync_email ;
- écouter onAuthStateChange pour garder PC/téléphone cohérents.
Le ZIP complet V5.5.45 contient l'implémentation effective. */