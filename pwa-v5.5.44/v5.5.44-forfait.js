/* V5.5.44 — logique métier forfait HT.
Mode hourly: vente = heures facturées × taux HT; coût = heures facturées × coût horaire interne.
Mode fixed: vente = montant forfait HT; coût = temps réel interne × coût horaire interne.
Les champs à persister sur chaque prestation sont billingMode ('hourly'|'fixed') et actualHours.
Les anciens documents sans billingMode restent en mode hourly.
Le détail de marge interne doit afficher: prestation, mode, temps réel, coût interne, vente HT, marge et marge %. */
function bpaLaborAmounts(line){
 const fixed=line.billingMode==='fixed';
 const billedHours=Number(line.qty)||0, rate=Number(line.pu)||0, costRate=Number(line.cost)||0;
 const actualHours=Number(line.actualHours ?? billedHours)||0;
 const sale=fixed?rate:billedHours*rate;
 const cost=(fixed?actualHours:billedHours)*costRate;
 const margin=sale-cost;
 return {sale,cost,margin,marginPct:sale?margin/sale*100:0};
}
