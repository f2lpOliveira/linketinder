(()=>{"use strict";var e={928:(e,t)=>{Object.defineProperty(t,"__esModule",{value:!0}),t.BDCandidato=void 0,t.BDCandidato=class{add(e){let t=this.get();t.push(e),localStorage.setItem("candidatos",JSON.stringify(t))}get(){const e=localStorage.getItem("candidatos");return e?JSON.parse(e):[]}}},408:(e,t)=>{Object.defineProperty(t,"__esModule",{value:!0}),t.BDEmpresa=void 0,t.BDEmpresa=class{add(e){let t=this.get();t.push(e),localStorage.setItem("empresas",JSON.stringify(t))}get(){const e=localStorage.getItem("empresas");return e?JSON.parse(e):[]}}}},t={};function n(o){var c=t[o];if(void 0!==c)return c.exports;var s=t[o]={exports:{}};return e[o](s,s.exports,n),s.exports}(()=>{const e=n(408),t=n(928);document.addEventListener("DOMContentLoaded",(()=>{const n=(new e.BDEmpresa).get(),o=new URLSearchParams(window.location.search).get("cnpj");if(!o)return void console.error("CNPJ não encontrado na URL.");const c=n.find((e=>e.cnpj===o));c?function(e){const t=document.querySelector(".nome");t&&(t.textContent=e.nome);const n=document.querySelector(".email");n&&(n.textContent=e.email);const o=document.querySelector("ul.dadosGeograficos");o&&(o.children[0].textContent=e.pais+",",o.children[1].textContent=e.estado+",",o.children[2].textContent=e.cep);const c=document.querySelector(".cnpj");c&&(c.textContent=e.cnpj);const s=document.querySelector(".competencias");s&&(s.innerHTML=e.competencias.map(((e,t,n)=>t<n.length-1?`<li class="me-1">${e},</li>`:`<li class="me-1">${e}</li>`)).join(""));const r=document.querySelector(".descricao");r&&(r.textContent=e.descricao)}(c):console.error("Empresa não encontrada."),function(e){const t=document.getElementById("lista-candidatos");t&&(t.innerHTML="",e.forEach((e=>{var n,o;t.innerHTML+=`\n                <div class="candidato">\n                    <h2>${o=e.nome,o.slice(0,2)+o.slice(2).replace(/./g,"*")}</h2>\n                    <p>Email: ${function(e){const t=e.split("@"),n=t[0],o=n.length;return n.slice(0,3)+"***"+n.slice(o-2,o)+"@"+t[1]}(e.email)}</p>\n                    <p>CPF: ${n=e.cpf,n.replace(/\d/g,"*")}</p>                    \n                    <p>Competências: ${e.competencias.slice(0,-1).join(", ")}${e.competencias.length>1?",":""} ${e.competencias.slice(-1)}</p>                    \n                    <p>Descrição: ${e.descricao}</p>\n                </div>\n            `})))}((new t.BDCandidato).get())}))})()})();