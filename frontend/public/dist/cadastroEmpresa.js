(()=>{"use strict";let e="",a="",c="",t="",o="",n="",s=[],r="";const l=document.forms.namedItem("form2");null==l||l.addEventListener("submit",(l=>{var i;l.preventDefault(),function(e,a,c,t,o,n,s,r){return""!==e&&""!==a&&""!==c&&""!==t&&""!==o&&""!==n&&r.length>0&&""!==s}(e,a,c,t,o,n,r,s)?(i={nome:e,cnpj:c,pais:t,estado:o,cep:n,email:a,descricao:r,competencias:s},localStorage.setItem(i.cnpj,JSON.stringify(i)),alert("Cadastro realizado com sucesso!"),window.location.href=`perfilEmpresa.html?cnpj=${encodeURIComponent(c)}`):alert("Por favor, preencha todos os campos obrigatórios.")})),["nome","email","cnpj","pais","estado","cep","descricao"].forEach((s=>{const l=document.getElementById(s);null==l||l.addEventListener("change",(()=>{switch(s){case"nome":e=l.value;break;case"email":a=l.value;break;case"cnpj":c=l.value;break;case"pais":t=l.value;break;case"estado":o=l.value;break;case"cep":n=l.value;break;case"descricao":r=l.value}}))})),document.querySelectorAll('input[name="competencias[]"]').forEach((e=>{e.addEventListener("change",(()=>{e.checked?s.push(e.value):s=s.filter((a=>a!==e.value))}))}))})();