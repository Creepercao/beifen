import{_ as h,r as g,o as k,c as t,g as o,F as v,b as M,e as N,f as s,n as x,i as n,h as c,t as l,d as i,k as r}from"./index-CpKDPpXK.js";const C={class:"message-page"},E={class:"username"},w={key:0,class:"message-type"},B={key:1,class:"message-type"},L={key:2,class:"message-type"},V={key:0,class:"comment-content"},F={class:"message-time"},I={__name:"message",setup(O){const _=g([]),u=async()=>{try{const a=await N.get("/messages");_.value=a.data}catch(a){console.error("获取消息失败:",a)}};return k(()=>{u()}),(a,p)=>{const m=r("el-avatar"),d=r("el-col"),y=r("el-row"),f=r("el-card");return s(),t("div",C,[p[0]||(p[0]=o("h1",{class:"page-title"},"消息",-1)),(s(!0),t(v,null,M(_.value,e=>(s(),x(f,{class:"message-card",key:e.id},{default:n(()=>[c(y,null,{default:n(()=>[c(d,{span:4},{default:n(()=>[c(m,{src:e.userAvatar,size:"large"},null,8,["src"])]),_:2},1024),c(d,{span:20},{default:n(()=>[o("p",null,[o("span",E,l(e.userName),1),e.type==="LIKE"?(s(),t("span",w,"赞了你的动态")):e.type==="COMMENT"?(s(),t("span",B,"评论了你的动态")):e.type==="REPLY"?(s(),t("span",L,"回复了你的评论")):i("",!0)]),e.type==="COMMENT"?(s(),t("p",V,"“"+l(e.content)+"”",1)):i("",!0),o("p",F,l(e.time),1)]),_:2},1024)]),_:2},1024)]),_:2},1024))),128))])}}},b=h(I,[["__scopeId","data-v-7c3630c6"]]);export{b as default};
