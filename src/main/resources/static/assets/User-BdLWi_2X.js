import{_ as f,i as p,b as x,c as g,a as r,d as s,w as t,r as u,o as d,e as n,f as c,u as k,g as w}from"./index-ChlhogER.js";const B={setup(){const a=k(),e=w();return p.value,{activeMenu:x(()=>e.path),navigateTo:l=>{a.push(l)}}}},T={class:"container"},b={class:"sidebar"},M={class:"content"};function N(a,e,m,i,l,V){const o=u("el-menu-item"),_=u("el-menu"),v=u("router-view");return d(),g("div",T,[r("div",b,[e[5]||(e[5]=r("h2",{class:"mb-2"},"个人信息",-1)),s(_,{"default-active":i.activeMenu,class:"el-menu-vertical-demo",onSelect:i.navigateTo},{default:t(()=>[s(o,{index:"/user"},{default:t(()=>e[0]||(e[0]=[n("用户信息")])),_:1}),a.admin?(d(),c(o,{key:0,index:"/articles"},{default:t(()=>e[1]||(e[1]=[n("我的文章")])),_:1})):(d(),c(o,{key:1,index:"/articles"},{default:t(()=>e[2]||(e[2]=[n("文章列表")])),_:1})),s(o,{index:"/favorites"},{default:t(()=>e[3]||(e[3]=[n("收藏列表")])),_:1}),s(o,{index:"/edit"},{default:t(()=>e[4]||(e[4]=[n("修改用户信息")])),_:1})]),_:1},8,["default-active","onSelect"])]),r("div",M,[s(v)])])}const C=f(B,[["render",N]]);export{C as default};
