(()=>{"use strict";var e={928:(e,t)=>{Object.defineProperty(t,"__esModule",{value:!0}),t.BDCandidato=void 0,t.BDCandidato=class{add(e){let t=this.get();t.push(e),localStorage.setItem("candidatos",JSON.stringify(t))}get(){const e=localStorage.getItem("candidatos");return e?JSON.parse(e):[]}}},484:(e,t,a)=>{Object.defineProperty(t,"__esModule",{value:!0}),t.CandidatoUsuario=void 0;const s=a(860);class o extends s.Usuario{constructor(e,t,a,s,o,i,c,d){super(e,s,o,i,c,d),this.nome=e,this.idade=t,this.cpf=a,this.estado=s,this.cep=o,this.email=i,this.competencias=c,this.descricao=d}getObject(){return{nome:this.nome,idade:this.idade,cpf:this.cpf,estado:this.estado,cep:this.cep,email:this.email,competencias:this.competencias,descricao:this.descricao}}}t.CandidatoUsuario=o},860:(e,t)=>{Object.defineProperty(t,"__esModule",{value:!0}),t.Usuario=void 0,t.Usuario=class{constructor(e,t,a,s,o,i){this.nome=e,this.estado=t,this.cep=a,this.email=s,this.competencias=o,this.descricao=i}}}},t={};function a(s){var o=t[s];if(void 0!==o)return o.exports;var i=t[s]={exports:{}};return e[s](i,i.exports,a),i.exports}(()=>{const e=a(928),t=a(484);let s,o,i,c,d,r,n,l=[];const u=document.forms.namedItem("form1");null==u||u.addEventListener("submit",(a=>{if(a.preventDefault(),function(){let e=!0;return["nome","idade","cpf","estado","cep","email","descricao"].forEach((t=>{const a=document.getElementById(t);a&&""!==a.value.trim()||(e=!1)})),e}()){const a=new t.CandidatoUsuario(s,o,i,c,d,r,l,n);(new e.BDCandidato).add(a),alert("Cadastro realizado com sucesso!"),window.location.href=`perfilCandidato.html?cpf=${encodeURIComponent(i)}`}else alert("Por favor, preencha todos os campos obrigatórios.")})),["nome","idade","cpf","estado","cep","email","descricao"].forEach((e=>{const t=document.getElementById(e);null==t||t.addEventListener("change",(()=>{switch(e){case"nome":s=t.value;break;case"idade":o=parseInt(t.value,10);break;case"cpf":i=t.value;break;case"estado":c=t.value;break;case"cep":d=t.value;break;case"email":r=t.value;break;case"descricao":n=t.value}}))})),document.querySelectorAll('input[name="competencias[]"]').forEach((e=>{e.addEventListener("change",(()=>{e.checked?l.push(e.value):l=l.filter((t=>t!==e.value))}))}))})()})();

