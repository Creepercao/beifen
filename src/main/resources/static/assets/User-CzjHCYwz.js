import{_ as m,b as v,c as f,a as r,d as t,w as o,r as i,o as p,e as n,u as x,f as w}from"./index-rr8r_Tiu.js";const T={setup(){const u=x(),e=w();return{activeMenu:v(()=>e.path),navigateTo:d=>{u.push(d)}}}},b={class:"container"},g={class:"sidebar"},B={class:"content"};function M(u,e,c,a,d,N){const s=i("el-menu-item"),l=i("el-menu"),_=i("router-view");return p(),f("div",b,[r("div",g,[e[4]||(e[4]=r("h2",{class:"mb-2"},"个人信息",-1)),t(l,{"default-active":a.activeMenu,class:"el-menu-vertical-demo",onSelect:a.navigateTo},{default:o(()=>[t(s,{index:"/user"},{default:o(()=>e[0]||(e[0]=[n("用户信息")])),_:1}),t(s,{index:"/articles"},{default:o(()=>e[1]||(e[1]=[n("文章列表")])),_:1}),t(s,{index:"/favorites"},{default:o(()=>e[2]||(e[2]=[n("收藏列表")])),_:1}),t(s,{index:"/edit"},{default:o(()=>e[3]||(e[3]=[n("修改用户信息")])),_:1})]),_:1},8,["default-active","onSelect"])]),r("div",B,[t(_)])])}const k=m(T,[["render",M]]);export{k as default};
