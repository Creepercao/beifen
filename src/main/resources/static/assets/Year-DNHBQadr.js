import{_ as h,h as C,c as o,a as r,d as V,w as c,r as d,o as s,F as u,x as _,f as x,B,y as p,C as w}from"./index-ChlhogER.js";const S={class:"timeline-container"},A=["onClick"],N={class:"article-time"},Y={__name:"Year",setup(b){const n=[{id:1,title:"Vue3 实战教程",date:"2024-12-25",year:2024},{id:2,title:"Element Plus 使用指南",date:"2024-10-12",year:2024},{id:3,title:"前端性能优化技巧",date:"2023-08-08",year:2023},{id:4,title:"JavaScript 深入浅出",date:"2023-05-01",year:2023},{id:5,title:"学习现代 CSS 布局",date:"2022-11-15",year:2022}].reduce((e,t)=>(e[t.year]||(e[t.year]=[]),e[t.year].push(t),e),{}),m=Object.keys(n).map(Number).sort((e,t)=>t-e).map(e=>({year:e,articles:n[e]})),i=C([]),f=e=>{alert(`正在查看文章: ${e.title}`)};return(e,t)=>{const v=d("el-collapse-item"),y=d("el-collapse");return s(),o("div",S,[t[1]||(t[1]=r("h1",{class:"page-title"},"文章年表",-1)),V(y,{modelValue:i.value,"onUpdate:modelValue":t[0]||(t[0]=a=>i.value=a),accordion:""},{default:c(()=>[(s(!0),o(u,null,_(w(m),({year:a,articles:k})=>(s(),x(v,{key:a,title:a,name:a},{default:c(()=>[r("ul",null,[(s(!0),o(u,null,_(k,l=>(s(),o("li",{key:l.id},[r("a",{href:"#",onClick:B(F=>f(l),["prevent"])},p(l.title),9,A),r("span",N,p(l.date),1)]))),128))])]),_:2},1032,["title","name"]))),128))]),_:1},8,["modelValue"])])}}},g=h(Y,[["__scopeId","data-v-60d07de3"]]);export{g as default};
